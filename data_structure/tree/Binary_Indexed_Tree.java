/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.ds;

import java.util.Scanner;

/**
 *
 * @author Suraj Singh
 */
class Binary_Indexed_Tree {
    static int fenwick[];
    public static void create_bit(int a[],int n)
    {        
        fenwick = new int[n+1];
        int value;
        for(int i=1,j=1;i<=n;i++)
        {
            j = i;
            while(j<=n)
            {
                fenwick[j]+= a[i-1];
                j = j + ( j & (-j));
            }
        }
    }
    public static void update(int index, int value)
    {
        index++; 
        while(index < fenwick.length)
        {
            fenwick[index]+= value;
            index = index + (index &(-index));
        }                
    }
    public static int query(int index)
    {
        int sum=0;
        while(index>0)
        {
            sum+= fenwick[index];
            index = index- (index&(-index));
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        fenwick= new int[n];
        for(int i=0;i<n;i++)
            a[i] = s.nextInt();
        create_bit(a,n);
        System.out.println(query(5)+"\n"+query(6));
        update(3,9-a[3]);
        update(4,6-a[4]);
        System.out.println(query(5)+"\n"+query(6));
        for(int i=0;i<=n;i++)
            System.out.print(fenwick[i]+" ");
    }
}
