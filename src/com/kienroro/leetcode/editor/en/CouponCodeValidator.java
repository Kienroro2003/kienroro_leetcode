//You are given three arrays of length n that describe the properties of n 
//coupons: code, businessLine, and isActive. The iᵗʰ coupon has: 
//
// 
// code[i]: a string representing the coupon identifier. 
// businessLine[i]: a string denoting the business category of the coupon. 
// isActive[i]: a boolean indicating whether the coupon is currently active. 
// 
//
// A coupon is considered valid if all of the following conditions hold: 
//
// 
// code[i] is non-empty and consists only of alphanumeric characters (a-z, A-Z, 
//0-9) and underscores (_). 
// businessLine[i] is one of the following four categories: "electronics", 
//"grocery", "pharmacy", "restaurant". 
// isActive[i] is true. 
// 
//
// Return an array of the codes of all valid coupons, sorted first by their 
//businessLine in the order: "electronics", "grocery", "pharmacy", "restaurant", and 
//then by code in lexicographical (ascending) order within each category. 
//
// 
// Example 1: 
//
// 
// Input: code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine = [
//"restaurant","grocery","pharmacy","restaurant"], isActive = [true,true,true,true] 
// 
//
// Output: ["PHARMA5","SAVE20"] 
//
// Explanation: 
//
// 
// First coupon is valid. 
// Second coupon has empty code (invalid). 
// Third coupon is valid. 
// Fourth coupon has special character @ (invalid). 
// 
//
// Example 2: 
//
// 
// Input: code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"], businessLine = [
//"grocery","electronics","invalid"], isActive = [false,true,true] 
// 
//
// Output: ["ELECTRONICS_50"] 
//
// Explanation: 
//
// 
// First coupon is inactive (invalid). 
// Second coupon is valid. 
// Third coupon has invalid business line (invalid). 
// 
//
// 
// Constraints: 
//
// 
// n == code.length == businessLine.length == isActive.length 
// 1 <= n <= 100 
// 0 <= code[i].length, businessLine[i].length <= 100 
// code[i] and businessLine[i] consist of printable ASCII characters. 
// isActive[i] is either true or false. 
// 
//
// Related Topics Array Hash Table String Sorting 👍 336 👎 107


package com.kienroro.leetcode.editor.en;

import java.util.*;

public class CouponCodeValidator {
    public static void main(String[] args) {
        CouponCodeValidator outer = new CouponCodeValidator();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        System.out.println(solution.validateCoupons(
                new String[]{"SAVE20", "", "PHARMA5", "SAVE@20"},
                new String[]{"restaurant", "grocery", "pharmacy", "restaurant"},
                new boolean[]{true, true, true, true}
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> categories = new LinkedHashSet<>(List.of("electronics", "grocery", "pharmacy", "restaurant"));

        public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
            List<String> res = new ArrayList<>();
            Map<String, List<String>> codesByCategory = new HashMap<>();
            for (int i = 0; i < code.length; i++) {
                if (isValidCoupon(code[i], businessLine[i], isActive[i])) {
                    codesByCategory.computeIfAbsent(businessLine[i], k -> new ArrayList<>()).add(code[i]);
                }
            }
            for (String c : categories) {
                if (codesByCategory.containsKey(c)) {
                    codesByCategory.get(c).sort(null);
                    res.addAll(codesByCategory.get(c));
                }
            }
            return res;

        }

        public boolean isValidCode(String code) {
            if (code.isEmpty()) {
                return false;
            }

            for (char c : code.toCharArray()) {
                if (c != '_' && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
                    return false;
                }
            }
            return true;
        }
        
        public boolean isValidBusinessLine(String businessLine) {
            return categories.contains(businessLine);
        }

        public boolean isValidCoupon(String code, String businessLine, boolean isActive){
            return isValidCode(code) && isValidBusinessLine(businessLine) && isActive;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}