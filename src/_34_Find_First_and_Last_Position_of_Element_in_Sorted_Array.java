public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int lowIndex = binarySearch(nums, 0, nums.length - 1, (float)(target - 0.1));
        if(nums[lowIndex] != target){
            lowIndex++;
        }
        int highIndex = binarySearch(nums, 0, nums.length - 1, (float)(target + 0.1));
        if(nums[highIndex] != target){
            highIndex--;
        }
        if(highIndex < lowIndex){
            return new int[]{-1, -1};
        }
        return new int[]{lowIndex, highIndex};
    }

    private int binarySearch(int[] nums, int lo, int hi, float target){
        int mid = (lo + hi) / 2;
        if(lo >= hi){
            return lo;
        }
        if(nums[mid] < target){
            return binarySearch(nums, mid + 1, hi, target);
        }else if(nums[mid] > target){
            return binarySearch(nums, lo, mid - 1, target);
        }
        return -1;
    }

    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftIndex = searchExtremeIndex(nums, 0, nums.length, target, true);
        if(leftIndex == nums.length || nums[leftIndex] != target){
            return new int[]{-1, -1};
        }
        int rightIndex = searchExtremeIndex(nums, 0, nums.length, target, false) - 1;
        return new int[]{leftIndex, rightIndex};
    }

    public int searchExtremeIndex(int[] nums, int lo, int hi, int target, boolean left){
        while (lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] > target || (left && nums[mid] == target)){
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array find = new _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array();
//        int[] array = new int[]{5,7,7,8,8,10};
        int[] array = new int[]{8} ;
        int target = 8;
        int[] result = find.searchRange2(array, target);
        for (int num : result){
            System.out.print(" " + num);
        }
    }
}
