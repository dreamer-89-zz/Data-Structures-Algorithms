/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.ds;

/**
 *
 * @author Suraj Singh
 */
public class UnionQuick {
    int objects[];
    public UnionQuick(int n)
    {
        objects = new int[n];
        for(int i =0;i<n;i++)
            objects[i] = i;
        
    }
    private int root(int i)
    {
        while(i!= objects[i])
            i = objects[i];
        return i;
    }
    
    public boolean Connected(int i, int j)
    {
        if(this.root(i)== this.root(j))
            return true;
        else 
            return false;
    }
    
    public void Union(int i, int j)
    {
        int p, q;
        p = this.root(i);
        q = this.root(j);
        objects[q] = p;
        for(int k = 0;k <objects.length; k++)
       {
           System.out.print(objects[k]+" ");
       }
     }
    public void ListConnectedComponents()
    {
        int count = 1;
        int flag[] = new int[10];
       for(int i = 0;i <objects.length; i++)
       {
           while(i < objects.length && flag[i]==99)
           { 
                 i++;
                 if( i >= objects.length)
                     return;
           }
           System.out.print(count+ " connected component {" + i);
           for(int j = i+1; j< objects.length;j++)
           { 
              if(this.Connected(i, j))
               {
                   System.out.print(", "+j);
                   flag[j]=99;
               }
              }
           System.out.println("}");
           count++;
           }
           
       }
    }
 
