//A sentence is a string of single-space separated words where each word 
//consists only of lowercase letters. 
//
// A word is uncommon if it appears exactly once in one of the sentences, and 
//does not appear in the other sentence. 
//
// Given two sentences s1 and s2, return a list of all the uncommon words. You 
//may return the answer in any order. 
//
// 
// Example 1: 
//
// 
// Input: s1 = "this apple is sweet", s2 = "this apple is sour" 
// 
//
// Output: ["sweet","sour"] 
//
// Explanation: 
//
// The word "sweet" appears only in s1, while the word "sour" appears only in s2
//. 
//
// Example 2: 
//
// 
// Input: s1 = "apple apple", s2 = "banana" 
// 
//
// Output: ["banana"] 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 200 
// s1 and s2 consist of lowercase English letters and spaces. 
// s1 and s2 do not have leading or trailing spaces. 
// All the words in s1 and s2 are separated by a single space. 
// 
//
// Related Topics Hash Table String Counting 👍 1902 👎 209


package com.kienroro.leetcode.editor.en;

import java.util.Collections;
import java.util.List;

import static com.kienroro.leetcode.editor.util.LeetCodeDebug.defaultArgCases;
import static com.kienroro.leetcode.editor.util.LeetCodeDebug.run;
import static com.kienroro.leetcode.editor.util.LeetCodeDebug.stringify;

public class UncommonWordsFromTwoSentences {
    private static final String DEFAULT_INPUT = """
"this apple is sweet"
"this apple is sour"
"apple apple"
"banana"
""";

    public static void main(String[] args) {
        List<String[]> cases = args.length == 0
                ? defaultArgCases(new UncommonWordsFromTwoSentences().new Solution(), DEFAULT_INPUT)
                : Collections.singletonList(args);

        if (cases.isEmpty()) {
            System.out.println("No local testcase provided.");
            return;
        }

        for (int i = 0; i < cases.size(); i++) {
            String[] rawArgs = cases.get(i);
            Solution solution = new UncommonWordsFromTwoSentences().new Solution();

            try {
                Object result = run(solution, rawArgs);
                String label = cases.size() == 1 ? "result" : "case " + (i + 1);
                System.out.println(label + " = " + stringify(result));
            } catch (RuntimeException e) {
                System.err.println("rawArgs = " + java.util.Arrays.toString(rawArgs));
                throw e;
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}