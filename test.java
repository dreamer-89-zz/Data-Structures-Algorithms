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
import java.io.*;
import java.util.*;

class unionpath
    {
    int parent,rank;
    unionpath(int v,int r)
        {
        parent = v;
        rank = r;
    }
}
public class test {
    static unionpath objects[];
    public static int root(int i) //using path compression
        {
//        while(objects[i].parent!=i)
//            objects[i].parent = root(objects[i].parent);
        while(i!=objects[i].parent)
            i = objects[i].parent;
        return i;
    }
    public static void union(int x,int y)
    {
        int px = root(x);
        int py = root(y);
        if(px!=py)
        {            
            if(objects[px].rank> objects[py].rank)
              {
                objects[py].parent = px;
                objects[px].rank+= objects[py].rank;
            }
            else if(objects[px].rank < objects[py].rank)
               {
                objects[px].parent = py;
                objects[py].rank+= objects[px].rank;
            }
            else
            {
                objects[px].parent = py;
                objects[py].rank++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int l = s.nextInt();
        int x,y;
        long ans=0;
        List<Integer> list = new ArrayList();
        objects = new unionpath[n];
        for(int i=0;i<n;i++)
            {
            objects[i] = new unionpath(i,1);
        }
        for(int i=0;i<l;i++)
            {
            x = s.nextInt();
            y = s.nextInt();
            union(x,y);
        }
        for(int i=0;i<n;i++)
            {
            if(objects[i].parent==i)
                {
                list.add(objects[i].rank);
            }
        }
         for(int i=0;i<list.size();i++)
            System.out.print(list.get(i)+" ");
        System.out.println();
        long a[] = new long[list.size()];
        a[0] = list.get(0);
        for(int i=1;i<list.size();i++)
            a[i]+= a[i-1]+list.get(i);
        for(int i=1;i<list.size();i++)
            ans+= list.get(i)*a[i-1];
        System.out.println(ans);
    }
}