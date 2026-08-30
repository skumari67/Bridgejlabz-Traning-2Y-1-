package String;
import java.util.*;
public class palindrome {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String result = new StringBuilder().reverse().toString();
   if(result.equals(str)){
        System.out.println(str +"is palindrome");

    }
   else{
        System.out.println(str +"is not palindrome");
    }
}
}

