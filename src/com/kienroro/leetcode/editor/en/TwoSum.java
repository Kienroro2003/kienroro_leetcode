//Given an array of integers nums and an integer target, return indices of the
//two numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may 
//not use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// Only one valid answer exists. 
// 
//
// 
//Follow-up: Can you come up with an algorithm that is less than 
//O(n²)
// time complexity?
//
// Related Topics Array Hash Table 👍 68664 👎 2569


package com.kienroro.leetcode.editor.en;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kienroro.leetcode.editor.util.LeetCodeDebug.defaultArgCases;
import static com.kienroro.leetcode.editor.util.LeetCodeDebug.run;
import static com.kienroro.leetcode.editor.util.LeetCodeDebug.stringify;

public class TwoSum {
    private static final String DEFAULT_INPUT = """
              [2,7,11,15]
            9
            [3,2,4]
            6
            [3,3]
            6
            """;

    public static void main(String[] args) {
        List<String[]> cases = args.length == 0
                ? defaultArgCases(new TwoSum().new Solution(), DEFAULT_INPUT)
                : Collections.singletonList(args);

        if (cases.isEmpty()) {
            System.out.println("No local testcase provided.");
            return;
        }

        for (int i = 0; i < cases.size(); i++) {
            String[] rawArgs = cases.get(i);
            Solution solution = new TwoSum().new Solution();

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
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int numNeed = target - nums[i];
                if (map.containsKey(numNeed)) {
                    return new int[]{map.get(numNeed), i};
                }else{
                    map.put(nums[i], i);
                }
            }
            return null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
