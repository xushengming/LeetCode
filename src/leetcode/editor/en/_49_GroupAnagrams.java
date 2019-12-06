//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics Hash Table String

  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _49_GroupAnagrams{
      public static void main(String[] args) {
           Solution solution = new _49_GroupAnagrams().new Solution();
           String[] strs = new String[]{"tit", "huh"};
           List<List<String>> result = solution.groupAnagrams2(strs);
           for (List<String> list : result){
              for (String str : list){
                  System.out.print(str + " ");
              }
              System.out.println();
           }
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();
        int[] arrayForSort = new int[26];
        for (String str : strs){
            for (int i = 0; i < 26; i ++){
                arrayForSort[i] = 0;
            }
            String key = "";
            for (int i = 0; i < str.length(); i++){
                arrayForSort[str.charAt(i) - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++){
                if(arrayForSort[i] != 0){
                    stringBuilder.append((char)(i + 'a'))
                            .append("_")
                            .append(arrayForSort[i]);
                }
            }
            key = stringBuilder.toString();
            if(hashMap.containsKey(key)){
                hashMap.get(key).add(str);
            }else {
                List<String> valueList = new ArrayList<>();
                valueList.add(str);
                hashMap.put(key, valueList);
            }
        }
        return new ArrayList<>(hashMap.values());
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if(hashMap.containsKey(key)){
                hashMap.get(key).add(str);
            }else{
                List<String> valueList = new ArrayList<>();
                valueList.add(str);
                hashMap.put(key, valueList);
            }
        }
        return new ArrayList<>(hashMap.values());
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
