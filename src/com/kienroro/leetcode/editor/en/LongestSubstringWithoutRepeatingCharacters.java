//Given a string s, find the length of the longest substring without duplicate 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3. Note that "bca" and 
//"cab" are also correct answers.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 44987 👎 2214


package com.kienroro.leetcode.editor.en;

import java.util.Collections;
import java.util.List;

import static com.kienroro.leetcode.editor.util.LeetCodeDebug.defaultArgCases;
import static com.kienroro.leetcode.editor.util.LeetCodeDebug.run;
import static com.kienroro.leetcode.editor.util.LeetCodeDebug.stringify;

public class LongestSubstringWithoutRepeatingCharacters {
    private static final String DEFAULT_INPUT = """
"abcabcbb"
"bbbbb"
"pwwkew"
""";

    public static void main(String[] args) {
        List<String[]> cases = args.length == 0
                ? defaultArgCases(new LongestSubstringWithoutRepeatingCharacters().new Solution(), DEFAULT_INPUT)
                : Collections.singletonList(args);

        if (cases.isEmpty()) {
            System.out.println("No local testcase provided.");
            return;
        }

        for (int i = 0; i < cases.size(); i++) {
            String[] rawArgs = cases.get(i);
            Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();

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
    public int lengthOfLongestSubstring(String s) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}