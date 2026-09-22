package String;

public class StringBuilderDemo {
     static void main(String[] args) {
        StringBuilder str =new StringBuilder();
        str.append("sanjana");
        System.out.println("to add append method " +str);
        str.insert(5,'s');
        System.out.println(str);
        str.reverse();
        System.out.println(str);
        str.delete(0,1);
        System.out.println(str);
        str.deleteCharAt(6);
        System.out.println(str);
    }
}
