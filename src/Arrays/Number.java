package Arrays;
import java.util.Scanner;
public class Number {
        public static void main(String[]args){
            Scanner sc = new Scanner(System.in);
            int size = 5;
            int [] arr = new int[size];
            for(int i =0;i<size;i++){
                arr[i]=sc.nextInt();
            }
            for(int i =0;i<size;i++){
                if(arr[i]>0){
                    if(arr[i]%2==0){
                        System.out.println(arr[i]+" =is positive and  even number");

                    }
                    else{
                        System.out.println(arr[i]+" =is positive and odd number");
                    }

                }
                else if(arr[i]<0){
                    System.out.println(arr[i]+" =negative number");
                }
                else {
                    System.out.println(arr[i]+" =is zero");
                }
            }
            if(arr[0]==arr[size-1]){
                System.out.println("=first and last elements are equal");
            }
            else if(arr[0]>arr[size-1]){
                System.out.println("first element is less than last element");
            }
        }

    }


