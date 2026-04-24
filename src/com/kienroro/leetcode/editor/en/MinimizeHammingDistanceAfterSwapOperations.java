//You are given two integer arrays, source and target, both of length n. You 
//are also given an array allowedSwaps where each allowedSwaps[i] = [ai, bi] 
//indicates that you are allowed to swap the elements at index ai and index bi (0-indexed)
// of array source. Note that you can swap elements at a specific pair of indices 
//multiple times and in any order. 
//
// The Hamming distance of two arrays of the same length, source and target, is 
//the number of positions where the elements are different. Formally, it is the 
//number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed). 
//
// Return the minimum Hamming distance of source and target after performing 
//any amount of swap operations on array source. 
//
// 
// Example 1: 
//
// 
//Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
//Output: 1
//Explanation: source can be transformed the following way:
//- Swap indices 0 and 1: source = [2,1,3,4]
//- Swap indices 2 and 3: source = [2,1,4,3]
//The Hamming distance of source and target is 1 as they differ in 1 position: 
//index 3.
// 
//
// Example 2: 
//
// 
//Input: source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
//Output: 2
//Explanation: There are no allowed swaps.
//The Hamming distance of source and target is 2 as they differ in 2 positions: 
//index 1 and index 2.
// 
//
// Example 3: 
//
// 
//Input: source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2]
//,[1,3],[1,4]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// n == source.length == target.length 
// 1 <= n <= 10⁵ 
// 1 <= source[i], target[i] <= 10⁵ 
// 0 <= allowedSwaps.length <= 10⁵ 
// allowedSwaps[i].length == 2 
// 0 <= ai, bi <= n - 1 
// ai != bi 
// 
//
// Related Topics Array Depth-First Search Union-Find 👍 1032 👎 32

package com.kienroro.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimizeHammingDistanceAfterSwapOperations {
    public static void main(String[] args) {
        MinimizeHammingDistanceAfterSwapOperations outer = new MinimizeHammingDistanceAfterSwapOperations();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        System.out.println(solution.minimumHammingDistance(new int[] { 1, 2, 3, 4 }, new int[] { 2, 1, 4, 5 },
                new int[][] { { 0, 1 }, { 2, 3 } }));
        System.out.println(solution.minimumHammingDistance(new int[] { 5, 1, 2, 4, 3 }, new int[] { 1, 5, 4, 2, 3 },
                new int[][] { { 0, 4 }, { 4, 2 }, { 1, 3 }, { 1, 4 } }));
        System.out.println(solution.minimumHammingDistance(new int[] { 5, 1, 2, 4, 3 }, new int[] { 1, 5, 4, 2, 3 },
                new int[][] { { 1, 2 } }));

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class UnionFind {
        private final int[] parent;
        private final int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB)
                return;

            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            } else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }

        public boolean connected(int a, int b) {
            return find(a) == find(b);
        }
    }

    class Solution {
        public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
            int mismatchCount = 0;
            UnionFind unionFind = new UnionFind(source.length);

            for (int[] allowedSwap : allowedSwaps) {
                unionFind.union(allowedSwap[0], allowedSwap[1]);
            }

            Map<Integer, Map<Integer, Integer>> componentCounts = new HashMap<>();
            for (int i = 0; i < source.length; i++) {
                int root = unionFind.find(i);
                var count = componentCounts.computeIfAbsent(root, k -> new HashMap<>());
                count.merge(source[i], 1, Integer::sum);
            }

            for (int i = 0; i < target.length; i++) {
                int root = unionFind.find(i);
                var count = componentCounts.get(root);
                int available = count == null ? 0 : count.getOrDefault(target[i], 0);

                if (available > 0) {
                    count.merge(target[i], -1, Integer::sum);
                } else {
                    mismatchCount++;
                }

            }

            return mismatchCount;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
