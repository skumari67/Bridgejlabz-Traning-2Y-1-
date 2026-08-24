package Arrays;

public class Plaindrome {
    public static boolean isPalindrome(int num) {

        int original = num;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }

        return original == reverse;
    }

    public static void main(String[] args) {

        int n = 121;

        if (isPalindrome(n)) {
            System.out.println("Palindrome Number");
        } else {
            System.out.println("Not a Palindrome Number");
        }
    }
}


    

