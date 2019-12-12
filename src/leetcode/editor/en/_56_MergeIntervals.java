//Given a collection of intervals, merge all overlapping intervals. 
//
// Example 1: 
//
// 
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature. 
// Related Topics Array Sort
  package leetcode.editor.en;

import sun.tools.jstat.Literal;

import java.util.*;

public class _56_MergeIntervals{
      public static void main(String[] args) {
           Solution solution = new _56_MergeIntervals().new Solution();
//           int[][] input = new int[][]{{1,3},{2,6},{8,10},{15,18}};
//          int[][] input = new int[][]{{1,4},{4,5}};
          int[][] input = new int[][]{{2,3},{5,5},{2,2},{3,4},{3,4}};
//          int[][] input = new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
          int[][] result = solution.merge(input);
           for (int[] items : result){
               for (int item : items){
                   System.out.print(item + " ");
               }
               System.out.println();
           }
          System.out.println();
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        int startIndex = 0, endIndex = 0;
        int currentStartIndex = 0;
        List<int[]> result = new ArrayList<>();
        while (currentStartIndex < intervals.length){
            if(currentStartIndex + 1 < intervals.length && intervals[currentStartIndex + 1][0] <= intervals[endIndex][1]){
                currentStartIndex++;
                if(intervals[currentStartIndex][1] >= intervals[endIndex][1]){
                    endIndex = currentStartIndex;
                }
            }else{
                result.add(new int[]{intervals[startIndex][0], intervals[endIndex][1]});
                currentStartIndex++;
                startIndex = currentStartIndex;
                endIndex = startIndex;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
    public int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals){
            if(result.size() == 0 || interval[0] > result.get(result.size() - 1)[1]){
                result.add(interval);
            }else{
                result.get(result.size() - 1)[1] = Math.max(interval[1],
                        result.get(result.size() - 1)[1]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}