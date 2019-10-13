public class _26_RemoveDuplicatesrFomSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++){
            if((nums[j] ^ nums[i]) == 0){
                    //do nothing
            }else {
                if(i - ++j > 0){
                    nums[j] = nums[i];
                }
            }
        }
        return j + 1;
    }
}
