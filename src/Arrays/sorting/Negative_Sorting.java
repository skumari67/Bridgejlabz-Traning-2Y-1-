package Arrays.sorting;
import java.util.*;
public class Negative_Sorting {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc .nextInt();
        int arr []=new int[size];
        for(int i =0;i<arr.length;i++){
            arr[i]= sc.nextInt();
        }
            for(int i=0;i<arr.length;i++){
                for(int j =0;j<arr.length-i-1;j++){
                    if(arr[j]<arr[j+1]){
                        int temp = arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }
            }
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
        }

    }

