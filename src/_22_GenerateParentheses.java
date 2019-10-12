import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        int left = 1;
        int right = 0;
        String s = "(";
        List<String> result = new ArrayList<>();
        generateParenthesis(n, left, right, s, result);
        return result;
    }

    private void generateParenthesis(int n, int left, int right, String s, List<String> result){
        if(left == n && right == n){
            result.add(s);
        }else{
            if(left < n){
                generateParenthesis(n, left + 1, right, s + "(", result);
            }
            if(right < left){
                generateParenthesis(n, left, right + 1, s + ")", result);
            }
        }
    }

    public static void main(String[] args) {
        _22_GenerateParentheses generateParentheses = new _22_GenerateParentheses();
        int n = 4;
        List<String> result = generateParentheses.generateParenthesis(n);
        for (String string : result){
            System.out.println(string);
        }
    }
}
