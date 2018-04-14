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
public class UnionFind {
    int objects[];
    public UnionFind(int n)
    {
        objects = new int[n];
        for(int i =0;i<n;i++)
            objects[i] = i;
        System.out.println("List of elements ");
        for(int i =0;i<n;i++)
            System.out.print(" "+objects[i]);
    }
    public boolean Connected(int i , int j)
    {
        if(objects[i] == objects[j])
        {
            System.out.println("Connected");
            return true;
        }
        else 
        return false; 
    }
    
    public void Union(int i , int j)
    {
        int value = objects[i];
        for(int k = 0 ;k < objects.length;k++)
            if(objects[k]==value)
                objects[k]= objects[j];
        
        System.out.println("List of elements ");
        for(int l =0;l<objects.length;l++)
            System.out.print(" "+objects[l]);
    }
    public void ListConnectedComponents()
    {
        int count =1;
        System.out.println("List of connected components");
        for(int a =0;a<objects.length;a++)
        {  
           while(a < objects.length && objects[a]==99)
               a++;
           System.out.print(count+ " connected component \n {" + a);
           
           for(int b = a+1;b<objects.length;b++)
           {
               if(objects[b]==objects[a])
               {
                   System.out.print(", "+b);
                   objects[b]=99;
               }
           } 
           System.out.println("}");
           count++;
    }
}
}
