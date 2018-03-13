/**
 *
 *Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution.

 * */
class Solution {
    public void solveSudoku(char[][] board) {
        this.solve(board);
    }
    private boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(inPlace(i,j,board,c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            }else{
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
    private boolean inPlace(int row, int col,char[][] board,char c){
        if(row > 8 || col > 8 ) return false;
        for(int i = 0; i < 9; i++){
            if(board[row][i] == c && i != col) return false;
            if(board[i][col] == c && i != row) return false;
        }
        int relativeRowStart = row / 3 * 3; //Quick locating e.g. 5/3 = 1; 1*3 = 3
        int relativeColStart = col / 3 * 3;
        for(int i = relativeRowStart; i < relativeRowStart + 3; i++){
            for(int j = relativeColStart; j < relativeColStart + 3; j++){
                if(c == board[i][j] && (row != i || col != j)) return false;
            }
        }
        return true;
    }
}