package Arrays;

import java.util.Scanner;

public class SumofnNumber{

    // Method to calculate sum
    static int sumOfN(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Sum = " + sumOfN(n));

        sc.close();
    }
}