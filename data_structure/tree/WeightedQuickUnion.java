
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
public class WeightedQuickUnion {
        int objects[]; // objects array will store the parent objects[element] will give the parent.
        int size[]; // will give the number of elements under current element.
    public WeightedQuickUnion(int n)
    {
        objects = new int[n];
        size = new int[n];
        for(int i =0;i<n;i++)
        {
            objects[i] = i;
            size[i] =1;
         }
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
        if(this.size[p] >= this.size[q])
        { 
            objects[q] = p;
            this.size[p] =+ this.size[q];
        }
        else
        {
            objects[p] = q;
            this.size[q] = + this.size[p];
        }
                
       // objects[q] = p;
     }
    public void ListConnectedComponents()
    {
         for(int i = 0;i <objects.length; i++)
             System.out.print(" "+objects[i]+ " Size : "+ size[i]);
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
           System.out.print(count+ " connected component \n {" + i);
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
