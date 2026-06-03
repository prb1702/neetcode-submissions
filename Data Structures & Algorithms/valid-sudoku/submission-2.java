class Solution {

    public boolean solve(char[][] board){

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;

                if(!isSafe(i,j,board[i][j],board)) return false;
            }
        }

        return true;
    }

    public boolean isSafe(int row, int col, char ch, char[][] board){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == ch && i != col) return false;
        }

        for(int i = 0; i < 9; i++){
            if(board[i][col] == ch && i != row) return false;
        }

        int srow = (row/3)*3;
        int scol = (col/3)*3;

        for(int i = srow; i < srow + 3; i++){
            for(int j = scol; j < scol + 3; j++){
                if(board[i][j] == ch && i != row && j != col) return false;
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }
}
