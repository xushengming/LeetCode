//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. 
//
// 
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image! 
//
// Example: 
//
// 
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6 
// Related Topics Array Two Pointers Stack

  package leetcode.editor.en;

import java.util.ArrayList;

public class _42_TrappingRainWater{
      public static void main(String[] args) {
           Solution solution = new _42_TrappingRainWater().new Solution();
           int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
//          int[] array = {4, 2, 3};
//          int[] array = {4, 2, 0, 3, 2, 5};
          int result = solution.trap2(array);
           System.out.println(result);
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        ArrayList<Integer> trapList = new ArrayList<>();
        int rainCount = 0;
        for (int i = 1; i < height.length; i++){
            if(height[i] < height[i - 1]){
                trapList.add(i - 1);
            }else if(height[i] > height[i - 1] && trapList.size() > 0){
                int extraHeight = height[i];
                while (trapList.size() > 0){
                    int trapPosition = trapList.get(trapList.size() - 1);
                    if (extraHeight > 0){
                        int innerHeight = 0;
                        for (int j = trapPosition + 1; j < i; j++){
                            if(height[j] > innerHeight){
                                innerHeight = height[j];
                            }
                        }
                        rainCount += (Math.min(height[i], height[trapPosition]) - innerHeight) * (i - trapPosition - 1);
                        extraHeight = height[i] - height[trapPosition];
                        if(height[i] >= height[trapPosition]){
                            trapList.remove(trapList.size() - 1);
                        }
                    }else {
                        break;
                    }
                }
            }
        }
        return rainCount;
    }
    public int trap2(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            if(height[left] < height[right]){
                if(leftMax <= height[left]){
                    leftMax = height[left++];
                }else{
                    sum += leftMax - height[left++];
                }
            }else{
                if(rightMax <= height[right]){
                    rightMax = height[right--];
                }else{
                    sum += rightMax - height[right--];
                }
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
