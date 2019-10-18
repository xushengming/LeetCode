//The count-and-say sequence is the sequence of integers with the first five terms as following: 
//
// 
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 is read off as "one 1" or 11. 
//11 is read off as "two 1s" or 21. 
//21 is read off as "one 2, then one 1" or 1211. 
//
// Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. 
//
// Note: Each term of the sequence of integers will be represented as a string. 
//
// 
//
// Example 1: 
//
// 
//Input: 1
//Output: "1"
// 
//
// Example 2: 
//
// 
//Input: 4
//Output: "1211" 
// Related Topics String

  package leetcode.editor.en;
  public class _38_CountAndSay{
      public static void main(String[] args) {
           Solution solution = new _38_CountAndSay().new Solution();
           System.out.println(solution.countAndSay(30));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String countAndSay(int n) {
       if(n == 1){
           return "1";
       }
       if(n == 2){
           return "11";
       }
       String previous = countAndSay(n - 1);
       StringBuilder current = new StringBuilder();
       int count = 0;
       for (int i = 1; i < previous.length(); i++){
           count++;
           if(previous.charAt(i - 1) == previous.charAt(i)){
               continue;
           }else{
               current.append(count).append(previous.charAt(i - 1));
               count = 0;
           }
       }
        current.append(count + 1).append(previous.charAt(previous.length() - 1));
        return current.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
