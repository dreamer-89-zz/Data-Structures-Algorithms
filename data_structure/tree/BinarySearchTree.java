/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Suraj Singh
 */
class BinarySearchTree
{
    int value;
    int size;
    BinarySearchTree left;
    BinarySearchTree rigth;
    static BinarySearchTree root;
    BinarySearchTree(int v)
    {
        value = v;
    }
    public static void Insert(int key)
    {
        root = Insert(root,key);
    }
    private static BinarySearchTree Insert(BinarySearchTree b, int key)
    {
        if(b==null)
            return new BinarySearchTree(key);
        if(key<b.value)
            b.left = Insert(b.left,key);
        else if(key>b.value)
            b.rigth = Insert(b.rigth,key);
        else b.value = key;
        return b;
    }
    private static boolean Search(BinarySearchTree root,int key)
    {
        if(root==null)return false;
        if(root.value < key)return Search(root.rigth,key);
        else if(root.value>key)return Search(root.left,key);
        else
            return true;
    }
    public static void InorderTraversal(BinarySearchTree root)
    {
        if(root == null)
            return;
        InorderTraversal(root.left);
        System.out.print(root.value+" ");//+","+root.size+"  ");
        InorderTraversal(root.rigth);
    }
    public static void PreOrderTraversal(BinarySearchTree root)
    {
        if(root==null)return;
        System.out.print(root.value+" ");
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.rigth);
    }
    public  static int Size(BinarySearchTree node)
    {
        if(node==null)
            return 0;
        node.size = 1+ Size(node.left)+Size(node.rigth);
        return node.size;
    }
    public static int Rank(BinarySearchTree x,int key)
    {
        int r=0;
        if(x==null)
            return 0;
        if(key==x.value)
            r= Size(x.left);
        else if(key>x.value)
            r = 1+Size(x.left)+Rank(x.rigth,key);
        else if(key<x.value)
            r = Rank(x.left,key);
        return r;
    }
    public static BinarySearchTree Min(BinarySearchTree x)
    {
        if(x.left==null)
            return x;
        else
            return Min(x.left);
    }
    public static BinarySearchTree DeleteMin(BinarySearchTree x)
    {
        if(x.left==null)return x.rigth;
        x.left = DeleteMin(x.left);
        x.size = Size(x.left)+Size(x.rigth)+1;
        return x;
    }
    public static BinarySearchTree Delete(BinarySearchTree x,int key)
    {
        if(x==null)
            return null;
        if(x.value==key){
                if(x.left==null && x.rigth==null)
                    return null;
                else if(x.left==null)
                    return x.rigth;
                else if(x.rigth==null)
                    return x.left;
                else 
                {
                    BinarySearchTree suc = Min(x.rigth);
                    x.value = suc.value;
                    x.rigth = DeleteMin(x.rigth);
                   // suc.left = x.left;
                }
        }
        else if(x.value > key)
            x.left = Delete(x.left,key);
        else
            x.rigth = Delete(x.rigth,key);
        x.size = Size(x.left)+Size(x.rigth)+1;
        return x;
    }
    public static void main(String ags[]) throws IOException
    {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        avl aroot=null;
        String str[] = s.readLine().split(" ");
        int values[] = new int[str.length];
        for(int i=0;i<str.length;i++)
        {
            values[i] = Integer.parseInt(str[i]);
            System.out.print(values[i]+" ");
            Insert(values[i]);
            aroot = avl.Insert(aroot, values[i]);
        } 
//        System.out.println("Rank of elements : ");
//        for(int i=0;i<str.length;i++)
//        {
//            System.out.println(values[i]+" "+(1+Rank(root,values[i]))+" ");
//        }
//          Size(root);
//          InorderTraversal(root);
//          for(int i=0;i<str.length;i++)
//          {
//              System.out.println(values[i]+" "+Search(root,values[i]));
//          }
              
        //System.out.println(root.Rank(root, 15));
//        root = Delete(root, 3);
//        System.out.println();
//        InorderTraversal(root);   
//        aroot = avl.delete(aroot,8);
//        root = Delete(root, 8);
//        System.out.println("\nAfter deleting 8 in BST");
//        InorderTraversal(root);
//        System.out.println("\nAfter deleting 8 in AVL");
//        avl.InorderTraversal(aroot);
//        Size(root);
        root = Delete(root,10);  
        aroot = avl.delete(aroot,10);
        System.out.println("\nAfter deleting 10 in BST ");      
        PreOrderTraversal(root);
        System.out.println("\nAfter deleting 10 in AVL ");      
        avl.PreOrderTraversal(aroot);
//        Size(root);
//        root = root.Delete(root,10);        
//        InorderTraversal(root);
        System.out.println();
    }
}
