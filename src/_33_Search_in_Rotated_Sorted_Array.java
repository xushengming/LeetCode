public class _33_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        return binarySearch(nums, lo, hi, target);
    }

    private int binarySearch(int[] nums, int lo, int hi, int target){
        if(lo > hi){
            return -1;
        }
        int mid = (lo + hi) / 2;
        if(nums[mid] == target){
            return mid;
        }else {
            int result = binarySearch(nums, mid + 1, hi, target);
            if(result == -1){
                result = binarySearch(nums, lo, mid - 1, target);
            }
            return result;
        }
    }

    public int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int rot;
        while (lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        rot = lo;
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            int realMid = (mid + rot) % nums.length;
            if(nums[realMid] == target){
                return realMid;
            }else if(nums[realMid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,7,0,1,2};
        int target = 3;
        _33_Search_in_Rotated_Sorted_Array search = new _33_Search_in_Rotated_Sorted_Array();
        int result = search.search(array, target);
        System.out.println(result);
    }
}
