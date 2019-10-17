import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class _37_Sudoku_Solver {
    public void solveSudokuDFS(char[][] board) {
        if(board == null){
            return;
        }
        dfs(board, 0);
    }

    public void solveSudokuBackTrace(char[][] board) {
        if(board == null){
            return;
        }
        backTrace(board);
    }

    private boolean backTrace(char[][] board){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for (int k = 1; k <= 9; k++){
                        if(isValid(i, j, (char)(k + '0'), board)){
                            board[i][j] = (char)(k + '0');
                            if(backTrace(board)){
                                return true;
                            }else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(char[][] board, int position){
        if(position == 81){
            return true;
        }
        int rowIndex = position / 9;
        int columnIndex = position % 9;
        if(board[rowIndex][columnIndex] != '.'){
            return dfs(board, position + 1);
        }
        for (int i = 1; i <= 9; i++){
           if(isValid(rowIndex, columnIndex, (char)(i + '0'), board)){
               board[rowIndex][columnIndex] = (char)(i + '0');
               if(dfs(board, position + 1)){
                   return true;
               }else {
                   board[rowIndex][columnIndex] = '.';
               }
           }
        }
        return false;
    }

    private boolean isValid(int rowIndex, int columnIndex, char target, char[][] board){
        for (int i = 0; i < 9; i++){
            if(board[rowIndex][i] == target){
                return false;
            }
            if(board[i][columnIndex] == target){
                return false;
            }
            int blockRowIndexStart = (rowIndex / 3) * 3;
            int blockColumnIndexStart = (columnIndex / 3) * 3;
            if(board[blockRowIndexStart + i / 3][blockColumnIndexStart + i % 3] == target){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
//                                      {'6','.','.','1','9','5','.','.','.'},
//                                      {'.','9','8','.','.','.','.','6','.'},
//                                      {'8','.','.','.','6','.','.','.','3'},
//                                      {'4','.','.','8','.','3','.','.','1'},
//                                      {'7','.','.','.','2','.','.','.','6'},
//                                      {'.','6','.','.','.','.','2','8','.'},
//                                      {'.','.','.','4','1','9','.','.','5'},
//                                      {'.','.','.','.','8','.','.','7','9'}};
        char[][] board = new char[][]{{'.','.','9','7','4','8','.','.','.'},
        {'7','.','.','.','.','.','.','.','.'},
        {'.','2','.','1','.','9','.','.','.'},
        {'.','.','7','.','.','.','2','4','.'},
        {'.','6','4','.','1','.','5','9','.'},
        {'.','9','8','.','.','.','3','.','.'},
        {'.','.','.','8','.','3','.','2','.'},
        {'.','.','.','.','.','.','.','.','6'},
        {'.','.','.','2','7','5','9','.','.'}};
        _37_Sudoku_Solver solver = new _37_Sudoku_Solver();
        solver.solveSudoku_DFS(board);
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
               System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
