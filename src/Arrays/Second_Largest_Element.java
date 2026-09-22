package Arrays;
import java.util.Scanner;
public class Second_Largest_Element {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of the array");
        int size=sc.nextInt();
        int [] arr = new int[size];
        System.out.println("enter the elements of the array");
        for(int i =0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int largest_number= arr[0];
        int second_largest_number= Integer.MAX_VALUE;
        for(int i =1;i<size;i++){
            if(arr[i]>largest_number){
                second_largest_number=largest_number;
                largest_number = arr[i];

            }
            else if(arr[i]>second_largest_number && arr[i]!=largest_number){
                second_largest_number = arr[i];;
            }
        }
        System.out.println("largest number: "+largest_number);
        System.out.println("second largest number: "+second_largest_number);

    }
}
