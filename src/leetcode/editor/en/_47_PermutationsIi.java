//Given a collection of numbers that might contain duplicates, return all possible unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking

package leetcode.editor.en;

import java.util.*;

public class _47_PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new _47_PermutationsIi().new Solution();
//          int[] nums = new int[]{1, 1, 2};
        int[] nums = new int[]{2, 2, 1, 1};
        List<List<Integer>> result = solution.permuteUnique4(nums);
        for (List<Integer> list : result){
            for (int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique4(int[] nums) {
            if(nums == null || nums.length == 0){
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            permuteUniqueBacktrack(nums, result, new ArrayList<>(), new boolean[nums.length]);
            return result;
        }

        private void permuteUniqueBacktrack(int[] nums, List<List<Integer>> result,
                                            List<Integer> currentList, boolean[] used){
            if(currentList.size() == nums.length){
                result.add(new ArrayList<>(currentList));
                return;
            }
            for (int i = 0; i < nums.length; i++){
                if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])){
                    continue;
                }else{
                    used[i] = true;
                    currentList.add(nums[i]);
                    permuteUniqueBacktrack(nums, result, currentList, used);
                    currentList.remove(currentList.size() - 1);
                    used[i] = false;
                }
            }
        }

        public List<List<Integer>> permuteUnique3(int[] nums) {
            if(nums == null || nums.length == 0){
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> primary = new ArrayList<>();
            primary.add(nums[0]);
            result.add(primary);
            if(nums.length > 1){
                for (int i = 1; i < nums.length; i++){
                    List<List<Integer>> tmp = new ArrayList<>();
                    for (List<Integer> list : result){
                        int j = 0;
                        while (j <= i){
                            List<Integer> current = new ArrayList<>(list);
                            current.add(j, nums[i]);
                            tmp.add(current);
                            if(j < current.size() - 1 && nums[i] == current.get(j + 1)){
                                break;
                            }
                            j++;
                        }
                    }
                    result = tmp;
                }
            }
            return result;
        }
        public List<List<Integer>> permuteUnique2(int[] nums) {
            if(nums == null || nums.length == 0){
                return new ArrayList<>();
            }
            Set<List<Integer>> result = new HashSet<>();
            List<Integer> primary = new ArrayList<>();
            primary.add(nums[0]);
            result.add(primary);
            if(nums.length > 1){
                for (int i = 1; i < nums.length; i++){
                    Set<List<Integer>> tmp = new HashSet<>();
                    for (int j = 0; j <= i; j++){
                        for (List<Integer> list : result){
                            List<Integer> current = new ArrayList<>(list);
                            current.add(j, nums[i]);
                            tmp.add(current);
                        }
                    }
                    result = tmp;
                }
            }
            List<List<Integer>> resultList = new ArrayList<>(result);
            return resultList;
        }

        public List<List<Integer>> permuteUnique(int[] nums) {
            if(nums == null || nums.length == 0){
                return new ArrayList<>();
            }
            Map<Integer, Integer> frequenceMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
                int num = nums[i];
                if(frequenceMap.containsKey(num)){
                    frequenceMap.put(num, frequenceMap.get(num) + 1);
                }else {
                    frequenceMap.put(num, 1);
                }
            }
            List<List<Integer>> result = new ArrayList<>();
            permuteUnique(frequenceMap, result, new ArrayList<>(), nums.length);
            return result;
        }

        private void permuteUnique(Map<Integer, Integer> map, List<List<Integer>> result, List<Integer> currentList, int length){
            if(currentList.size() == length){
                List<Integer> tmp = new ArrayList<>(currentList);
                result.add(tmp);
                return;
            }
            for (int key : map.keySet()){
                int count = map.get(key);
                if(count > 0){
                    map.put(key, count - 1);
                    currentList.add(key);
                    permuteUnique(map, result, currentList, length);
                    currentList.remove(currentList.size() - 1);
                    map.put(key, count);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
