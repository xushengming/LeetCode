import java.util.HashMap;

public class _13RomanToInteger {
    public int romanToInt2(String s) {
        if(s.length() == 0){
            return 0;
        }
        int length = s.length();
        char pendingChar = '0';
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>(7);
        map.put('0', 0);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for (int i = 0; i < length; i++){
            char curLetter = s.charAt(i);
            if((curLetter == 'I' || curLetter == 'X'
                    || curLetter == 'C') && (pendingChar == '0' || map.get(pendingChar) >= map.get(curLetter))){
                if(pendingChar == '0'){
                    pendingChar = curLetter;
                }else{
                    result += map.get(pendingChar);
                    pendingChar = curLetter;
                }
            }else{
                if(curLetter == 'V' || curLetter == 'X'){
                    if(pendingChar == 'I'){
                        result += map.get(curLetter) - map.get(pendingChar);
                    }else{
                        result += map.get(curLetter) + map.get(pendingChar);
                    }
                }else if(curLetter == 'L' || curLetter == 'C'){
                    if(pendingChar == 'X'){
                        result += map.get(curLetter) - map.get(pendingChar);
                    }else{
                        result += map.get(curLetter) + map.get(pendingChar);
                    }
                }else if(curLetter == 'D' || curLetter == 'M'){
                    if(pendingChar == 'C'){
                        result += map.get(curLetter) - map.get(pendingChar);
                    }else{
                        result += map.get(curLetter) + map.get(pendingChar);
                    }
                }else{
                    result += map.get(curLetter) + map.get(pendingChar);
                }
                pendingChar = '0';
            }
        }
        result += map.get(pendingChar);
        return result;
    }

    public int romanToInt(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>(7);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        if(s.length() == 1){
            return map.get(s.charAt(0));
        }
        int length = s.length();
        int result = map.get(s.charAt(length - 1));
        for (int i = length - 2; i >= 0; i--){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                result -= map.get(s.charAt(i));
            }else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        _13RomanToInteger romanToInteger = new _13RomanToInteger();
        String s = "MDCCCLXXXIV";
        String ss = "MCMXCIV";
        System.out.println("romanToInteger = " + romanToInteger.romanToInt(ss));
    }
}
