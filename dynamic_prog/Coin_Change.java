/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Suraj Singh
 */
class Coin_Change {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum = s.nextInt();
        int n = s.nextInt();
        int coins[] = new int[n];
        for(int i=0;i<n;i++)
            coins[i] = s.nextInt();
        Arrays.sort(coins);
        int solutions[][] = new int[sum+1][n];
        int solution[] = new int[sum+1];
        for(int i=0;i<n;i++)
            solutions[0][i] = 1;
        for(int i=1;i<=sum;i++)
            for(int j=0;j<n;j++)
            {
                if(i-coins[j]>=0)
                    solutions[i][j] = solutions[i-coins[j]][j]+ (j-1>=0?solutions[i][j-1]:0);
                else
                    solutions[i][j] = (j-1>=0?solutions[i][j-1]:0);
            }
        solution[0]=1;
//        for(int i=1;i<=sum;i++)
//            solution[i] = (i-coins[0]==0 || solution[i-coins[0]]>0) ? 1 :0;
        
        for(int j=0;j<n;j++)
        {
            for(int i=1;i<=sum;i++)
                if(i-coins[j]>=0)
                    solution[i] = solution[i]+solution[i-coins[j]];                
        }
        System.out.println(solutions[sum][n-1]);
        System.out.println(solution[sum]);
    }
}
