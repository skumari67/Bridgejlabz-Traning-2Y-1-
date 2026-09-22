package Arrays;
import java.util.*;
public class Arrays_Traversal {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int sum =0;
    System.out.println("enter the size of the array :");
        int size= sc.nextInt();
        int [] arr = new int[size];
        System.out.println("enter the elements of the array :");
        for(int i =0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Arrays elements are :");
        for(int i=0;i<size;i++){
            System.out.println(arr[i]+" ");
        }
        for(int i=0;i<size;i++){
        sum = sum+arr[i];
        }
        System.out.println("sum of the elements is :"+sum);
        int max =arr[0];
        int min =arr[0];
        for(int i=0;i<size;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }

        }
        System.out.println("max of the elements is :"+max);
        System.out.println("min of the elements is :"+min);

}
}
