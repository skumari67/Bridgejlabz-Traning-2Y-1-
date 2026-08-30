package Arrays;
import java.util.Scanner;
public class Store_Numbers {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            double[] numbers = new double[10];
            double total = 0.0;
            int index = 0;

            while (true) {

                System.out.print("Enter a number: ");
                double number = sc.nextDouble();

                // Stop if number is 0 or negative
                if (number <= 0) {
                    break;
                }

                // Stop if array is full
                if (index == 10) {
                    break;
                }

                numbers[index] = number;
                index++;
            }

            System.out.println("Numbers entered:");

            for (int i = 0; i < index; i++) {
                System.out.println(numbers[i]);
                total = total + numbers[i];
            }

            System.out.println("Sum = " + total);
        }
    }

