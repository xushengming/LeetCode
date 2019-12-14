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
          List<String> result = solution.fullJustify(strings, width);
          for (String str : result){
              System.out.print("[");
              System.out.print(str);
              System.out.print("]");
              System.out.println();
          }
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
            lengthOfWords += words[end].length();
            int spaceLength = end - start;
            if(lengthOfWords + spaceLength > maxWidth){
                lengthOfWords -= words[end].length();
                end--;
            }else if(lengthOfWords + spaceLength < maxWidth && end < words.length - 1){
                end++;
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            int wordsCount = end - start + 1;
            int spaceCount = maxWidth - lengthOfWords;
            if(wordsCount == 1){
                stringBuilder.append(words[start]);
                for (int i = 0; i < spaceCount; i++){
                    stringBuilder.append(space);
                }
            }else{
                int eachSpace = spaceCount / (wordsCount - 1);
                int remainder = spaceCount % (wordsCount - 1);
                for (int i = start; i <= end; i++){
                    stringBuilder.append(words[i]);
                    int count = 0;
                    if(i != end){
                        if(end == words.length - 1){
                            count = 1;
                        }else{
                            count = eachSpace + (remainder > 0 ? 1 : 0);
                            if(remainder > 0){
                                remainder--;
                            }
                        }
                    }
                    for (int j = 0; j < count; j++){
                        stringBuilder.append(space);
                    }
                }
                int offset = maxWidth - stringBuilder.length();
                if(offset > 0){
                    for (int i = 0; i < offset; i++){
                        stringBuilder.append(space);
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
