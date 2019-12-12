//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string. 
//
// If the last word does not exist, return 0. 
//
// Note: A word is defined as a character sequence consists of non-space characters only. 
//
// Example: 
//
// 
//Input: "Hello World"
//Output: 5
// 
//
// 
// Related Topics String
  package leetcode.editor.en;
  public class _58_LengthOfLastWord{
      public static void main(String[] args) {
           Solution solution = new _58_LengthOfLastWord().new Solution();
           String input = "Hello world";
           System.out.println(solution.lengthOfLastWord(input));
          System.out.println(solution.lengthOfLastWord("a   "));
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null){
            return 0;
        }
        int size = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                size++;
            }else{
                if(size > 0){
                    break;
                }
            }
        }
        return size;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}