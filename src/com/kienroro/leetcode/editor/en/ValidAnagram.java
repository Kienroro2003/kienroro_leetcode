//Given two strings s and t, return true if t is an anagram of s, and false 
//otherwise. 
//
// 
// Example 1: 
//
// 
// Input: s = "anagram", t = "nagaram" 
// 
//
// Output: true 
//
// Example 2: 
//
// 
// Input: s = "rat", t = "car" 
// 
//
// Output: false 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you 
//adapt your solution to such a case? 
//
// Related Topics Hash Table String Sorting 👍 14365 👎 478


package com.kienroro.leetcode.editor.en;

import java.util.Collections;
import java.util.List;

import static com.kienroro.leetcode.editor.util.LeetCodeDebug.defaultArgCases;
import static com.kienroro.leetcode.editor.util.LeetCodeDebug.run;
import static com.kienroro.leetcode.editor.util.LeetCodeDebug.stringify;

public class ValidAnagram {
    private static final String DEFAULT_INPUT = """
"anagram"
"nagaram"
"rat"
"car"
""";

    public static void main(String[] args) {
        List<String[]> cases = args.length == 0
                ? defaultArgCases(new ValidAnagram().new Solution(), DEFAULT_INPUT)
                : Collections.singletonList(args);

        if (cases.isEmpty()) {
            System.out.println("No local testcase provided.");
            return;
        }

        for (int i = 0; i < cases.size(); i++) {
            String[] rawArgs = cases.get(i);
            Solution solution = new ValidAnagram().new Solution();

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
    public boolean isAnagram(String s, String t) {
        return false`;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}