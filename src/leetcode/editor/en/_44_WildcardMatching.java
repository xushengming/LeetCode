//Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'. 
//
// 
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
// 
//
// The matching should cover the entire input string (not partial). 
//
// Note: 
//
// 
// s could be empty and contains only lowercase letters a-z. 
// p could be empty and contains only lowercase letters a-z, and characters like ? or *. 
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
//p = "*"
//Output: true
//Explanation: '*' matches any sequence.
// 
//
// Example 3: 
//
// 
//Input:
//s = "cb"
//p = "?a"
//Output: false
//Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
// 
//
// Example 4: 
//
// 
//Input:
//s = "adceb"
//p = "*a*b"
//Output: true
//Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
// 
//
// Example 5: 
//
// 
//Input:
//s = "acdcb"
//p = "a*c?b"
//Output: false
// 
// Related Topics String Dynamic Programming Backtracking Greedy
  package leetcode.editor.en;
  public class _44_WildcardMatching{
      public static void main(String[] args) {
           Solution solution = new _44_WildcardMatching().new Solution();
           long start = System.currentTimeMillis();
           System.out.println(solution.isMatch(
                   "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb",
                   "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a") + " false");
           long end = System.currentTimeMillis();
           System.out.println("cost " + (end - start));
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch2(String s, String p) {
        boolean strEmpty = s == null ;
        boolean patternEmpty = p == null ;
        if(strEmpty && !patternEmpty){
            return false;
        }else if(strEmpty && patternEmpty){
            return true;
        }else if(!strEmpty && patternEmpty){
            return false;
        }
        int[][] cache = new int[s.length() + 1][p.length() + 1];
        for (int i = 0; i < s.length() + 1; i++){
            for (int j = 0; j < p.length() + 1; j++){
                cache[i][j] = -1;
            }
        }
        return isMatch(s, 0, p, 0, cache);
    }
    private boolean isMatch(String s, int strIndex, String p, int patternIndex, int[][] cache){
        if(strIndex == s.length() && patternIndex == p.length()) {
            return true;
        }else if((strIndex == s.length() && p.charAt(patternIndex) != '*' )
                || (patternIndex == p.length())){
            return false;
        }
        if(cache[strIndex][patternIndex] != -1){
            return cache[strIndex][patternIndex] == 1;
        }
        boolean result;
        if(p.charAt(patternIndex) == '?'){
            result = isMatch(s, strIndex + 1, p, patternIndex + 1, cache);
        }else if(p.charAt(patternIndex) == '*'){
            if(patternIndex < p.length() - 1
                    && p.charAt(patternIndex + 1) == '*'){
                result = isMatch(s,strIndex, p, patternIndex + 1, cache);
            }else if(strIndex == s.length()){
                result = isMatch(s, strIndex, p, patternIndex + 1, cache);
            }else {
                result = isMatch(s, strIndex, p, patternIndex + 1, cache)
                        || isMatch(s, strIndex + 1, p, patternIndex, cache)
                        || isMatch(s, strIndex + 1, p, patternIndex + 1, cache);
            }
        }else if(p.charAt(patternIndex) == s.charAt(strIndex)){
            result = isMatch(s, strIndex + 1, p, patternIndex + 1, cache);
        }else{
            result = false;
        }
        cache[strIndex][patternIndex] = result ? 1 : 0;
        return result;
    }
    public boolean isMatch(String s, String p) {
        int starIndex = -1, strMatchIndex = 0;
        int strIndex = 0, patternIndex = 0;
        while (strIndex < s.length()){
            if(patternIndex < p.length() && (p.charAt(patternIndex) == '?'
                    || s.charAt(strIndex) == p.charAt(patternIndex))){
                strIndex++;
                patternIndex++;
            }else if(patternIndex < p.length() && p.charAt(patternIndex) == '*'){
                starIndex = patternIndex;
                strMatchIndex = strIndex;
                patternIndex++;
            }else if(starIndex != -1){
                strMatchIndex++;
                strIndex = strMatchIndex;
                patternIndex = starIndex + 1;
            }else {
                return false;
            }
        }
        while (patternIndex < p.length() && p.charAt(patternIndex) == '*'){
            patternIndex++;
        }
        return patternIndex == p.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}