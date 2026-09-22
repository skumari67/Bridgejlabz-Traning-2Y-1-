package LeetCode;
import java.util.*;
public class Third_Max_Element_414 {
    public static void main(String[]args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("arrays size");
        int size = sc.nextInt();
        int [] arr = new int [size];
        System.out.println("eneter array elements");
        for(int i =0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("arrays elements are :");
        for(int i =0;i<size;i++){
            System.out.print(arr[i]+" ");
        }

        Arrays.sort(arr);
        int count =1;
        int max = arr[arr.length-1];
        for(int i =arr.length-2;i>=0;i--){
            if(arr[i]!=max){
                count++;
                max=arr[i];
            }
            if(count==3){
                System.out.println("third largest element is "+max);
                return;
            }
        }
        System.out.println(arr[arr.length-1]);

        }
    }