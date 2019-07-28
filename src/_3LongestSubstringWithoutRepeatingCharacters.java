import java.util.HashMap;

public class _3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int length = s.length();
        int maxLength = 0;
        for (int i = 0, j = 0; j < length; j++){
            if(hashMap.containsKey(s.charAt(j))){
                i = Math.max(hashMap.get(s.charAt(j)), i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            hashMap.put(s.charAt(j), j + 1);
        }
        return maxLength;
    }
}
