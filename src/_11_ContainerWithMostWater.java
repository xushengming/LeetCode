public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++){
            for (int j = i + 1; j < height.length; j++){
                int area = Math.min(height[i], height[j]) * (j - i);
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while(left < right)
        {
            int sum = Math.min(height[left], height[right]) * (right - left);
            if(sum > max)
                max = sum;
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
    public static void main(String[] args) {
        _11_ContainerWithMostWater containerWithMostWater = new _11_ContainerWithMostWater();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println("containerWithMostWater = " + containerWithMostWater.maxArea2(height));
    }
}
