//The school cafeteria offers circular and square sandwiches at lunch break, 
//referred to by numbers 0 and 1 respectively. All students stand in a queue. Each 
//student either prefers square or circular sandwiches. 
//
// The number of sandwiches in the cafeteria is equal to the number of students.
// The sandwiches are placed in a stack. At each step: 
//
// 
// If the student at the front of the queue prefers the sandwich on the top of 
//the stack, they will take it and leave the queue. 
// Otherwise, they will leave it and go to the queue's end. 
// 
//
// This continues until none of the queue students want to take the top 
//sandwich and are thus unable to eat. 
//
// You are given two integer arrays students and sandwiches where sandwiches[i] 
//is the type of the ith sandwich in the stack (i = 0 is the top of the stack) 
//and students[j] is the preference of the jth student in the initial queue (j = 0 
//is the front of the queue). Return the number of students that are unable to eat. 
//
//
// 
// Example 1: 
//
// 
//Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
//Output: 0 
//Explanation:
//- Front student leaves the top sandwich and returns to the end of the line 
//making students = [1,0,0,1].
//- Front student leaves the top sandwich and returns to the end of the line 
//making students = [0,0,1,1].
//- Front student takes the top sandwich and leaves the line making students = [
//0,1,1] and sandwiches = [1,0,1].
//- Front student leaves the top sandwich and returns to the end of the line 
//making students = [1,1,0].
//- Front student takes the top sandwich and leaves the line making students = [
//1,0] and sandwiches = [0,1].
//- Front student leaves the top sandwich and returns to the end of the line 
//making students = [0,1].
//- Front student takes the top sandwich and leaves the line making students = [
//1] and sandwiches = [1].
//- Front student takes the top sandwich and leaves the line making students = [
//] and sandwiches = [].
//Hence all students are able to eat.
// 
//
// Example 2: 
//
// 
//Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= students.length, sandwiches.length <= 100 
// students.length == sandwiches.length 
// sandwiches[i] is 0 or 1. 
// students[i] is 0 or 1. 
// 
//
// Related Topics Array Stack Queue Simulation 👍 2740 👎 294


package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch outer = new NumberOfStudentsUnableToEatLunch();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        // Example:
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;
        // int[] result = solution.twoSum(nums, target);
        // System.out.println(java.util.Arrays.toString(result));
        System.out.println(solution.countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        System.out.println(solution.countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            int countStudentCircular = 0;
            int countStudentSquare = 0;
            for (int i = 0; i < students.length; i++) {
                if (students[i] == 0)
                    countStudentCircular++;
                else countStudentSquare++;
            }

            int top = 0;

            while (countStudentSquare != 0 || countStudentCircular != 0) {
                if (sandwiches[top] == 0 && countStudentCircular > 0) {
                    countStudentCircular--;
                    top++;
                    continue;
                }
                if (sandwiches[top] == 1 && countStudentSquare > 0) {
                    countStudentSquare--;
                    top++;
                    continue;
                }
                if ((sandwiches[top] == 0 && countStudentCircular == 0) || (sandwiches[top] == 1 && countStudentSquare == 0)) {
                    return Math.max(countStudentSquare, countStudentCircular);
                }

            }

            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}