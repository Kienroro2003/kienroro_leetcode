// There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
//
// You want to determine if there is a valid path that exists from vertex source to vertex destination.
//
// Given edges and the integers n, source, and destination, return trueif there is a valid path fromsourcetodestination, orfalseotherwise.
//
// Example 1:
//
// validpath-ex1.png
//
// Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
// Output: true
// Explanation: There are two paths from vertex 0 to vertex 2:
// - 0 &rarr; 1 &rarr; 2
// - 0 &rarr; 2
//
// Example 2:
//
// validpath-ex2.png
//
// Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
// Output: false
// Explanation: There is no path from vertex 0 to vertex 5.
//
// Constraints:
//
// - 1 <= n <= 2 * 105
// - 0 <= edges.length <= 2 * 105
// - edges[i].length == 2
// - 0 <= ui, vi <= n - 1
// - ui != vi
// - 0 <= source, destination <= n - 1
// - There are no duplicate edges.
// - There are no self edges.

package com.kienroro.leetcode.editor.en;

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        FindIfPathExistsInGraph outer = new FindIfPathExistsInGraph();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        // Example:
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;
        // int[] result = solution.twoSum(nums, target);
        // System.out.println(java.util.Arrays.toString(result));
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (this.parent[x] != x) {
                this.parent[x] = find(this.parent[x]);
            }
            return this.parent[x];
        }

        public void union(int q, int p) {
            int rootQ = find(q);
            int rootP = find(p);

            if (rootQ == rootP) {
                return;
            }
            if (size[rootQ] < size[rootP]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
        }

        public boolean isConnect(int q, int p) {
            return find(q) == find(p);
        }
    }

    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            UnionFind unionFind = new UnionFind(n);
            for (int[] edge : edges) {
                unionFind.union(edge[0], edge[1]);
            }
            return unionFind.isConnect(source, destination);

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
