import java.util.Arrays;

public class _31_Next_Permutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int [] array, int start){
        int end = array.length - 1;
        while (start < end){
            swap(array, start, end);
            start++;
            end--;
        }
    }
    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        _31_Next_Permutation permutation = new _31_Next_Permutation();
        int[] array = {1, 3, 2};
        permutation.nextPermutation(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
