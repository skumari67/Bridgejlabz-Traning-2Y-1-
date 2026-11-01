package Recursion;

public class Reverse_String {
    public String reverseString(String s,int index){
        if(index==s.length()){
            return "";
        }

        return reverseString(s,index+1)+s.charAt(index);
    }
    public static void main(String[] args) {
        Reverse_String r = new Reverse_String();
        System.out.println(r.reverseString("hello", 0));
    }
}
