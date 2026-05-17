// Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
//
// Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
//
// Example 1:
//
// Input: g = [1,2,3], s = [1,1]
// Output: 1
// Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
// And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
// You need to output 1.
//
// Example 2:
//
// Input: g = [1,2], s = [1,2,3]
// Output: 2
// Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
// You have 3 cookies and their sizes are big enough to gratify all of the children,
// You need to output 2.
//
// Constraints:
//
// - 1 <= g.length <= 3 * 104
// - 0 <= s.length <= 3 * 104
// - 1 <= g[i], s[j] <= 231 - 1
//
// Note: This question is the same as 2410: Maximum Matching of Players With Trainers.

package com.kienroro.leetcode.editor.en;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        AssignCookies outer = new AssignCookies();
        Solution solution = outer.new Solution();

        // Test case 1: Example 1
        int[] g1 = { 1, 2, 3 };
        int[] s1 = { 1, 1 };
        System.out.println("Test Case 1: " + solution.findContentChildren(g1, s1)); // Expected: 1

        // Test case 2: Example 2
        int[] g2 = { 1, 2 };
        int[] s2 = { 1, 2, 3 };
        System.out.println("Test Case 2: " + solution.findContentChildren(g2, s2)); // Expected: 2

        // Test case 3: Empty cookies
        int[] g3 = { 1, 2, 3 };
        int[] s3 = {};
        System.out.println("Test Case 3: " + solution.findContentChildren(g3, s3)); // Expected: 0

        // Test case 4: Large greed, small cookies
        int[] g4 = { 10, 20 };
        int[] s4 = { 1, 2, 3 };
        System.out.println("Test Case 4: " + solution.findContentChildren(g4, s4)); // Expected: 0
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            int pg = 0;
            int ans = 0;
            Arrays.sort(g);
            Arrays.sort(s);
            for (int i = 0; i < s.length; i++) {
                if (s[i] < g[pg]) {
                    continue;
                }
                ans++;
                pg++;
                if (pg == g.length) {
                    return pg;
                }
            }
            return ans;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
