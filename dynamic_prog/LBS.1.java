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
class LBS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int array[] = new int[n];
        for(int i =0;i<n;i++)
            array[i] = s.nextInt();
        int increasing[] = new int[n];
        int decreasing[] = new int[n];
        int max;
        Arrays.fill(increasing, 1);
        Arrays.fill(decreasing, 1);
        for(int i =1;i<n;i++)
        {
            max = -1;
            for(int j=i-1;j>=0;j--)
            {
                if(array[i] > array[j] && increasing[j]>max)
                    max =increasing[j];
            }
            increasing[i] = max==-1?1:max+1;
        }
        for(int i =n-2;i>=0;i--)
        {
            max = -1;
            for(int j=i+1;j<n;j++)
            {
                if(array[i] > array[j] && decreasing[j]>max)
                    max =decreasing[j];
            }
            decreasing[i] = max==-1?1:max+1;
        }
        max = decreasing[0];
        for(int i=0;i<n-1;i++)
        {
            if(max < increasing[i]+decreasing[i+1])
                max = increasing[i]+decreasing[i+1];
        }
        if(max < increasing[n-1])
            max = increasing[n-1];
        System.out.println(max);
    }
}
