package Arrays;
import java.util.Scanner;
public class Age_Student {
        public static void main(String[]args){
            Scanner sc = new Scanner(System.in);
            System.out.print("enter number of student:");
            int size = sc.nextInt();

            int [] arr = new int[size];
            System.out.print("enter ages of student:");
            for(int i=0;i<size;i++){
                arr[i]= sc.nextInt();
            }
            for(int i=0;i<size;i++){
                if(arr[i]>=18){
                    System.out.println(arr[i] +"can vote");
                }
                else{
                    System.out.println(arr[i] +"invalid to vote");
                }

            }
        }
    }




