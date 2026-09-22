package Arrays.sorting;

public class sort_array {
    public static void main(String[]args){
        int nums[]={10,7,3,9,2};
        for(int i=0;i<nums.length;i++){
            for(int j =0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp =nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        for(int i =0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
