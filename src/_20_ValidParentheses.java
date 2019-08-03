import java.util.Stack;

public class _20_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++){
            char character = s.charAt(i);
            if(character == '('
                    || character == '['
                    || character == '{'){
                stack.push(character);
            }else{
                if(stack.empty()){
                    return false;
                }else{
                    char top = stack.pop();
                    if(top == '('
                    && character == ')'){
                        continue;
                    }else if(top == '['
                    && character == ']'){
                        continue;
                    }else if(top == '{'
                    && character == '}'){
                        continue;
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        _20_ValidParentheses validParentheses = new _20_ValidParentheses();
        String input = "(]";
        boolean result = validParentheses.isValid(input);
        System.out.printf("result " + result);
    }
}
