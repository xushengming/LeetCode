//Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'. 
//
// 
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
// 
//
// The matching should cover the entire input string (not partial). 
//
// Note: 
//
// 
// s could be empty and contains only lowercase letters a-z. 
// p could be empty and contains only lowercase letters a-z, and characters like . or *. 
// 
//
// Example 1: 
//
// 
//Input:
//s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input:
//s = "aa"
//p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input:
//s = "ab"
//p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input:
//s = "aab"
//p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
// 
//
// Example 5: 
//
// 
//Input:
//s = "mississippi"
//p = "mis*is*p*."
//Output: false
// 
// Related Topics String Dynamic Programming Backtracking
  package leetcode.editor.en;
  public class _10_RegularExpressionMatching{
      public static void main(String[] args) {
           Solution solution = new _10_RegularExpressionMatching().new Solution();
          System.out.println(solution.isMatch("aa", "a") + " ------ false");
          System.out.println(solution.isMatch("aa", "a*") + " ------ true");
          System.out.println(solution.isMatch("ab", ".*") + " ------ true");
          System.out.println(solution.isMatch("aab", "c*a*b") + " ------ true");
          System.out.println(solution.isMatch("mississippi", "mis*is*p*.") + " ------ false");
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0){
            return s.length() == 0;
        }
        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        }else{
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatch2(String s, String p) {
        int[][] momo = new int[s.length() + 1][p.length() + 1];
        return isMatchDP(s, p, 0, 0, momo);
    }
    private boolean isMatchDP(String s, String p, int sIndex, int pIndex, int[][] momo){
        if(momo[sIndex][pIndex] != 0){
            return momo[sIndex][pIndex] == 1;
        }
        boolean match = false;
        if(pIndex == p.length()){
            match = sIndex == s.length();
        }else{
            boolean firstMatch = sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex)
                    || p.charAt(pIndex) == '.');
            if(pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*'){
                match = isMatchDP(s, p, sIndex, pIndex + 2, momo)
                        || (firstMatch && isMatchDP(s, p, sIndex + 1, pIndex, momo));
            }else{
                match = firstMatch && isMatchDP(s, p, sIndex + 1, pIndex + 1, momo);
            }
        }
        momo[sIndex][pIndex] = match ? 1 : -1;
        return match;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}