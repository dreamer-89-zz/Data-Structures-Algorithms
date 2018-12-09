/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

/**
 *
 * @author Suraj Singh
 */
class Fibonacci_Numbers {
    public static void multiply(long num1[][],long num2[][])
    {
        long temp[][] = new long[2][2];
        temp[0][0] = num1[0][0]*num2[0][0] + num1[0][1]*num2[1][0];
        temp[0][1] = num1[0][0]*num2[0][1] + num1[0][1]*num2[1][1];
        temp[1][0] = num1[1][0]*num2[0][0] + num1[1][1]*num2[1][0];
        temp[1][1] = num1[1][0]*num2[1][0] + num1[1][1]*num2[1][1];
        num1[0][0] = temp[0][0];
        num1[0][1] = temp[0][1];
        num1[1][0] = temp[1][0];
        num1[1][1] = temp[1][1];
        //return num1;
    }
    // calculates and return num^n iteratively
    public static long[][] power(int n)
    {
        long y[][] = new long[][]{{1,1},{1,0}};
        long ans[][] = new long[][]{{1,0},{0,1}};
        while(n>0)
        {
            if(n%2!=0)
                multiply(ans,y);
            multiply(y,y);
            n = n/2;
        }
        return ans;
    }
    public static void main(String[] args) {
        for(int i=0;i<20;i++)
            System.out.println(power(i)[0][0]);
    }
}
