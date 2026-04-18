//Alice and Bob have a different total number of candies. You are given two 
//integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies 
//of the iᵗʰ box of candy that Alice has and bobSizes[j] is the number of candies 
//of the jᵗʰ box of candy that Bob has. 
//
// Since they are friends, they would like to exchange one candy box each so 
//that after the exchange, they both have the same total amount of candy. The total 
//amount of candy a person has is the sum of the number of candies in each box 
//they have. 
//
// Return an integer array answer where answer[0] is the number of candies in 
//the box that Alice must exchange, and answer[1] is the number of candies in the 
//box that Bob must exchange. If there are multiple answers, you may return any one 
//of them. It is guaranteed that at least one answer exists. 
//
// 
// Example 1: 
//
// 
//Input: aliceSizes = [1,1], bobSizes = [2,2]
//Output: [1,2]
// 
//
// Example 2: 
//
// 
//Input: aliceSizes = [1,2], bobSizes = [2,3]
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: aliceSizes = [2], bobSizes = [1,3]
//Output: [2,3]
// 
//
// 
// Constraints: 
//
// 
// 1 <= aliceSizes.length, bobSizes.length <= 10⁴ 
// 1 <= aliceSizes[i], bobSizes[j] <= 10⁵ 
// Alice and Bob have a different total number of candies. 
// There will be at least one valid answer for the given input. 
// 
//
// Related Topics Array Hash Table Binary Search Sorting 👍 2279 👎 422


package com.kienroro.leetcode.editor.en;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FairCandySwap {
    public static void main(String[] args) {
        FairCandySwap outer = new FairCandySwap();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
            int sumAlice = Arrays.stream(aliceSizes).sum();
            int sumBob = Arrays.stream(bobSizes).sum();
            int diff = (sumBob - sumAlice) / 2;
            Set<Integer> bobSet = Arrays.stream(bobSizes).boxed().collect(Collectors.toSet());
            for (int i = 0; i < aliceSizes.length; i++) {
                if (bobSet.contains(diff + aliceSizes[i])) {
                    return new int[]{aliceSizes[i], diff + aliceSizes[i]};
                }
            }
            throw new IllegalArgumentException("No candy swap");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}