//We are given S, a length n string of characters from the set {'D', 'I'}. (These letters stand for "decreasing" and "increasing".) 
//
// A valid permutation is a permutation P[0], P[1], ..., P[n] of integers {0, 1, ..., n}, such that for all i: 
//
// 
// If S[i] == 'D', then P[i] > P[i+1], and; 
// If S[i] == 'I', then P[i] < P[i+1]. 
// 
//
// How many valid permutations are there? Since the answer may be large, return your answer modulo 10^9 + 7. 
//
// 
//
// Example 1: 
//
// 
//Input: "DID"
//Output: 5
//Explanation: 
//The 5 valid permutations of (0, 1, 2, 3) are:
//(1, 0, 3, 2)
//(2, 0, 3, 1)
//(2, 1, 3, 0)
//(3, 0, 2, 1)
//(3, 1, 2, 0)
// 
//
// 
//
// Note: 
//
// 
// 1 <= S.length <= 200 
// S consists only of characters from the set {'D', 'I'}. 
// 
//
// 
// 
// 
// Related Topics Divide and Conquer Dynamic Programming
  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _903_ValidPermutationsForDiSequence{
      public static void main(String[] args) {
           Solution solution = new Solution();
           long start = System.currentTimeMillis();
           int result = solution.numPermsDISequence("IDDDIIDIIIIIIIIDIDID");
           long end = System.currentTimeMillis();
           System.out.println(result + " cost: " + (end - start));
      }


//leetcode submit region begin(Prohibit modification and deletion)
public static class Solution {
    public int numPermsDISequence(String S) {
        if(S == null || S.length() == 0){
            return 0;
        }
        int length = S.length();
        boolean[] used = new boolean[length + 1];
        Arrays.fill(used, false);
        return permsDI(S, 0, 0, length + 1, used);
    }

    private int permsDI(String S, int index, int startIndex, int endIndex,
                        boolean[] used){
        int count = 0;
        System.out.println("index: " + index + "start: " + startIndex + "end " + endIndex);
        for (int i = startIndex; i < endIndex; i++){
            if(!used[i]){
                if(index == S.length()){
                    return 1;
                }
                used[i] = true;
                boolean increase = false;
                if(S.charAt(index) == 'I'){
                    increase = true;
                }
                count += permsDI(S, index + 1, increase ? Math.min(i + 1, endIndex - 1) : 0,
                        increase ? S.length() + 1 : i, used);
                used[i] = false;
            }
        }
        return (int)(count % (Math.pow(10, 9) + 7));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}