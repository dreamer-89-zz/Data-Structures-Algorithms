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
class Rabin_Karp {

    /**
     * @param args the command line arguments
     */
    public static void rk(String text,String pattern)
    {
        int phash=0,thash=0,mod= (int) (Math.pow(10, 9)+7),base=10,m = pattern.length(),temp=0;
        int pow = (int)Math.pow(base, m-1);
        for(int i=0;i<pattern.length();i++)
        {
            phash = (pattern.charAt(i)+ phash*base)%mod;
            thash = (text.charAt(i)+ thash*base)%mod;
            temp = (temp*base+ text.charAt(i))%mod;
            //System.out.print(text.charAt(i));
        }
        if(phash==thash)
                System.out.println("Pattern found at index : "+1);
        for(int i=pattern.length();i<text.length();i++)
        {
            System.out.print(text.charAt(i));
            thash = (thash - (text.charAt(i-m)*pow)%mod)%mod;
            thash =  (thash*base)%mod;
            thash =  (thash + text.charAt(i))%mod;
            if(thash<0)
                thash+=mod;
            if(phash==thash)
                System.out.println("\nPattern found at index : "+(i-m+1));
        }
    }
    public static void main(String[] args) {
        rk("GEEKS FOR GEEKS","GEEK");
    }
    
}
