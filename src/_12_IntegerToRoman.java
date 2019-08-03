import java.util.ArrayList;
import java.util.HashMap;

public class _12_IntegerToRoman {
    public String intToRoman(int num) {
        HashMap<Integer, String> symbolMap = new HashMap<Integer, String>(7);
        symbolMap.put(1, "I");
        symbolMap.put(5, "V");
        symbolMap.put(10, "X");
        symbolMap.put(50, "L");
        symbolMap.put(100, "C");
        symbolMap.put(500, "D");
        symbolMap.put(1000, "M");
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> flags = new ArrayList<>(7);
        flags.add(1000);
        flags.add(500);
        flags.add(100);
        flags.add(50);
        flags.add(10);
        flags.add(5);
        flags.add(1);
        if(num >= 1000){
            int result = num / 1000;
            num = num % 1000;
            for (int i = 0; i < result; i++){
                stringBuilder.append(symbolMap.get(1000));
            }
        }
        boolean useCurrent = false;
        for (int i = 1; i < flags.size(); i++){
            int above = flags.get(i - 1);
            int below = i == (flags.size() - 1) ? 0 : flags.get(i + 1);
            int current = flags.get(i);
            int flag = useCurrent ? above - current : above - below;
            if(num >= flag){
                if(useCurrent){
                    stringBuilder.append(symbolMap.get(current)).append(symbolMap.get(above));
                }else{
                    stringBuilder.append(symbolMap.get(below)).append(symbolMap.get(above));
                }
                num = num % flag;
            }else if(num > current){
                int result = num / current;
                num = num % current;
                for (int j = 0; j < result; j++){
                    stringBuilder.append(symbolMap.get(current));
                }
            }else if(num == current){
                stringBuilder.append(symbolMap.get(current));
                break;
            }
            useCurrent = !useCurrent;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        _12_IntegerToRoman integerToRoman = new _12_IntegerToRoman();
        int num = 1000;
        System.out.println("integerToRoman = " + integerToRoman.intToRoman(num));
    }

}
