//Validate if a given string can be interpreted as a decimal number. 
//
// Some examples: 
//"0" => true 
//" 0.1 " => true 
//"abc" => false 
//"1 a" => false 
//"2e10" => true 
//" -90e3 " => true 
//" 1e" => false 
//"e3" => false 
//" 6e-1" => true 
//" 99e2.5 " => false 
//"53.5e93" => true 
//" --6 " => false 
//"-+3" => false 
//"95a54e53" => false 
//
// Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number: 
//
// 
// Numbers 0-9 
// Exponent - "e" 
// Positive/negative sign - "+"/"-" 
// Decimal point - "." 
// 
//
// Of course, the context of these characters also matters in the input. 
//
// Update (2015-02-10): 
//The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition. 
// Related Topics Math String

  package leetcode.editor.en;
  public class _65_ValidNumber{
      public static void main(String[] args) {
           Solution solution = new _65_ValidNumber().new Solution();
           System.out.println(solution.isNumber("0") + " --- true");
          System.out.println(solution.isNumber("0.1") + " --- true");
          System.out.println(solution.isNumber("abc") + " --- false");
          System.out.println(solution.isNumber("1 a") + " --- false");
          System.out.println(solution.isNumber("2e10") + " ---  true");
          System.out.println(solution.isNumber("-90e3    ") + " --- true");
          System.out.println(solution.isNumber(" 1e") + " --- false");
          System.out.println(solution.isNumber("e3") + " --- false");
          System.out.println(solution.isNumber("99e2.5") + " --- false");
          System.out.println(solution.isNumber("--6") + " --- false");
          System.out.println(solution.isNumber(".6") + " --- true");
          System.out.println(solution.isNumber("6.") + " --- true");
          System.out.println(solution.isNumber(".") + " --- false");
          System.out.println(solution.isNumber("-e58") + " --- false");
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * can use DFA solution
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.indexOf('e') != -1){
            return validFront(s.substring(0, s.indexOf('e'))) && validExp(s.substring(s.indexOf('e') + 1));
        }else{
            return validFront(s);
        }
    }

    private boolean validExp(String s){
        if(s.length() == 0){
            return false;
        }
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            return validInteger(s.substring(1), false);
        }
        return validInteger(s, false);
    }

    private boolean validFront(String s){
        if(s.length() == 0){
            return false;
        }
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            s = s.substring(1);
        }
        if(s.length() == 0){
            return false;
        }
        if(s.indexOf('.') != -1){
            if(s.length() == 1){
                return false;
            }
            return validInteger(s.substring(0, s.indexOf('.')), true) && validInteger(s.substring(s.indexOf('.') + 1), true);
        }
        return validInteger(s, true);
    }

    private boolean validInteger(String s, boolean leading){
        if(s.length() == 0){
            if(leading){
                return true;
            }else {
                return false;
            }
        }
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch < '0' || ch > '9'){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
