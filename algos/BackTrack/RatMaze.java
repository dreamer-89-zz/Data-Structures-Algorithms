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
public class RatMaze {

    /**
     * @param args the command line arguments
     */
    static int solution[][];
    public static void print()
    {
        for(int i=0;i<solution.length;i++)
        {
            for(int j=0;j<solution[i].length;j++)
            {
                if(solution[i][j]==1)
                {
                    System.out.print("("+i+","+j+")\n");
                }
            }
        }
    }
    public static void solve(int maze[][],int x,int y)
    {
        if(x>maze.length || y>maze[x].length)return;
         if(x==maze.length-1 && y==maze[x].length-1)
         {
             print();
             return;
         }
         if(x+1<maze.length && maze[x+1][y]==1)
         {
             solution[x+1][y]=1;
             solve(maze,x+1,y);
             solution[x+1][y]=0;
         }
         if(y+1<maze[x].length && maze[x][y+1]==1)
         {
             solution[x][y+1]=1;
             solve(maze,x,y+1);
             solution[x][y+1]=0;
         }
    }
    public static void main(String[] args) {
        int maze[][] = new int[][]{
                                {1,0,0,0},
                                {1,1,1,1},
                                {0,1,0,1},
                                {1,1,0,1}};
        solution = new int[maze.length][maze[0].length];
        solution[0][0]=1;
        solve(maze,0,0);
    }
    
}
