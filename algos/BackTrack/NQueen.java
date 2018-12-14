/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Suraj Singh
 */
public class NQueen {

    /**
     * @param args the command line arguments
     */
    static boolean found = false;
    public static boolean safe(char[][] board, char ch, int cx, int cy)
    {
        int x,y;
        x = cx;
        y = cy;
        while(x<board.length)
        {
            if(board[x][y]==ch)
                return false;
            x++;
        }
        x = cx;
        y = cy;
        while(y<board[x].length)
        {
            if(board[x][y]==ch)
            return false;
            y++;
        }
        x = cx;
        y = cy;
        while(x>=0)
        {
            if(board[x][y]==ch)
            return false;
            x--;
        }
        x = cx;
        y = cy;
        while(y>=0)
        {
            if(board[x][y]==ch)
            return false;
            y--;
        }
        x = cx;
        y = cy;
        x = x-x%3;
        y = y- y%3;
        for(int i=x;i<x+3;i++)
        {
            for(int j=y;j<y+3;j++)
            {
                if(board[i][j]==ch)
                    return false;
            }
        }
        return true;
    }
    static char ch[][] =  {
        {'.','.','.'},{'.','.','.'},{'.','.','.'}
//                        {'5','3','.','.','7','.','.','.','.'},
//                        {'6','.','.','1','9','5','.','.','.'},
//                        {'.','9','8','.','.','.','.','6','.'},
//                        {'8','.','.','.','6','.','.','.','3'},
//                        {'4','.','.','8','.','3','.','.','1'},
//                        {'7','.','.','.','2','.','.','.','6'},
//                        {'.','6','.','.','.','.','2','8','.'},
//                        {'.','.','.','4','1','9','.','.','5'},
//                        {'.','.','.','.','8','.','.','7','9'},
                       // {'.','9','8','.','.','.','.','6','.'},
                        };
    public static void solve(char[][] board, int startx, int starty)
    {
        if( (startx==board.length && starty==board[startx].length-1)
        || (startx == board.length-1 && starty == board[startx].length) )
        {
            found = true;
            return;
        }
        for(int i=startx;i<board.length;i++)
        {
            for(int j=starty;j<board[i].length;j++)
            {
                if(board[i][j]=='.')
                {
                    for(int k=1;k<=3;k++)
                    {
                        if(safe(board,(char)(48+k),i,j))
                        {
                            board[i][j]= (char)(48+k);
                            solve(board,i,j+1);
                            if(found)break;
                        }
                    }
                    
                    board[i][j] = '.';
                    if(found)break;
                }
            }
            if(found)break;
        }
    }
    public static void solveSudoku(char[][] board) {
        
        
        solve(ch,0,0);
        return;
    }
    public static void solve(char [][]grid, int x, int y, int num)
    {
        if(x<0 || y <0 || x==grid.length || y==grid[x].length)return;
        //if(grid[x][y]!='0' || grid[x][y]!='1')return;
        if(grid[x][y]=='1')
        {
            grid[x][y]=(char)num;
            solve(grid,x,y+1,num);
            solve(grid,x+1,y,num);
            solve(grid,x-1,y,num);
            solve(grid,x,y-1,num);
        }
    }
    public static int numIslands(char[][] grid) {
        int num=2;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1')
                  {  
                      solve(grid,i,j,num);
                      num++;
                  }
            }
        }
        return num-2;
    }
    public static int largestRectangleArea(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        if(height.length==0)return 0;
        if(height.length==1)return height[0];
        int max=0,index,last,element,value,i=0,slast;
        while(i<height.length || !st.isEmpty())
        {
            if(i<height.length&& (st.isEmpty() || height[st.peek()] <= height[i]))
            {
                st.push(i);
                i++;
            }
            else
            {      
                last = st.pop();
                if(st.isEmpty())
                    value = i*height[last];
                else
                    value = (i-st.peek()-1)*height[last];
                if(value > max)
                max = value;
            }
        }        
        return max;
    }
    public static void main(String[] args) {
        //solveSudoku(null);
        char ch[][] = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
                        };
        largestRectangleArea(new int[]{4,2,0,3,2,5});
    }
}
