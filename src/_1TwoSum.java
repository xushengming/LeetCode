import java.util.HashMap;

public class _1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    public int[] twoSumHashMap(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] arrays = {2, 11, 7, 15};
        int target = 9;
        _1TwoSum instance = new _1TwoSum();
        int[] result = instance.twoSumHashMap(arrays, target);
        if(result != null){
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < result.length; i++){
                sb.append(result[i]);
                if(i != result.length - 1){
                    sb.append(", ");
                }
            }
            sb.append("]");
            System.out.printf(sb.toString());
        }else {
            System.out.printf("null");
        }
    }
}
