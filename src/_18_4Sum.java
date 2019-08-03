import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4Sum {
    //performance:
    //Runtime: 3 ms, faster than 100.00% of Java online submissions for 4Sum.
    //Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for 4Sum.
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null){
            return results;
        }
        int length = nums.length;
        if(length < 4){
            return results;
        }
        Arrays.sort(nums);
        if(nums[0] * 4 > target
                || nums[length - 1] * 4 < target){
            return results;
        }
        for (int i = 0; i < length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if(nums[i] * 4 > target){
                return results;
            }
            if(nums[i] + nums[length - 1] * 3 < target){
                continue;
            }
            for (int j = i + 1; j < length; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int subTargetForThree = target - nums[i];
                if(nums[j] * 3 > subTargetForThree){
                    break;
                }
                if(nums[j] + nums[length - 1] * 2 < subTargetForThree){
                    continue;
                }
                int lo = j + 1;
                int hi = length - 1;
                if(lo >= hi){
                    continue;
                }
                int subTargetForTwo = target - nums[i] - nums[j];
                if(nums[lo] * 2 > subTargetForTwo){
                    continue;
                }
                if(nums[hi] * 2 < subTargetForTwo){
                    continue;
                }
                while (lo < hi){
                    int sum = nums[lo] + nums[hi];
                    if(sum == subTargetForTwo){
                        results.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]){
                            lo++;
                        }
                        lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]){
                            hi--;
                        }
                        hi--;
                    }else if(sum < subTargetForTwo){
                        while (lo < hi && nums[lo] == nums[lo + 1]){
                            lo++;
                        }
                        lo++;
                    }else{
                        while (lo < hi && nums[hi] == nums[hi - 1]){
                            hi--;
                        }
                        hi--;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        _18_4Sum sum = new _18_4Sum();
        int[] input = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = sum.fourSum(input, target);
        int length = result.size();
        for (int i = 0; i < length; i++){
            List<Integer> answer = result.get(i);
            for (int j = 0; j < answer.size(); j++){
                System.out.printf(answer.get(j) + " ");
            }
            System.out.printf("\n");
        }
    }
}
