//Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified. 
//
// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters. 
//
// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right. 
//
// For the last line of text, it should be left justified and no extra space is inserted between words. 
//
// Note: 
//
// 
// A word is defined as a character sequence consisting of non-space characters only. 
// Each word's length is guaranteed to be greater than 0 and not exceed maxWidth. 
// The input array words contains at least one word. 
// 
//
// Example 1: 
//
// 
//Input:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//Output:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// Example 2: 
//
// 
//Input:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//Output:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//Explanation: Note that the last line is "shall be    " instead of "shall     be",
//             because the last line must be left-justified instead of fully-justified.
//             Note that the second line is also left-justified becase it contains only one word.
// 
//
// Example 3: 
//
// 
//Input:
//words = ["Science","is","what","we","understand","well","enough","to","explain",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//Output:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics String

  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class _68_TextJustification{
      public static void main(String[] args) {
           Solution solution = new _68_TextJustification().new Solution();
//           String[] strings = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
//           int width = 16;

//          String[] strings = new String[]{"What","must","be","acknowledgment","shall","be"};
//          int width = 16;

          String[] strings = new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                  "to","a","computer.","Art","is","everything","else","we","do"};
          int width = 20;
          Utils.printStringList(solution.fullJustify(strings, width));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        int lengthOfWords = 0;
        String space = ".";
        while (end < words.length){
            if(lengthOfWords > 0){
                lengthOfWords++;
            }
            lengthOfWords += words[end].length();
            if(lengthOfWords > maxWidth){
                lengthOfWords -= words[end].length();
                lengthOfWords--;
                end--;
            }else if(lengthOfWords < maxWidth && end < words.length - 1){
                end++;
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if(end - start + 1 == 1){
                stringBuilder.append(words[start]);
                for (int i = 0; i < maxWidth - lengthOfWords; i++){
                    stringBuilder.append(space);
                }
            }else if(end - start + 1 == 2){
                stringBuilder.append(words[start]);
                if(end == words.length - 1){
                    stringBuilder.append(space);
                    stringBuilder.append(words[end]);
                    int length = stringBuilder.length();
                    for (int i = 0; i < maxWidth - length; i++){
                        stringBuilder.append(space);
                    }
                }else{
                    for (int i = 0; i < maxWidth - lengthOfWords + 1; i++){
                        stringBuilder.append(space);
                    }
                    stringBuilder.append(words[end]);
                }
            }else{
                if(end == words.length - 1){
                    for (int i = start; i <= end; i++){
                        stringBuilder.append(words[i]);
                        if(i != end){
                            stringBuilder.append(space);
                        }
                    }
                    int length = stringBuilder.length();
                    for (int i = 0; i < maxWidth - length; i++){
                        stringBuilder.append(space);
                    }
                }else{
                    int leftSpace = 1, rightSpace = 1;
                    if(lengthOfWords < maxWidth){
                        int offset = maxWidth - lengthOfWords;
                        leftSpace += offset % 2 == 0 ? offset / 2 : offset / 2 + 1;
                        rightSpace += offset / 2;
                    }
                    stringBuilder.append(words[start++]);
                    for (int i = 0; i < leftSpace; i++){
                        stringBuilder.append(space);
                    }
                    stringBuilder.append(words[start++]);
                    for (int i = 0; i < rightSpace; i++){
                        stringBuilder.append(space);
                    }
                    for (int i = start; i <= end; i++){
                        stringBuilder.append(words[i]);
                        if(i != end){
                            stringBuilder.append(space);
                        }
                    }
                }
            }
            end++;
            start = end;
            lengthOfWords = 0;
            result.add(stringBuilder.toString());
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
