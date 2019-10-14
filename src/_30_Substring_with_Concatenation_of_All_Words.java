import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推荐阅读 https://leetcode.wang/leetCode-30-Substring-with-Concatenation-of-All-Words.html
 * 中有 O(n) 的算法，在此不赘述
 */
public class _30_Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words == null || words.length == 0){
            return new ArrayList<>();
        }
        int length = words[0].length() * words.length;
        if(s == null || s.length() < length){
            return new ArrayList<>();
        }
        int[] occurrence = new int[words.length];
        int itemLength = words[0].length();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - length + 1; i++){
            for (int n = 0; n < occurrence.length; n++){
                occurrence[n] = 0;
            }
            String subString = s.substring(i, i + length);
            for (int j = 0; j < words.length; j++){
                String str = subString.substring(j * itemLength, (j + 1) * itemLength);
                for (int k = 0; k < words.length; k++){
                    if(str.equals(words[k])){
                        if(occurrence[k] != 1){
                            occurrence[k] = 1;
                            break;
                        }
                    }
                }
            }

            int sum = 0;
            for (int m = 0; m < occurrence.length; m++){
                sum += occurrence[m];
            }
            if(sum == occurrence.length){
                result.add(i);
            }

        }
        return result;
    }


    public List<Integer> findSubstring2(String s, String[] words) {
        if(words == null || words.length == 0){
            return new ArrayList<>();
        }
        int length = words[0].length() * words.length;
        if(s == null || s.length() < length){
            return new ArrayList<>();
        }
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }


    public static void main(String[] args) {
        _30_Substring_with_Concatenation_of_All_Words substring = new _30_Substring_with_Concatenation_of_All_Words();
        String[] array = new String[]{"word","good","best","good"};
        List<Integer> result = substring.findSubstring("wordgoodgoodgoodbestword",
                array);
    }
}
