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
class Cutting_Rod {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int arr[] = new int[length+1];
        int max_price[] = new int[length+1];
        int max=-1;
        for(int i=1;i<=length;i++)
            max_price[i] = arr[i] = s.nextInt();
        for(int i=1;i<=length;i++)
        {
            max = max_price[i];
            for(int j=1;j<=i/2;j++)
            {
                if(max < max_price[i-j]+max_price[j])
                    max = max_price[i-j]+max_price[j];
            }
            max_price[i] = max;
        }
        System.out.println(max);
    }
}
