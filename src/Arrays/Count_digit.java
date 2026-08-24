package Arrays;

import java.util.Scanner;

public class Count_digit {

    // Method to count digits
    static int countDigits(int n) {
        int count = 0;

        while (n > 0) {
            n = n / 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Number of digits = " + countDigits(num));

        sc.close();
    }
}