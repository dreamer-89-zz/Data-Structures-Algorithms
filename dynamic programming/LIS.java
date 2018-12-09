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
class LIS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = s.nextInt();
        int lis[] = new int[n];
        int min,last;
        lis[0]=1;
        for(int i=1;i<n;i++)
        {
            min = 0;
            for(int j=i-1;j>=0;j--)
                if(arr[i]>arr[j] && min < lis[j])
                    min = lis[j];
            lis[i] = min+1;
        }
        min = 1;
        for(int i=1;i<n;i++)
            if(min < lis[i])
                min = lis[i];
        System.out.println(min);
    }
}
