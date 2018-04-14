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
class avl
{
    int data;
    int size,height;
    avl left,right;
    avl(int d)
    {
        data = d;
        size = 1;
        height = 1;
    }
    public static int size(avl root)
    {
        if(root==null)return 0;
        return (root.left!=null?root.left.size:0)+(root.right!=null?root.right.size:0)+1;
    }
    public static int height(avl root)
    {
        if(root==null)return 0;
        return root.height;
    }
    public static avl RightRotate(avl root)
    {
        avl x = root.left;
        root.size = size(root.right)+size(x.right)+1;
        root.height = Math.max(height(root.right),height(x.right))+1;  
        x.size = size(x.left)+size(root)+1;
        x.height = Math.max(height(x.left), height(root)+1)+1;
        root.left = x.right;
        x.right = root;
        return x;
    }
    public static avl LeftRotate(avl root)
    {
        avl y = root.right;
        root.size = size(root.left)+size(y.left)+1;
        root.height = 1+ Math.max(height(root.left), height(y.left));
        y.size = size(y.right)+size(root)+1;
        y.height =1+ Math.max(height(root), height(y.right));      
        root.right = y.left;
        y.left = root;
        return y;
    }
    public static void InorderTraversal(avl root)
    {
        if(root==null)return;
        InorderTraversal(root.left);
        System.out.print(root.data+" ");
        InorderTraversal(root.right);
    }
    public static void PreOrderTraversal(avl root)
    {
        if(root==null)return;
        System.out.print(root.data+" ");
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }
    public static avl Insert(avl root, int data)
    {
        int balancefactor;
        if(root==null)return new avl(data);
        if(root.data > data)
            root.left = Insert(root.left,data);
        else if(root.data < data)
            root.right = Insert(root.right,data);
        else
            root.data = data;
        balancefactor = height(root.left)-height(root.right);
        if(balancefactor > 1 && data > root.left.data)  // check for the left right case
            root.left = LeftRotate(root.left); // first rotate left the left child
        if(balancefactor > 1)
            root = RightRotate(root);
        if(balancefactor < -1 && data < root.right.data)
            root.right = RightRotate(root.right);
        if(balancefactor < -1)
            root = LeftRotate(root);
        root.size = size(root.left)+size(root.right)+1;
        root.height = Math.max(height(root.left), height(root.right))+1;
        return root;
    }
    public static int getBalanceFactor(avl root)
    {
        if(root==null)return 0;
        return height(root.left)-height(root.right);
    }
    public static avl DeleteMin(avl root)
    {
        if(root.left==null){
            return null;
        }
        root.left = DeleteMin(root.left);
        root.size = size(root.left)+size(root.right)+1;
        root.height = Math.max(height(root.left),height(root.right))+1;
        return root;
    }
    public static avl findMin(avl root)
    {
        if(root.left==null)return root;
        return findMin(root.left);
    }
    public static avl delete(avl root,int key)
    {
        if(root==null)return null;
        if(root.data > key)
            root.left = delete(root.left,key);
        else if(root.data < key)
            root.right = delete(root.right,key);
        else // key found at root
        {
            if(root.left==null)return root.right;
            if(root.right==null)return root.left;
            avl suc = findMin(root.right);
            root.data = suc.data;
            root.right = DeleteMin(root.right);
        }
        root.size = size(root.left)+size(root.right)+1;
        root.height = Math.max(height(root.left), height(root.right))+1;
        int balancefactor = getBalanceFactor(root);
        if(balancefactor>1 && getBalanceFactor(root.left)<0)
            root.left = LeftRotate(root.left);
        if(balancefactor>1)
            root = RightRotate(root);
        if(balancefactor<-1 && getBalanceFactor(root.right)>0)
            root.right = RightRotate(root.right);
        if(balancefactor<-1)
            root = LeftRotate(root);
        return root;
    }
}
class AVL_TREE {
    static avl root;
    public static void main(String... orange)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0;i<n;i++)
        {
            root = avl.Insert(root, s.nextInt());
        }
        avl.InorderTraversal(root);
    }
}
