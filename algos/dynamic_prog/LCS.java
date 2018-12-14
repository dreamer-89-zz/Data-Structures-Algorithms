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
class LCS {
    public static int Maximum(int a, int b)
    {
        if(a>b)
            return a;
        else
            return b;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1,str2,str3="";
        str1 = s.next();
        str2 = s.next();
        int lcs[][] = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length();i++)
            lcs[0][i]=0;
        for(int i=0;i<str2.length();i++)
            lcs[0][i]=0;
        for(int i=1;i<=str1.length();i++)
            for(int j=1;j<=str2.length();j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    lcs[i][j] = 1+lcs[i-1][j-1];
                else
                    lcs[i][j] = Maximum(lcs[i][j-1],lcs[i-1][j]);
            }
        for(int i=str1.length(),j=str2.length();i>=1 && j>=1;)
        {
            while(j>=1 && lcs[i][j]==lcs[i][j-1])
                j--;
            while(i>=1 && lcs[i][j]==lcs[i-1][j])
                i--;
            if(i>=1 && j>=1)
                str3 = str2.charAt(j-1)+str3;
            i--;j--;
        }
        System.out.println(str3);
    }
}

