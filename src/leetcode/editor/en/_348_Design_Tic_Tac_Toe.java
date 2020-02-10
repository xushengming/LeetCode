package leetcode.editor.en;

public class _348_Design_Tic_Tac_Toe {
    class TicTacToe2 {
        private int count;
        private int[] rows;
        private int[] columns;
        private int diagonal = 0;
        private int reverseDiagonal = 0;
        /** Initialize your data structure here. */
        public TicTacToe2(int n) {
            this.count = n;
            rows = new int[n];
            columns = new int[n];
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int toAdd = player == 1 ? 1 : -1;
            rows[row] += toAdd;
            columns[col] += toAdd;
            if(row == col){
                diagonal += toAdd;
            }
            if(row + col == count - 1){
                reverseDiagonal += toAdd;
            }
            return (Math.abs(rows[row]) == count || Math.abs(columns[col]) == count
                    || Math.abs(diagonal) == count || Math.abs(reverseDiagonal) == count) ? player : 0;
        }
    }
    class TicTacToe {
        private int[][] board;
        private int count;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            this.count = n;
            board = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    board[i][j] = 0;
                }
            }
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            if(board[row][col] != 0){
                throw new RuntimeException("can not place here");
            }
            board[row][col] = player;
            boolean winInRow = true;
            boolean winInColumn = true;
            boolean winInDiagonal45 = true;
            boolean winInDiagonal135 = true;
            for (int i = 0; i < count; i++){
                if(winInRow){
                    if(board[row][i] != player){
                        winInRow = false;
                    }
                }
                if(winInColumn){
                    if(board[i][col] != player){
                        winInColumn = false;
                    }
                }
                if(row == col || row + col == count - 1){
                    if(row == col){
                        if(winInDiagonal45){
                            if(board[i][i] != player){
                                winInDiagonal45 = false;
                            }
                        }
                    }else{
                        winInDiagonal45 = false;
                    }
                    if(row + col == count - 1) {
                        if (winInDiagonal135) {
                            if(board[i][count - 1 - i] != player){
                                winInDiagonal135 = false;
                            }

                        }
                    }else{
                        winInDiagonal135 = false;
                    }
                }else{
                    winInDiagonal45 = false;
                    winInDiagonal135 = false;
                }
            }
            return winInRow || winInColumn || winInDiagonal45 || winInDiagonal135 ? player : 0;
        }
    }
}
