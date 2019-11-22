//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string. 
//
// Example 1: 
//
// 
//Input: num1 = "2", num2 = "3"
//Output: "6" 
//
// Example 2: 
//
// 
//Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
//
// Note: 
//
// 
// The length of both num1 and num2 is < 110. 
// Both num1 and num2 contain only digits 0-9. 
// Both num1 and num2 do not contain any leading zero, except the number 0 itself. 
// You must not use any built-in BigInteger library or convert the inputs to integer directly. 
// 
// Related Topics Math String

  package leetcode.editor.en;

import java.util.ArrayList;

public class _43_MultiplyStrings{
      public static void main(String[] args) {
          Solution solution = new _43_MultiplyStrings().new Solution();
          System.out.println(solution.multiply("123", "456"));
          System.out.println(solution.multiply("2", "3"));
          System.out.println(solution.multiply("238374828", "0"));
          System.out.println(solution.multiply("238374828", "23982132"));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null){
            return "";
        }
        if(num1.length() == 0 || num2.length() == 0){
            return "";
        }
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String shorterStr = num1.length() > num2.length() ? num2 : num1;
        String longerStr = num1.length() > num2.length() ? num1 : num2;
        ArrayList<Character> sum = new ArrayList<>();
        ArrayList<Character> tmp ;
        for (int i = shorterStr.length() - 1; i >= 0; i--){
            if(shorterStr.charAt(i) == '0'){
                continue;
            }
            tmp = multiplyWithOneBit(longerStr, shorterStr.charAt(i), shorterStr, i);
            if(sum.size() == 0){
                sum.addAll(tmp);
                continue;
            }
            addSum(sum, tmp);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : sum){
            stringBuilder.append(ch);
        }
       return stringBuilder.toString();
    }

    private ArrayList<Character> multiplyWithOneBit(String num, char ch, String numShort, int index){
        int carry = 0;
        ArrayList<Character> tmp = new ArrayList<>();
        for (int j = num.length() - 1; j >= 0; j--){
            int result = (ch - '0') * (num.charAt(j) - '0') + carry;
            if(result >= 10){
                carry = result / 10;
                result = result % 10;
            }else{
                carry = 0;
            }
            tmp.add(0, (char)('0' + result));
        }
        if(carry > 0){
            tmp.add(0, (char)(carry + '0'));
            carry = 0;
        }
        for (int m = numShort.length() - 1 - index; m > 0; m--){
            tmp.add('0');
        }
        return tmp;
    }

    private ArrayList<Character> addSum(ArrayList<Character> sum, ArrayList<Character> tmp){
        int sumCarry = 0;
        int p, q;
        for (p = sum.size() - 1, q = tmp.size() - 1 ; p >= 0 && q >= 0; q--, p--){
            int bitSum = sum.get(p) - '0' + tmp.get(q) - '0' + sumCarry;
            if(bitSum >= 10){
                sumCarry = bitSum / 10;
                bitSum = bitSum % 10;
            }else{
                sumCarry = 0;
            }
            sum.remove(p);
            sum.add(p, (char)(bitSum + '0'));
        }
        while (q >= 0){
            int bitSum = tmp.get(q) - '0' + sumCarry;
            if(bitSum >= 10){
                sumCarry = bitSum / 10;
                bitSum = bitSum % 10;
            }else {
                sumCarry = 0;
            }
            sum.add(0, (char)(bitSum + '0'));
            q--;
        }
        if(sumCarry > 0){
            sum.add(0, (char)(sumCarry + '0'));
            sumCarry = 0;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
