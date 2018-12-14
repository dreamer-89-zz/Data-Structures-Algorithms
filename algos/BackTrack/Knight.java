/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTrack;

import java.util.Arrays;

/**
 *
 * @author Suraj Singh
 */
public class Knight {

    /**
     * @param args the command line arguments
     */    
    static int movex[] = {2,2,1,1,-1,-1,-2,-2};
    static int movey[] = {1,-1,2,-2,2,-2,1,-1};
    static int solution[][] = new int[movex.length][movex.length];
    public static boolean safe(int solution[][],int x, int y)
    {
        if(x >=0 && x<solution.length && y>=0 && y <solution.length && solution[x][y]==-1)
            return true;
        return false;
    }
    public static boolean setSolution(int totalmoves, int x, int y)
    {
        if(totalmoves==solution.length*solution.length)
            return true;
        int nextx,nexty;
        for(int i=0;i<solution.length;i++)
        {
            nextx = x+movex[i];
            nexty = y+movey[i];
            if(safe(solution,nextx,nexty))
            {
                solution[nextx][nexty]=totalmoves;
                if(setSolution(totalmoves+1,nextx,nexty))
                    return true;
                solution[x][y]=-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        for(int i=0;i<movex.length;i++)
        {
            for(int j=0;j<movey.length;j++)
                solution[i][j]=-1;
        }
        solution[0][0]=0;
        setSolution(1,0,0);
        for(int i=0;i<movex.length;i++)
        {
            for(int j=0;j<movey.length;j++)
                System.out.print(solution[i][j]+" ");
            System.out.println();
        }
    }    
}
