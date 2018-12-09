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
class Edit_Distance {
    public static int Minimum(int a, int b,int c)
    {
        if(a<b && a<c)
            return a;
        else if(b<c)
            return b;
        else return c;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2,str3;
        str2 = s.next();
        int l,r;
        l = str1.length()+1;
        r = str2.length()+1;
        int e[][] = new int[l][r];
        for(int i=0;i<l;i++)
            e[i][0] = i;
        for(int i=0;i<r;i++)
            e[0][i]=i;
        for(int i=1;i<l;i++)
            for(int j=1;j<r;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    e[i][j] = Minimum(1+e[i-1][j],1+e[i][j-1],e[i-1][j-1]);
                else
                    e[i][j] = Minimum(e[i-1][j],e[i][j-1],e[i-1][j-1])+1;
            }
        System.out.println(e[l-1][r-1]);
    }
}
