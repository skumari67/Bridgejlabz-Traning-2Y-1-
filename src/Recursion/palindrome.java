package Recursion;

public class palindrome {
    public boolean ispalindrome(String s ,int start,int end){
        if (start>=end) {

            return true;
        }
        if(s.charAt(start)!=s.charAt(end)){
            return false;
        }
        return ispalindrome(s,start+1,end-1);
    }
    public static void main(String[] args) {
        palindrome p = new palindrome();
        System.out.print(p.ispalindrome("madam",0,4));
    }
}
