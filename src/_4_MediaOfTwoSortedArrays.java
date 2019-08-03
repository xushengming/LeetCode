public class _4_MediaOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if(length1 == 1 && length2 == 1){
            return (double)((nums1[0] + nums2[0]) / 2);
        }
        if(nums2[0] >= nums1[length1 - 1]
                || nums1[0] >= nums2[length2 - 1]){
            if((length1 + length2) %2 == 0){
                int position = (length1 + length2) / 2;
                if(position <= length1 - 1){
                    return nums1[position];
                }else {
                    return nums2[position - length1];
                }
            }else {
                int positionLeft = (length1 + length2) / 2 - 1;
                int positionRight = (length1 + length2) / 2;
                int leftNum, rightNum;
                if(positionLeft <= length1 - 1){
                    leftNum = nums1[positionLeft];
                }else {
                    leftNum = nums2[positionLeft - length1];
                }
                if(positionRight <= length1 - 1){
                    rightNum = nums1[positionRight];
                }else {
                    rightNum = nums2[positionRight - length1];
                }
                return (double)((leftNum + rightNum) / 2);
            }
        }else{
            if(nums2[0] >= nums1[0] && nums2[length2 - 1] <= nums1[length1 - 1]){

            }
        }

        return 0;

    }
}
