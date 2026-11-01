package Recursion;

public class length_String {

        public int findLength(String s, int index,int end) {

            // Base case
            if (index == end) {
                return 0;
            }

            return 1+findLength(s, index+1, end);
            }



        public static void main(String[] args) {
            length_String obj = new length_String();
            System.out.println(obj.findLength("hello", 0,5));
        }
    }

