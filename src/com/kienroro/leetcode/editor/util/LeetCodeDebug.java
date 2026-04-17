package com.kienroro.leetcode.editor.util;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public final class LeetCodeDebug {
    private LeetCodeDebug() {
    }

    public static String[] defaultArgs(String exampleTestcases) {
        return normalizeLines(exampleTestcases);
    }

    public static String[] defaultArgs(Object solution, String exampleTestcases) {
        List<String[]> cases = defaultArgCases(solution, exampleTestcases);
        return cases.isEmpty() ? new String[0] : cases.get(0);
    }

    public static List<String[]> defaultArgCases(Object solution, String exampleTestcases) {
        Objects.requireNonNull(solution, "solution must not be null");

        String[] lines = normalizeLines(exampleTestcases);
        if (lines.length == 0) {
            return Collections.emptyList();
        }

        int parameterCount = resolveMethod(solution.getClass()).getParameterCount();
        if (parameterCount == 0) {
            return Collections.singletonList(new String[0]);
        }

        if (lines.length <= parameterCount) {
            return Collections.singletonList(Arrays.copyOf(lines, lines.length));
        }

        List<String[]> cases = new ArrayList<>();
        for (int index = 0; index + parameterCount <= lines.length; index += parameterCount) {
            cases.add(Arrays.copyOfRange(lines, index, index + parameterCount));
        }

        if (cases.isEmpty()) {
            cases.add(Arrays.copyOf(lines, Math.min(parameterCount, lines.length)));
        }

        return cases;
    }

    private static String[] normalizeLines(String exampleTestcases) {
        if (exampleTestcases == null) {
            return new String[0];
        }

        String normalized = exampleTestcases.strip();
        if (normalized.isEmpty()) {
            return new String[0];
        }

        return normalized.lines()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .toArray(String[]::new);
    }

    public static Object run(Object solution, String... rawArgs) {
        Objects.requireNonNull(solution, "solution must not be null");

        Method method = resolveMethod(solution.getClass());
        Type[] genericTypes = method.getGenericParameterTypes();
        Class<?>[] rawTypes = method.getParameterTypes();

        if (rawArgs.length != rawTypes.length) {
            throw new IllegalArgumentException(
                    "Expected " + rawTypes.length + " arguments for " + method.getName() +
                            " but got " + rawArgs.length + ": " + Arrays.toString(rawArgs)
            );
        }

        Object[] parsedArgs = new Object[rawTypes.length];
        for (int i = 0; i < rawTypes.length; i++) {
            Object parsed = parseLiteral(rawArgs[i]);
            parsedArgs[i] = convert(parsed, genericTypes[i], rawTypes[i]);
        }

        try {
            method.setAccessible(true);
            return method.invoke(solution, parsedArgs);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Failed to invoke " + method.getName(), e);
        }
    }

    public static void expect(String label, Object actual, Object expected) {
        String actualText = stringify(actual);
        String expectedText = stringify(expected);
        if (!Objects.equals(actualText, expectedText)) {
            throw new AssertionError(label + " expected " + expectedText + " but got " + actualText);
        }
        System.out.println(label + " = " + actualText);
    }

    public static String stringify(Object value) {
        if (value == null) {
            return "null";
        }

        Class<?> clazz = value.getClass();
        if (clazz.isArray()) {
            return stringifyArray(value);
        }
        if (value instanceof Iterable<?> iterable) {
            List<String> parts = new ArrayList<>();
            for (Object item : iterable) {
                parts.add(stringify(item));
            }
            return "[" + String.join(", ", parts) + "]";
        }
        if (value instanceof Map<?, ?> map) {
            Map<String, String> ordered = new LinkedHashMap<>();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                ordered.put(stringify(entry.getKey()), stringify(entry.getValue()));
            }
            return ordered.toString();
        }
        if (isTreeNodeType(clazz)) {
            return stringifyTree(value);
        }
        if (isListNodeType(clazz)) {
            return stringifyLinkedList(value);
        }
        if (value instanceof Character c) {
            return "'" + c + "'";
        }
        if (value instanceof String s) {
            return "\"" + s + "\"";
        }
        return String.valueOf(value);
    }

    private static Method resolveMethod(Class<?> solutionClass) {
        List<Method> candidates = new ArrayList<>();
        for (Method method : solutionClass.getDeclaredMethods()) {
            if (method.isSynthetic() || method.isBridge()) {
                continue;
            }
            if (Modifier.isStatic(method.getModifiers())) {
                continue;
            }
            if (method.getName().startsWith("lambda$")) {
                continue;
            }
            candidates.add(method);
        }

        if (candidates.isEmpty()) {
            throw new IllegalStateException("No callable method found in " + solutionClass.getName());
        }

        candidates.sort((left, right) -> {
            boolean leftPublic = Modifier.isPublic(left.getModifiers());
            boolean rightPublic = Modifier.isPublic(right.getModifiers());
            if (leftPublic != rightPublic) {
                return leftPublic ? -1 : 1;
            }
            int byName = left.getName().compareTo(right.getName());
            if (byName != 0) {
                return byName;
            }
            return Integer.compare(left.getParameterCount(), right.getParameterCount());
        });

        return candidates.get(0);
    }

    private static Object parseLiteral(String raw) {
        if (raw == null) {
            return null;
        }
        return new Parser(raw).parse();
    }

    private static Object convert(Object value, Type genericType, Class<?> rawType) {
        if (genericType instanceof ParameterizedType parameterizedType &&
                List.class.isAssignableFrom(rawType)) {
            return convertToList(value, parameterizedType.getActualTypeArguments()[0]);
        }

        if (genericType instanceof GenericArrayType genericArrayType) {
            Type componentType = genericArrayType.getGenericComponentType();
            List<?> list = asList(value);
            Object array = Array.newInstance(rawType.getComponentType(), list.size());
            for (int i = 0; i < list.size(); i++) {
                Array.set(array, i, convertDynamic(list.get(i), componentType));
            }
            return array;
        }

        if (rawType == String.class) {
            return toStringValue(value);
        }
        if (rawType == int.class || rawType == Integer.class) {
            return toInt(value);
        }
        if (rawType == long.class || rawType == Long.class) {
            return toLong(value);
        }
        if (rawType == double.class || rawType == Double.class) {
            return toDouble(value);
        }
        if (rawType == boolean.class || rawType == Boolean.class) {
            return toBoolean(value);
        }
        if (rawType == char.class || rawType == Character.class) {
            return toChar(value);
        }
        if (rawType.isArray()) {
            return convertToArray(value, rawType.getComponentType());
        }
        if (List.class.isAssignableFrom(rawType)) {
            return convertToList(value, Object.class);
        }
        if (isTreeNodeType(rawType)) {
            return buildTree(rawType, asList(value));
        }
        if (isListNodeType(rawType)) {
            return buildLinkedList(rawType, asList(value));
        }
        if (rawType == Object.class) {
            return value;
        }

        throw new IllegalArgumentException("Unsupported parameter type: " + rawType.getTypeName());
    }

    private static Object convertDynamic(Object value, Type targetType) {
        if (targetType instanceof Class<?> clazz) {
            return convert(value, clazz, clazz);
        }
        if (targetType instanceof ParameterizedType parameterizedType) {
            Type rawType = parameterizedType.getRawType();
            if (rawType instanceof Class<?> clazz) {
                return convert(value, parameterizedType, clazz);
            }
        }
        if (targetType instanceof GenericArrayType genericArrayType) {
            Type componentType = genericArrayType.getGenericComponentType();
            if (componentType instanceof Class<?> componentClass) {
                Class<?> arrayClass = Array.newInstance(componentClass, 0).getClass();
                return convert(value, genericArrayType, arrayClass);
            }
        }
        return value;
    }

    private static Object convertToArray(Object value, Class<?> componentType) {
        if (componentType == char.class && value instanceof String s) {
            return s.toCharArray();
        }

        List<?> list = asList(value);
        Object array = Array.newInstance(componentType, list.size());
        for (int i = 0; i < list.size(); i++) {
            Array.set(array, i, convertDynamic(list.get(i), componentType));
        }
        return array;
    }

    private static List<?> convertToList(Object value, Type elementType) {
        List<?> source = asList(value);
        List<Object> result = new ArrayList<>(source.size());
        for (Object item : source) {
            result.add(convertDynamic(item, elementType));
        }
        return result;
    }

    private static List<?> asList(Object value) {
        if (value == null) {
            return Collections.emptyList();
        }
        if (value instanceof List<?> list) {
            return list;
        }
        if (value.getClass().isArray()) {
            int length = Array.getLength(value);
            List<Object> list = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                list.add(Array.get(value, i));
            }
            return list;
        }
        throw new IllegalArgumentException("Expected list-like input but got: " + value);
    }

    private static int toInt(Object value) {
        if (value instanceof Number number) {
            return number.intValue();
        }
        return Integer.parseInt(toStringValue(value));
    }

    private static long toLong(Object value) {
        if (value instanceof Number number) {
            return number.longValue();
        }
        return Long.parseLong(toStringValue(value));
    }

    private static double toDouble(Object value) {
        if (value instanceof Number number) {
            return number.doubleValue();
        }
        return Double.parseDouble(toStringValue(value));
    }

    private static boolean toBoolean(Object value) {
        if (value instanceof Boolean booleanValue) {
            return booleanValue;
        }
        return Boolean.parseBoolean(toStringValue(value));
    }

    private static char toChar(Object value) {
        if (value instanceof Character character) {
            return character;
        }
        String text = toStringValue(value);
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Cannot convert empty value to char");
        }
        return text.charAt(0);
    }

    private static String toStringValue(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof String stringValue) {
            return stringValue;
        }
        if (value instanceof Character c) {
            return String.valueOf(c);
        }
        return String.valueOf(value);
    }

    private static boolean isTreeNodeType(Class<?> clazz) {
        return hasField(clazz, "val") && hasField(clazz, "left") && hasField(clazz, "right");
    }

    private static boolean isListNodeType(Class<?> clazz) {
        return hasField(clazz, "val") && hasField(clazz, "next");
    }

    private static boolean hasField(Class<?> clazz, String fieldName) {
        return findField(clazz, fieldName) != null;
    }

    private static Field findField(Class<?> clazz, String fieldName) {
        Class<?> current = clazz;
        while (current != null) {
            try {
                Field field = current.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException ignored) {
                current = current.getSuperclass();
            }
        }
        return null;
    }

    private static Object buildTree(Class<?> nodeClass, List<?> values) {
        if (values.isEmpty() || values.get(0) == null) {
            return null;
        }

        Object root = newNode(nodeClass, values.get(0));
        Queue<Object> queue = new ArrayDeque<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < values.size()) {
            Object node = queue.poll();
            if (node == null) {
                continue;
            }

            if (index < values.size()) {
                Object leftValue = values.get(index++);
                if (leftValue != null) {
                    Object left = newNode(nodeClass, leftValue);
                    setField(node, "left", left);
                    queue.offer(left);
                }
            }

            if (index < values.size()) {
                Object rightValue = values.get(index++);
                if (rightValue != null) {
                    Object right = newNode(nodeClass, rightValue);
                    setField(node, "right", right);
                    queue.offer(right);
                }
            }
        }

        return root;
    }

    private static Object buildLinkedList(Class<?> nodeClass, List<?> values) {
        Object dummy = newNode(nodeClass, 0);
        Object tail = dummy;

        for (Object value : values) {
            Object node = newNode(nodeClass, value);
            setField(tail, "next", node);
            tail = node;
        }

        return getField(dummy, "next");
    }

    private static Object newNode(Class<?> nodeClass, Object rawValue) {
        Integer value = rawValue == null ? null : toInt(rawValue);

        for (Constructor<?> constructor : nodeClass.getDeclaredConstructors()) {
            constructor.setAccessible(true);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            try {
                if (parameterTypes.length == 0) {
                    Object node = constructor.newInstance();
                    if (value != null) {
                        setField(node, "val", value);
                    }
                    return node;
                }
                if (parameterTypes.length == 1) {
                    return constructor.newInstance(convert(value, parameterTypes[0], parameterTypes[0]));
                }
                if (parameterTypes.length == 3) {
                    return constructor.newInstance(
                            convert(value, parameterTypes[0], parameterTypes[0]),
                            null,
                            null
                    );
                }
            } catch (ReflectiveOperationException ignored) {
            }
        }

        throw new IllegalStateException("No usable constructor found for " + nodeClass.getName());
    }

    private static Object getField(Object target, String fieldName) {
        try {
            Field field = Objects.requireNonNull(findField(target.getClass(), fieldName));
            return field.get(target);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Cannot read field " + fieldName, e);
        }
    }

    private static void setField(Object target, String fieldName, Object value) {
        try {
            Field field = Objects.requireNonNull(findField(target.getClass(), fieldName));
            field.set(target, value);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Cannot write field " + fieldName, e);
        }
    }

    private static String stringifyArray(Object array) {
        int length = Array.getLength(array);
        List<String> parts = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            parts.add(stringify(Array.get(array, i)));
        }
        return "[" + String.join(", ", parts) + "]";
    }

    private static String stringifyTree(Object root) {
        List<String> values = new ArrayList<>();
        Queue<Object> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Object node = queue.poll();
            if (node == null) {
                values.add("null");
                continue;
            }

            values.add(stringify(getField(node, "val")));
            queue.offer(getField(node, "left"));
            queue.offer(getField(node, "right"));
        }

        int last = values.size() - 1;
        while (last >= 0 && "null".equals(values.get(last))) {
            last--;
        }
        return "[" + String.join(", ", values.subList(0, last + 1)) + "]";
    }

    private static String stringifyLinkedList(Object head) {
        List<String> values = new ArrayList<>();
        Object current = head;
        while (current != null) {
            values.add(stringify(getField(current, "val")));
            current = getField(current, "next");
        }
        return "[" + String.join(", ", values) + "]";
    }

    private static final class Parser {
        private final String source;
        private int index;

        private Parser(String source) {
            this.source = source == null ? "" : source.trim();
        }

        private Object parse() {
            if (source.isEmpty()) {
                return "";
            }
            Object value = parseValue();
            skipWhitespace();
            if (index < source.length()) {
                throw new IllegalArgumentException("Unexpected trailing input: " + source.substring(index));
            }
            return value;
        }

        private Object parseValue() {
            skipWhitespace();
            if (index >= source.length()) {
                return "";
            }

            char current = source.charAt(index);
            if (current == '[') {
                return parseArray();
            }
            if (current == '"' || current == '\'') {
                return parseQuotedString();
            }
            return parseBareToken();
        }

        private List<Object> parseArray() {
            index++;
            List<Object> result = new ArrayList<>();
            skipWhitespace();
            if (peek(']')) {
                index++;
                return result;
            }

            while (index < source.length()) {
                result.add(parseValue());
                skipWhitespace();
                if (peek(',')) {
                    index++;
                    continue;
                }
                if (peek(']')) {
                    index++;
                    break;
                }
                throw new IllegalArgumentException("Expected ',' or ']' at position " + index);
            }

            return result;
        }

        private String parseQuotedString() {
            char quote = source.charAt(index++);
            StringBuilder builder = new StringBuilder();

            while (index < source.length()) {
                char current = source.charAt(index++);
                if (current == '\\') {
                    if (index >= source.length()) {
                        break;
                    }
                    char escaped = source.charAt(index++);
                    switch (escaped) {
                        case '"' -> builder.append('"');
                        case '\'' -> builder.append('\'');
                        case '\\' -> builder.append('\\');
                        case '/' -> builder.append('/');
                        case 'b' -> builder.append('\b');
                        case 'f' -> builder.append('\f');
                        case 'n' -> builder.append('\n');
                        case 'r' -> builder.append('\r');
                        case 't' -> builder.append('\t');
                        case 'u' -> builder.append(parseUnicode());
                        default -> builder.append(escaped);
                    }
                    continue;
                }
                if (current == quote) {
                    return builder.toString();
                }
                builder.append(current);
            }

            throw new IllegalArgumentException("Unterminated string literal: " + source);
        }

        private char parseUnicode() {
            if (index + 4 > source.length()) {
                throw new IllegalArgumentException("Invalid unicode escape in: " + source);
            }
            String hex = source.substring(index, index + 4);
            index += 4;
            return (char) Integer.parseInt(hex, 16);
        }

        private Object parseBareToken() {
            int start = index;
            while (index < source.length()) {
                char current = source.charAt(index);
                if (current == ',' || current == ']') {
                    break;
                }
                index++;
            }

            String token = source.substring(start, index).trim();
            if (token.isEmpty()) {
                return "";
            }
            if ("null".equals(token)) {
                return null;
            }
            if ("true".equalsIgnoreCase(token)) {
                return true;
            }
            if ("false".equalsIgnoreCase(token)) {
                return false;
            }
            if (isInteger(token)) {
                try {
                    return Integer.parseInt(token);
                } catch (NumberFormatException ignored) {
                    return Long.parseLong(token);
                }
            }
            if (isDecimal(token)) {
                return Double.parseDouble(token);
            }
            return token;
        }

        private boolean isInteger(String token) {
            return token.matches("-?\\d+");
        }

        private boolean isDecimal(String token) {
            return token.matches("-?\\d+\\.\\d+([eE][+-]?\\d+)?")
                    || token.matches("-?\\d+[eE][+-]?\\d+");
        }

        private boolean peek(char expected) {
            return index < source.length() && source.charAt(index) == expected;
        }

        private void skipWhitespace() {
            while (index < source.length() && Character.isWhitespace(source.charAt(index))) {
                index++;
            }
        }
    }
}
