package Arrays;
import java.util.*;
public class Counting_And_Condition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count =0;
        System.out.println("Enter the size of the array :");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array :");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<size;i++){
                count++;
        }
        System.out.println("count of arrays elements : "+count);
        int evencount=0;
        int positivecount=0;
        int negativecount=0;
        for(int i=0;i<size;i++){
            if(arr[i]%2==0){
                evencount++;
            }
            if(arr[i]>0){
                positivecount++;
            }
            if(arr[i]<0){
                negativecount++;
            }
        }
            System.out.println("even number count of arrays elements : "+evencount);
        System.out.println("positive number count of arrays elements : "+positivecount);
        System.out.println("negative  number count of arrays elements :"+negativecount);
    }

}