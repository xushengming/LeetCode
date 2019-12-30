//Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2. 
//
// You have the following 3 operations permitted on a word: 
//
// 
// Insert a character 
// Delete a character 
// Replace a character 
// 
//
// Example 1: 
//
// 
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation: 
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
// 
//
// Example 2: 
//
// 
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation: 
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
// 
// Related Topics String Dynamic Programming
  package leetcode.editor.en;
  public class _72_EditDistance{
      public static void main(String[] args) {
           Solution solution = new _72_EditDistance().new Solution();
           System.out.println(solution.minDistance("horse", "ros"));
          System.out.println(solution.minDistance("intention", "execution"));
          System.out.println(solution.minDistance("dinitrophenylhydrazine",
                  "acetylphenylhydrazine"));
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance_DP_Bottom_Top(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int replace = cost[i][j];
                    int delete = cost[i][j + 1];
                    int insert = cost[i + 1][j];
                    cost[i + 1][j + 1] = Math.min(Math.min(replace, delete), insert);
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }
    public int minDistance(String word1, String word2) {
        if(word1 == null & word2 == null){
            return 0;
        }
        if(word1 == null){
            return word2.length();
        }
        if(word2 == null){
            return word1.length();
        }
       int[][] count = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++){
            for (int j = 0; j <= word2.length(); j++){
                count[i][j] = -1;
            }
        }
        return min(word1, 0, word2, 0, count);
    }

    private int min(String word1, int index1, String word2,
                    int index2, int[][] count){
        int currentCount = 0;
        if(index1 == word1.length() && index2 == word2.length()){
            return 0;
        }
        if(count[index1][index2] >= 0){
            return count[index1][index2];
        }
        if(index1 < word1.length() && index2 < word2.length()){
            if(word1.charAt(index1) == word2.charAt(index2)){
                currentCount += min(word1, index1 + 1, word2, index2 + 1,
                        count);
            }else{
                    currentCount += Math.min(Math.min(min(word1, index1, word2, index2 + 1, count)
                    , min(word1, index1 + 1, word2, index2, count)),
                            min(word1, index1 + 1, word2, index2 + 1, count)) + 1;
            }
        }else{
            if(index2 >= word2.length()){
                currentCount += min(word1, index1 + 1, word2, index2, count) + 1;
            }else{
                currentCount += min(word1, index1 , word2, index2 + 1, count) + 1;
            }
        }
        count[index1][index2] = currentCount;
        return currentCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}