// You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
// Example 1:
//
// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//
// Example 2:
//
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.
//
// Constraints:
//
// - 1 <= prices.length <= 105
// - 0 <= prices[i] <= 104

package com.kienroro.leetcode.editor.en;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock outer = new BestTimeToBuyAndSellStock();
        Solution solution = outer.new Solution();

        System.out.println(solution.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // expected: 5
        System.out.println(solution.maxProfit(new int[] { 7, 6, 4, 3, 1 })); // expected: 0
        System.out.println(solution.maxProfit(new int[] { 5 })); // expected: 0
        System.out.println(solution.maxProfit(new int[] { 3, 3, 3, 3 })); // expected: 0
        System.out.println(solution.maxProfit(new int[] { 1, 2, 3, 4, 5 })); // expected: 4
        System.out.println(solution.maxProfit(new int[] { 2, 4, 1, 7 })); // expected: 6
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = prices[0];
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
                minPrice = Math.min(minPrice, prices[i]);
            }
            return maxProfit;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
