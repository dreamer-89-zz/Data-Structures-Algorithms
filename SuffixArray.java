/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.ds;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class tuple implements Comparable
    {
    int firstIndex;
    int secondIndex;
    int originalIndex;
    @Override
    public int compareTo(Object t1)
        {
        tuple first = this;
        tuple second = (tuple)t1;
        if(first.firstIndex>second.firstIndex)return 1;
        else if(first.firstIndex == second.firstIndex && first.secondIndex >= second.secondIndex)return 1;
            else
            return -1;
    }
}
public class SuffixArray {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int test = s.nextInt();
        String input;
        tuple t[];
        int suffixRank[][];
        int len;
        for(int i=0;i<test;i++)
            {
            input = s.next();
            len = input.length();
            t = new tuple[len];
            suffixRank = new int[20][len];
            for(int j=0;j<len;j++)
                suffixRank[0][j] = input.charAt(j)-'a';
            for(int steps=1,count=1;count<len;steps++,count*=2)
                {
                for(int k=0;k<len;k++)
                    {
                    if(t[k]==null)
                        t[k] = new tuple();
                    t[k].firstIndex = suffixRank[steps-1][k];
                    t[k].secondIndex = k+count<len ? suffixRank[steps-1][k+count]:-1;
                    t[k].originalIndex = k;
                }
                Arrays.sort(t);
                suffixRank[steps][t[0].originalIndex]=0;
                for(int k = 1,rank=0;k<len;k++)
                    {
                    if(t[k-1].firstIndex!=t[k].firstIndex || t[k-1].secondIndex!=t[k].secondIndex)
                        rank++;
                    suffixRank[steps][t[k].originalIndex] = rank;
                }
                for(int k=0;k<len;k++)
                    System.out.print(suffixRank[steps][k]+" ");
                System.out.println();
            }
            for(int k=0;k<len;k++)
                System.out.println(t[k].originalIndex);
        }
    }
}