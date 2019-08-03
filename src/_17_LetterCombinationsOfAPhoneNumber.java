import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_LetterCombinationsOfAPhoneNumber {
    private Map<Character, String> numStrMap = new HashMap<>(8);

    public List<String> letterCombinations(String digits) {
        numStrMap.put('2', "abc");
        numStrMap.put('3', "def");
        numStrMap.put('4', "ghi");
        numStrMap.put('5', "jkl");
        numStrMap.put('6', "mno");
        numStrMap.put('7', "pqrs");
        numStrMap.put('8', "tuv");
        numStrMap.put('9', "wxyz");
        return letterCombinationsImpl(digits);
    }

    private List<String> letterCombinationsImpl(String digits){
        if(digits == null){
            return new ArrayList<>();
        }
        int digitsLength = digits.length();
        if(digitsLength == 0){
            return new ArrayList<>();
        }
        if(digitsLength == 1){
            String strOfNum = numStrMap.get(digits.charAt(0));
            List<String> list = new ArrayList<>();
            for (int i = 0; i < strOfNum.length(); i++){
                list.add(String.valueOf(strOfNum.charAt(i)));
            }
            return list;
        }
        Character character = digits.charAt(0);
        List<String> list = letterCombinationsImpl(digits.substring(1));
        String strOfNum = numStrMap.get(character);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < strOfNum.length(); j++){
                result.add(strOfNum.charAt(j) + list.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _17_LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new _17_LetterCombinationsOfAPhoneNumber();
        String input = "23";
        List<String> result = letterCombinationsOfAPhoneNumber.letterCombinations(input);
        for (int i = 0; i < result.size(); i++){
            System.out.printf(result.get(i) + " ");
        }
    }
}
