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
class LIS_nlogN {
    public static int findIndex(int a[],int l, int r, int key)
    {
        int m=-1;
        while(l<=r)
        {
            m =(l+r)/2;
            // search right
            if(key > a[m])
                l = m+1;
            else if(key < a[m])
                r = m-1;
            else
                break;
        }
        return l;
    }
    public static int lis(int a[])
    {        
        int temp[] = new int[a.length];
        int index=1,p;
        temp[0] = a[0];
        for(int i=1;i<a.length;i++)
        {
            // Case 1 : a[i] is largest among all the elements.
            if(a[i]>temp[index-1])
                temp[index++] = a[i];
            // Case 2: a[i] is smallest of all.
            else if(a[i]<temp[0])
                temp[0] = a[i];
            // Case 3 : a[i] is an intermediate element in the sorted list...
            else
            {
                p = findIndex(temp,0,index,a[i]);
                temp[p] = a[i];
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = s.nextInt();
        System.out.println(lis(arr));
    }
}
