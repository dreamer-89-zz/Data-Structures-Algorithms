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
class LLRBT
{
    int value;
    LLRBT left;
    LLRBT right;
    boolean color;
    LLRBT(int value)
    {
        this.value = value;
        this.color = true;//true for Red Link
    }
    public LLRBT InsertNewNode(LLRBT root,int value)
    {
       if(root==null)
       {
           root = new LLRBT(value);
           return root;
       }
       if(root.value>value)
       {
           root.left = InsertNewNode(root.left,value);
       }
       else if(root.value<value)
       {
           root.right = InsertNewNode(root.right,value);
       }       
       if(( (root.left!=null && root.left.color==false)|| root.left==null) && root.right!=null &&  root.right.color == true)
           root = RotateRight(root);
       if(root.left!=null && root.left.left!=null && root.left.color==true && root.left.left.color==true)
           root = RotateLeft(root);
       if(root.right!=null && root.left!=null && root.left.color==true && root.right.color==true)
           root = FlipColor(root);
       return root;
    }
    public LLRBT FlipColor(LLRBT root)
    {
        root.left.color = false;
        root.right.color = false;
        root.color = true;
        return root;
    }
    public LLRBT RotateLeft(LLRBT root)
    {
    boolean clr = root.color;
    LLRBT leftChild=root.left;
    if(leftChild.right!=null)
    {
        root.left = leftChild.right;
        leftChild.right = root;        
    }
    else
    {
        leftChild.right = root;
        root.left = null;
    }
    root.color = root.left.color ;
    root.left.color = clr;
    return root.left;
    }
    
    public LLRBT RotateRight(LLRBT root)
    {
    boolean clr = root.color;
    LLRBT rightChild = root.right;
    if(rightChild.left!=null)
    {
        root.right = rightChild.left;        
        rightChild.left = root;
    }
    else       
    {
        rightChild.left = root;
        root.right = null;
    }    
    root.color = rightChild.color;
    rightChild.color = clr;
    return rightChild;
    }
    public LLRBT DeleteMin(LLRBT root)
    {
        if(root.left==null)return null;
        if(root.left.left!=null)
            root.left = DeleteMin(root.left);
        else
            root.left = null;
        return root;
    }
//    public LLRBT DeleteKey(LLRBT root, int value)
//    {
//        if(root==null)return null;
//        if(root.value < value)
//            root.right = DeleteKey(root.right,value);
//        else if(root.value > value)
//            root.left = DeleteKey(root.left,value);
//        else
//    }
    public LLRBT FindRank(LLRBT root,int value)
    {
        if(root==null)
       {
           root = new LLRBT(value);
       }
       if(root.value>value)
       {
           root = InsertNewNode(root.left,value);
       }
       else if(root.value<value)
       {
           root = InsertNewNode(root.right,value);
       }
       return root;
    }
//    public void LOT(LLRBT root)//Level Order Traversal
//    {
//        if(root==null)
//            return;
//        System.out.println(root.value);
//        ///Queue q = new QueueList();
//        LOT(root.left);
//        LOT(root.right);
//    }
}
class RedBlackTree {
    static LLRBT mainroot;
public static void main(String args[]) throws IOException
{
    BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
    int choice,nodeValue;
    System.out.println("Please enter your choice!");
    System.out.println("1. Enter a new node\n2.Rank of a node");
    choice = Integer.parseInt(s.readLine());
    do
    {        
        switch(choice)
        {
            case 1: System.out.println("Enter the node value");
                    nodeValue = Integer.parseInt(s.readLine());
                    if(mainroot==null)
                        mainroot = new LLRBT(nodeValue);
                    else
                    mainroot =  mainroot.InsertNewNode(mainroot, nodeValue);
                    mainroot.color = false;
            break;
            case 2 : System.out.println("Enter the node value");
                    nodeValue = Integer.parseInt(s.readLine());
                    mainroot = mainroot.FindRank(mainroot,nodeValue);
                break;
        }
        System.out.print("Enter 0 to break ");
        choice = Integer.parseInt(s.readLine());
    }while(choice!=0);
  }
}
