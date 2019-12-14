//Given two binary strings, return their sum (also a binary string). 
//
// The input strings are both non-empty and contains only characters 1 or 0. 
//
// Example 1: 
//
// 
//Input: a = "11", b = "1"
//Output: "100" 
//
// Example 2: 
//
// 
//Input: a = "1010", b = "1011"
//Output: "10101" 
// Related Topics Math String

  package leetcode.editor.en;
  public class _67_AddBinary{
      public static void main(String[] args) {
           Solution solution = new _67_AddBinary().new Solution();
           System.out.println(solution.addBinary("1010", "1011") + " -- 10101");
          System.out.println(solution.addBinary("11", "1") + " -- 100");
          System.out.println(solution.addBinary("100", "110010") + " -- 110110");
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary2(String a, String b) {
        if(a == null || a.length() == 0){
            return b;
        }
        if(b == null || b.length() == 0){
            return a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0){
                sum += b.charAt(j--) - '0';
            }
            stringBuilder.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0){
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0){
            return b;
        }
        if(b == null || b.length() == 0){
            return a;
        }
        String longer = a.length() >= b.length() ? a : b;
        String shorter = a.length() < b.length() ? a : b;
        StringBuilder stringBuilder = new StringBuilder();
        char carry = '0';
        for (int i = shorter.length() - 1; i >= 0; i--){
            char l = longer.charAt(longer.length() - shorter.length() + i);
            char s = shorter.charAt(i);
            if(l == '1' && s == '1'){
                stringBuilder.append(carry);
                carry = '1';
            }else if(l == '0' && s == '0'){
                stringBuilder.append(carry);
                carry = '0';
            }else{
                if(carry == '1'){
                    stringBuilder.append('0');
                }else{
                    stringBuilder.append('1');
                }
            }
        }
        for (int i = longer.length() - shorter.length() - 1; i >= 0; i--){
            char ch = longer.charAt(i);
            if(ch == '0'){
                stringBuilder.append(carry);
                carry = '0';
            }else{
                if(carry == '1'){
                    stringBuilder.append('0');
                }else{
                    stringBuilder.append('1');
                }
            }
        }
        if(carry == '1'){
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
