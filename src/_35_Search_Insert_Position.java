public class _35_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo;
    }
}
