import java.util.Arrays;

public class _16ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1;
            int h = length - 1;
            while (l < h){
                int sum = nums[l] + nums[i] + nums[h];
                if(Math.abs(sum - target) <= Math.abs(result - target)){
                    result = sum;
                    if(sum == target){
                        return sum;
                    }else if(sum > target){
                        while (l < h && nums[h] == nums[h - 1]){
                            h--;
                        }
                        h--;
                    }else{
                        while (l < h && nums[l] == nums[l + 1]){
                            l++;
                        }
                        l++;
                    }
                }else if(sum < result){
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
        _16ThreeSumClosest threeSumClosest = new _16ThreeSumClosest();
        int[] nums = {0,2,1,-3};
        int result = threeSumClosest.threeSumClosest(nums, 1);
        System.out.println("result " + result);
    }
}
