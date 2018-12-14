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
public class CyclicComponents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int choice;
//        UnionFind uf = new UnionFind(N);
//               do{
//        System.out.println("Enter the numbers which you want connected");
//        int i = s.nextInt();
//        int j = s.nextInt();
//        if(!uf.Connected(i, j))
//            uf.Union(i, j);
//        System.out.println("\nDo you want to continue (Non zero to continue) ");
//        choice = s.nextInt();
//        }while(choice !=0);
//        uf.ListConnectedComponents();
//        
        
        
         UnionQuick uq = new UnionQuick(N);
        do{
        System.out.println("Enter the numbers which you want connected");
        int i = s.nextInt();
        int j = s.nextInt();
        if(!uq.Connected(i, j))
            uq.Union(i, j);
        System.out.println("\nDo you want to continue (Non zero to continue) ");
        choice = s.nextInt();
        }while(choice !=0);
        uq.ListConnectedComponents();
        
//        WeightedQuickUnion uq = new WeightedQuickUnion(N);
//        do{
//        System.out.println("Enter the numbers which you want connected");
//        int i = s.nextInt();
//        int j = s.nextInt();
//        if(!uq.Connected(i, j))
//            uq.Union(i, j);
//        System.out.println("\nDo you want to continue (Non zero to continue) ");
//        choice = s.nextInt();
//        }while(choice !=0);
//        uq.ListConnectedComponents();
    }
}
    

