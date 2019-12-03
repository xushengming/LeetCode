//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking

  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations{
      public static void main(String[] args) {
           Solution solution = new _46_Permutations().new Solution();
           int[] nums = new int[]{1, 2, 3};
           List<List<Integer>> result = solution.permute(nums);
           System.out.println(result.size());
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteIterative(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> primary = new ArrayList<>();
        primary.add(nums[0]);
        result.add(primary);
        for (int i = 1; i < nums.length; i++){
            List<List<Integer>> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                for (List<Integer> list : result){
                    ArrayList<Integer> newList = new ArrayList<>(list);
                    newList.add(j, nums[i]);
                    tmp.add(newList);
                }
            }
            result = tmp;
        }
        return result;
    }
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, currentList, result);
        return result;
    }

    private void permute(int[] nums, List<Integer> currentList, List<List<Integer>> result){
        if(currentList.size() == nums.length){
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(currentList);
            result.add(tmp);
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if(!currentList.contains(nums[i])){
                currentList.add(nums[i]);
                permute(nums, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
