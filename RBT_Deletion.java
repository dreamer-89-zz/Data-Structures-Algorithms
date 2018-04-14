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
class rbt
{
    rbt left,right;
    char data;
    boolean color;
    public static final boolean RED = true;
    rbt(char d)
    {
        data = d;
        color = RED;
    }
    public static boolean isRed(rbt root)
    {
        if(root==null || root.color!=RED)
            return false;
        return true;
    }
    public static rbt flipcolor(rbt root)
    {
        assert !isRed(root);
        assert isRed(root.left);
        assert isRed(root.right);
        root.left.color = !RED;
        root.right.color = !RED;
        root.color = RED;
        return root;
    }
    public static rbt rotateRight(rbt root)
    {
        rbt lchild = root.left;
        root.left = lchild.right;
        lchild.right = root;
        lchild.color = root.color;
        root.color = RED;
        return lchild;
    }
    public static rbt rotateLeft(rbt root)
    {
        rbt rchild = root.right;
        root.right = rchild.left;
        rchild.left = root;
        rchild.color = root.color;
        root.color = RED;
        return rchild;
    }
    public static rbt Insert(rbt root, char v)
    {
        if(root==null)return new rbt(v);
        if(root.data > v)
            root.left = Insert(root.left,v);
        else if(root.data < v)
            root.right = Insert(root.right,v);
        if(!isRed(root.left) && isRed(root.right))
            root = rotateLeft(root);
        if(isRed(root.left) && isRed(root.left.left))
            root = rotateRight(root);
        if(isRed(root.left) && isRed(root.right))
            root = flipcolor(root);
        return root;
    }
    public boolean search(rbt root,int d)
    {
        if(root==null)return false;
        if(root.data > d)
            return search(root.left,d);
        else if(root.data < d)
            return search(root.right,d);
        else
            return true;
    }
    public rbt delete(rbt root, char ch)
    {
        if(!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        if(root.data > ch)
        {
            if(!isRed(root.left) && !isRed(root.left.left))
                root = moveRedLeft(root);
            root.left = delete(root.left,ch);
        }
        else
        {
            if(isRed(root.left))
                root=rotateRight(root);
            if(root.right==null)
                return null;
            if(!isRed(root.right) && !isRed(root.right.left))
                root = moveRedRight(root);
            if(root.data == ch)
            {
                rbt x = min(root.right);
                root.right = deleteMin(root.right);
            }
            else
                root.right = delete(root.right,ch);
        }
        return balance(root);
    }
    private rbt moveRedLeft(rbt root)
    {
        root = flip(root);
        if(isRed(root.right.left))
        {
            root.right = rotateRight(root.right);
            root = rotateLeft(root);
            root = flipcolor(root);
        }
        return root;
    }
    private rbt moveRedRight(rbt root)
    {
        root = flip(root);
        if(isRed(root.left.left))
        {
            root = rotateRight(root);
            root = flip(root);
        }
        return root;
    }
    private rbt balance(rbt root)
    {
        if(!isRed(root.left) && isRed(root.right))
            root = rotateLeft(root);
        if(isRed(root.left) && isRed(root.left.left))
            root = rotateRight(root);
        if(isRed(root.left) && isRed(root.right))
            root = flip(root);
        return root;
    }
    private rbt flip(rbt root)
    {
        root.color = !root.color;
        root.left.color = !root.left.color;
        root.right.color = !root.right.color;
        return root;
    }
    private rbt min(rbt root)
    {
        if(root==null)return root;
        else return min(root.left);
    }
    private rbt max(rbt root)
    {
        if(root==null)return root;
        else return max(root.right);
    }
    private rbt deleteMin(rbt root)
    {
        if(!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        if(root.left==null)
            return null;
        if(!isRed(root.left) && !isRed(root.left.left))
            root = moveRedLeft(root);
        root.left = deleteMin(root.left);
        return balance(root);
    }
}
public class RBT_Deletion {    
    public static void main(String[] args) {
        rbt root = null;
        char ch[] = {'R','P','X','S'};//{'S','E','A','R','C','H','X','M','P','L'};
        for(int i=0;i<ch.length;i++)
        {
            root = rbt.Insert(root,ch[i]);
            root.color = !rbt.RED;
        }
        root.delete(root, 'L');
    }
    
}
