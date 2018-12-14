/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTrack;

/**
 *
 * @author Suraj Singh
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
     public static boolean validRow(char [][]board, char ch,int row, int col)
    {
        while(col+1 < board[row].length)
        {
            if(ch == board[row][++col])
            return false;
        }
        return true;
    }
    public static boolean validCol(char [][]board, char ch, int row, int col)
    {
        while(row+1 < board.length)
        {
            if(ch==board[++row][col])
            return false;
        }
        return true;
    }
    public static boolean validBox(char [][]board, char ch, int row, int col)
    {
        int count=0;
        row = row - row%3;
        col = col - col%3;
        for(int i=row;i<row+3;i++)
        for(int j = col;j<col+3;j++)
        if(ch==board[i][j])
        count++;
        if(count>1)return false;
        return true;
    }
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++)
        for(int j=0;j<board[i].length;j++)
        if(board[i][j]!='.')
        if(!validRow(board,board[i][j],i,j)||!validCol(board,board[i][j],i,j)||!validBox(board,board[i][j],i,j))
        return false;
        return true;
    }
    public static void main(String[] args) {
        
        String conf[] ={"....5..1.",
                        ".4.3.....",
                        ".....3..1",
                        
                        "8......2.",
                        "..2.7....",
                        ".15......",
                        
                        ".....2...",
                        ".2.9.....",
                        "..4......"};
        char board[][] = new char[9][9];
        for(int i=0;i<9;i++)
            board[i] = conf[i].toCharArray();
        System.out.println(isValidSudoku(board));
    }    
}
