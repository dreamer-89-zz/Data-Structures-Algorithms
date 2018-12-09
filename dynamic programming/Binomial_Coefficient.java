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
class Binomial_Coefficient {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int cnk[] = new int[k+1];
        cnk[0]=1;
        for(int i=1;i<=n;i++)
            for(int j=Math.min(i, k);j>0;j--)
            {
                cnk[j]= cnk[j-1]+cnk[j];
            }
        System.out.println(cnk[k]);
    }
}
