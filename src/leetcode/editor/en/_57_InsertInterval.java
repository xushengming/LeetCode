//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary). 
//
// You may assume that the intervals were initially sorted according to their start times. 
//
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]. 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature. 
// Related Topics Array Sort
  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _57_InsertInterval{
      public static void main(String[] args) {
           Solution solution = new _57_InsertInterval().new Solution();
//           int[][] input = new int[][]{{1,3},{6,9}};
//           int[] interval = new int[]{2, 5};
          int[][] input = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
          int[] interval = new int[]{4, 8};
          int[][] result = solution.insert2(input, interval);
           for (int[] items : result){
               for (int item : items){
                   System.out.print(item + " ");
               }
               System.out.println();
           }
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0){
            return new int[][]{newInterval};
        }
        if(newInterval == null || newInterval.length == 0){
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals){
            if(newInterval == null || interval[1] < newInterval[0]){
                result.add(interval);
            }else if(interval[0] > newInterval[1]){
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            }else{
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if(newInterval != null){
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][2]);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0){
            return new int[][]{newInterval};
        }
        if(newInterval == null || newInterval.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        boolean catchStart = false;
        List<int[]> result = new ArrayList<>();
        int i = 0;
        for (i = 0; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(!catchStart){
                if(!(newInterval[1] < interval[0])
                        && !(interval[1] < newInterval[0])){
                    interval[0] = Math.min(interval[0], newInterval[0]);
                    interval[1] = Math.max(interval[1], newInterval[1]);
                    result.add(interval);
                    catchStart = true;
                }else{
                   if(newInterval[1] < interval[0]){
                       result.add(newInterval);
                       catchStart = true;
                   }
                    result.add(interval);
                }
            }else{
                if(interval[0] <= result.get(result.size() - 1)[1]){
                    result.get(result.size() - 1)[1] = Math.max(interval[1],
                            result.get(result.size() - 1)[1]);
                }else{
                    result.add(interval);
                    i++;
                    break;
                }
            }
        }
        if(!catchStart){
            result.add(newInterval);
        }else{
            while (i < intervals.length){
                result.add(intervals[i++]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}