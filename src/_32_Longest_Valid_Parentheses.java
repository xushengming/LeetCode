import java.util.ArrayList;
import java.util.Stack;

public class _32_Longest_Valid_Parentheses {
    public int longestValidParentheses_dp(String s) {
        if(s == null || s.length() < 2){
            return 0;
        }
        int max = 0;
        int dp[] = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i] = 0;
        }
        for (int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    if(i - 2 >= 0){
                        dp[i] = dp[i - 2] + 2;
                    }else{
                        dp[i] = 2;
                    }
                }else if(i - 1 - dp[i - 1] >= 0
                && s.charAt(i - 1 - dp[i - 1]) == '('){
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public int longestValidParentheses_stack(String s) {
        if(s == null || s.length() < 2){
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }else{
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheses_two_traverse(String s) {
        if(s == null || s.length() < 2){
            return 0;
        }
        int max = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                left++;
            }else{
                right++;
            }
            if(left < right){
                left = 0;
                right = 0;
            }else if(left == right){
                max = Math.max(max, left * 2);
            }
        }

        left = 0; right = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == '('){
                left++;
            }else{
                right++;
            }
            if(left > right){
                left = 0;
                right = 0;
            }else if(left == right){
                max = Math.max(max, left * 2);
            }
        }
        return max;
    }
}
