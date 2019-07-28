import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length <= 0){
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if(nums[i] > 0){
                continue;
            }
            int l = i + 1;
            int h = length - 1;
            if(nums[h] < 0){
                continue;
            }
            while (l < h){
                int sum = nums[i] + nums[l] + nums[h];
                if(sum == 0){
                    result.add(Arrays.asList(nums[l], nums[i], nums[h]));
                    while (l < h && nums[l] == nums[l + 1]){
                        l++;
                    }
                    l++;

                    while (l < h && nums[h] == nums[h - 1]){
                        h--;
                    }
                    h--;
                }else if(sum < 0){
                    while (l < h && nums[l] == nums[l + 1]){
                        l++;
                    }
                    l++;
                }else{
                    while (l < h && nums[h] == nums[h - 1]){
                        h--;
                    }
                    h--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _15ThreeSum threeSum = new _15ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.threeSum(nums);
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
