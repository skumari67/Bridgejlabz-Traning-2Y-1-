package LeetCode;
import java.util.*;
public class Minimum_Operations_3065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int size = sc.nextInt();
        int [] nums = new int[size];
        for(int i=0;i<size;i++){
            nums[i] = sc.nextInt();
        }
        int count =0;
        for(int i=0;i<size;i++){
            if(k<nums[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
