/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

import java.util.Scanner;

/**
 *
 * @author Suraj Singh
 */
class LPS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int len = str.length();
        int max=-1;
        int lps[][] = new int[len][len];
        for(int i=0;i<len;i++)
            lps[i][i] = 1;
        for(int i=len-1;i>=0;i--)
        {
            for(int j=i+1;j<len;j++)
            {
                if(str.charAt(i)==str.charAt(j))
                    lps[i][j] = 2+lps[i+1][j-1];
                else
                    lps[i][j] = Math.max(lps[i+1][j],lps[i][j-1]);
                if(lps[i][j]>max)
                    max = lps[i][j];
            }
        }
       System.out.println(lps[0][len-1]);
    }
}
