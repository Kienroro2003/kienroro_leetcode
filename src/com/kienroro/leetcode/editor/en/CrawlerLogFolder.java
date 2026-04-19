//The Leetcode file system keeps a log each time some user performs a change 
//folder operation. 
//
// The operations are described below: 
//
// 
// "../" : Move to the parent folder of the current folder. (If you are already 
//in the main folder, remain in the same folder). 
// "./" : Remain in the same folder. 
// "x/" : Move to the child folder named x (This folder is guaranteed to always 
//exist). 
// 
//
// You are given a list of strings logs where logs[i] is the operation 
//performed by the user at the iᵗʰ step. 
//
// The file system starts in the main folder, then the operations in logs are 
//performed. 
//
// Return the minimum number of operations needed to go back to the main folder 
//after the change folder operations. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: logs = ["d1/","d2/","../","d21/","./"]
//Output: 2
//Explanation: Use this change folder operation "../" 2 times and go back to 
//the main folder.
// 
//
// Example 2: 
//
// 
//
// 
//Input: logs = ["d1/","d2/","./","d3/","../","d31/"]
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: logs = ["d1/","../","../","../"]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= logs.length <= 10³ 
// 2 <= logs[i].length <= 10 
// logs[i] contains lowercase English letters, digits, '.', and '/'. 
// logs[i] follows the format described in the statement. 
// Folder names consist of lowercase English letters and digits. 
// 
//
// Related Topics Array String Stack 👍 1552 👎 99


package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        CrawlerLogFolder outer = new CrawlerLogFolder();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        System.out.println(solution.minOperations(new String[]{"d1/","d2/","../","d21/","./"}));
        System.out.println(solution.minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(String[] logs) {
            Deque<String> stack = new ArrayDeque<>();
            for (String log : logs) {
                if (!log.equals("./") && !log.equals("../")) {
                    stack.push(log);
                    continue;
                }
                if (!stack.isEmpty() && log.equals("../")){
                    stack.pop();
                }
            }
            return stack.size();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}