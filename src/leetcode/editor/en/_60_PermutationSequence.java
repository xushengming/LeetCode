//The set [1,2,3,...,n] contains a total of n! unique permutations. 
//
// By listing and labeling all of the permutations in order, we get the following sequence for n = 3: 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// Given n and k, return the kth permutation sequence. 
//
// Note: 
//
// 
// Given n will be between 1 and 9 inclusive. 
// Given k will be between 1 and n! inclusive. 
// 
//
// Example 1: 
//
// 
//Input: n = 3, k = 3
//Output: "213"
// 
//
// Example 2: 
//
// 
//Input: n = 4, k = 9
//Output: "2314"
// 
// Related Topics Math Backtracking
  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class _60_PermutationSequence{
      public static void main(String[] args) {
           Solution solution = new _60_PermutationSequence().new Solution();
           System.out.println(solution.getPermutation(9, 4));
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getPermutation(int n, int k) {
        if(n <= 0 || k <= 0){
            return "";
        }
        int[] fac = new int[n + 1];
        fac[0] = 1;
        int product = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            nums.add(i);
            product *= i;
            fac[i] = product;
        }
        if(k > fac[n]){
            return "";
        }
        k--;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++){
            int index = k / fac[n - i];
            stringBuilder.append(nums.get(index));
            nums.remove(index);
            k -= index * fac[n - i];
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}