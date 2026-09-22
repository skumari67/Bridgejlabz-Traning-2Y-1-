package Arrays.sliding_Window;

public class intro_to_sliding_window {
    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6};
        int size  =3;
        int sum =0;
        int maxsum =0;
        for(int i=0;i<size;i++){
            sum+=nums[i];
        }
        System.out.println(sum);
        for(int i=0;i<nums.length-size;i++)
        {
            sum = sum - nums[i-1]+nums[i+size-1];
            System.out.println(sum);
        }
    }

}
