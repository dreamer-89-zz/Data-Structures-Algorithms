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
class KMP {

    /**
     * @param args the command line arguments
     */
    public static int[] build_failure_function(String pattern)
    {
        int f[] = new int[pattern.length()+1];
        f[0]=f[1]=0;
        int j;
        for(int i=2;i<pattern.length();i++)
        {
            j = f[i-1];
            while(true)
            {
                if(pattern.charAt(i-1)==pattern.charAt(j))
                {
                    f[i]=j+1;
                    break;
                }
                else if(j>0)
                j = f[j];
                else break;    
            }
        }
        return f;
    }
    public static int sum(int f[])
    {
        int sum=0;
            for(int i=0;i<f.length;i++)
                sum+= f[i];
        return sum;
    }
    public static void kmp(String text,String pattern)
    {
        int failure[] = build_failure_function(pattern);
        int i,j=0;
        for(i=0;i<text.length();)
        {
            if(pattern.charAt(j)==text.charAt(i))
            {
                j++;// 
                i++;
                if(j==pattern.length())
                {
                    System.out.println("Pattern found at index "+i);
                    j=0;
                }
            }
            else if(j>0)
                j = failure[j];
            else i++;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String input;
        StringBuffer sb = new StringBuffer();
        int f[];
        for(int i=0;i<t;i++)
            {
            input = s.next();
            sb.append(input);
            sb = sb.reverse();
            f = build_failure_function(sb.toString());
            System.out.println(sum(f));
        //kmp("ABABDABACDABABACABAB","ABABAC");
    }    
}
}
