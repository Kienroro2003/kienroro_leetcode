//You are given a string s consisting only of uppercase English letters. 
//
// You can apply some operations to this string where, in one operation, you 
//can remove any occurrence of one of the substrings "AB" or "CD" from s. 
//
// Return the minimum possible length of the resulting string that you can 
//obtain. 
//
// Note that the string concatenates after removing the substring and could 
//produce new "AB" or "CD" substrings. 
//
// 
// Example 1: 
//
// 
//Input: s = "ABFCACDB"
//Output: 2
//Explanation: We can do the following operations:
//- Remove the substring "ABFCACDB", so s = "FCACDB".
//- Remove the substring "FCACDB", so s = "FCAB".
//- Remove the substring "FCAB", so s = "FC".
//So the resulting length of the string is 2.
//It can be shown that it is the minimum length that we can obtain. 
//
// Example 2: 
//
// 
//Input: s = "ACBBD"
//Output: 5
//Explanation: We cannot do any operations on the string so the length remains 
//the same.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists only of uppercase English letters. 
// 
//
// Related Topics String Stack Simulation 👍 1014 👎 29


package com.kienroro.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumStringLengthAfterRemovingSubstrings {
    public static void main(String[] args) {
        MinimumStringLengthAfterRemovingSubstrings outer = new MinimumStringLengthAfterRemovingSubstrings();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
//        System.out.println(solution.minLength("ABFCACDB"));
//        System.out.println(solution.minLength("ACBBD"));
        System.out.println(solution.minLength("BJKDKABJ"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minLength(String s) {
            List<Integer> list = new ArrayList<>(s.chars().boxed().toList());
            for (int i = 0; i < list.size() - 1; ) {
                if ((list.get(i + 1).equals((int) 'B') && list.get(i).equals((int) 'A')) || (list.get(i + 1).equals((int) 'D') && list.get(i).equals((int) 'C'))) {
                    list.remove(i);
                    list.remove(i);
                    if (i != 0) {
                        i--;
                    }
                    continue;
                }
                i++;

            }
            return list.size();


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}