import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class _36_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null){
            return true;
        }
        HashMap<Character, Integer> countMap = new HashMap<>(9);
        final int COUNT = 9;
        for (int i = 0; i < COUNT; i++){
            countMap.clear();
            for (int j = 0; j < COUNT; j++){
                char ch = board[i][j];
               if(ch != '.' ){
                   if(countMap.getOrDefault(ch, 0) != 0){
                       return false;
                   }else{
                       countMap.put(ch, 1);
                   }
               }
            }
        }

        for (int i = 0; i < COUNT; i++){
            countMap.clear();
            for (int j = 0; j < COUNT; j++){
                char ch = board[j][i];
                if(ch != '.' ){
                    if(countMap.getOrDefault(ch, 0) != 0){
                        return false;
                    }else{
                        countMap.put(ch, 1);
                    }
                }
            }
        }

        for (int i = 0; i < COUNT; i++){
            countMap.clear();
            int rowStart = (i / 3) * 3;
            int columnStart = (i % 3) * 3;
            for (int j = rowStart; j < rowStart + 3; j++){
                for (int k = columnStart; k < columnStart + 3; k++){
                    char ch = board[j][k];
                    if(ch != '.' ){
                        if(countMap.getOrDefault(ch, 0) != 0){
                            return false;
                        }else{
                            countMap.put(ch, 1);
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuOneTraverse(char[][] board) {
        if(board == null){
            return true;
        }
        HashSet<Character> rowSet = new HashSet<>(9);
        HashSet<Character> columnSet = new HashSet<>(9);
        HashSet<Character> blockSet = new HashSet<>(9);
        for (int i = 0; i < 9; i++){
            rowSet.clear();
            columnSet.clear();
            blockSet.clear();
            for (int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !rowSet.add(board[i][j])){
                    return false;
                }
                if(board[j][i] != '.' && !columnSet.add(board[j][i])){
                    return false;
                }
                int rowIndexStart = (i / 3) * 3;
                int columnIndexStart = (i % 3) * 3;
                int rowIndex = rowIndexStart + j / 3;
                int columnIndex = columnIndexStart + j % 3;
                if(board[rowIndex][columnIndex] != '.' && !blockSet.add(board[rowIndex][columnIndex])){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudokuEncodeToString(char[][] board) {
        if(board == null){
            return true;
        }
        HashSet<String> seenSet = new HashSet<>();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                char ch = board[i][j];
                if(ch != '.'){
                    if(!seenSet.add(ch + " in row " + i)
                    || !seenSet.add(ch + " in column " + j)
                    || !seenSet.add(ch + " in block " + i / 3 + "-" + j / 3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
