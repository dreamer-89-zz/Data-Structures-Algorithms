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
class TST
{
    TST left,right,straight;
    boolean isLeaf; // We can also store the value (int)  that can store the order of this particular string in the set of all keywords...
    char value;
    public TST insert(TST root, String key, int distance)
    {
        char cur = key.charAt(distance);
        if(root==null){
            root = new TST();
            root.value = cur;
        }
        if(root.value > cur)
            root.left = insert(root.left,key,distance);
        else if(root.value < cur)
            root.right = insert(root.right, key, distance);
        else if(distance < key.length()-1)
            root.straight = insert(root.straight,key,distance+1);
        else
            root.isLeaf = true; // this is the last character therefore mark it as a leaf.
        return root;
    }
    public boolean Search(TST root, String key, int distance)
    {
        if(root==null)return false;
        if(distance==key.length())return root.isLeaf;
        if(root.value > key.charAt(distance))
            return Search(root.left,key,distance);
        else if(root.value < key.charAt(distance))
            return Search (root.right,key,distance);
        else if(distance < key.length()-1)
            return Search(root.straight,key,distance+1); // continue to search in the same direction.
        else
            return root.isLeaf; // This is the last node. Check whether it is leaf or not.
    }
    public TST Delete(TST root, String key, int distance)
    {
        if(root==null)return null;
        char c = key.charAt(distance);
        if(root.value > c)
            root.left = Delete(root.left,key,distance);
        else if(root.value <c)
            root.right = Delete(root.right,key,distance);
        else if(distance< key.length()-1)
            root.straight = Delete(root.straight, key,distance);
        else
            root.isLeaf = false; // remove this node as a leaf from the tree
        if(root.left==null && root.right==null && root.straight==null) // This is done to remove the redundant nodes.
            return null;
        return root;
    }
}
class Ternary_Search_Trie {
    public static void main(String ... or)
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String word;
        TST root = new TST();
        for(int i=0;i<n;i++)
        {
            word = s.next();
            root = root.insert(root,word,0);
        }
        System.out.println("Give 3 search keywords !!!");
        System.out.println(root.Search(root, s.next(), 0));
        System.out.println(root.Search(root, s.next(), 0));
        System.out.println(root.Search(root, s.next(), 0));
        System.out.println("Give 2 delete keywords !!!");
        root = root.Delete(root, s.next(), 0);
        root = root.Delete(root, s.next(), 0);
        System.out.println("Search again after deletion !!!");
        System.out.println(root.Search(root, s.next(), 0));
        System.out.println(root.Search(root, s.next(), 0));
    }
}
