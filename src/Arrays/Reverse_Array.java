package Arrays;

import java.util.Scanner;

public class Reverse_Array {

    // Method to reverse the array
    static void reverseArray(int arr[], int n) {

        int start = 0;
        int end = n - 1;

        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Method to print the array
    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        reverseArray(arr, n);

        System.out.println("Reversed Array:");
        printArray(arr, n);

        sc.close();
    }
}
    

