package Recursion;

public class merge_sort {
    public static void mergesort(int arr[],int l ,int r) {
        if(l>=r){
            return;
        }
        int mid = l+r/2;
        mergesort(arr,l,mid);
        mergesort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public static void merge(int arr[],int l,int mid,int r){
        int temp[] = new int[r-l+1];
        int i =l;
        int j = mid+1;
        int k =0;
        while(i<=mid && j<=r){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=r){
            temp[k++]=arr[j++];
        }
        for(int k1=0;k1<temp.length;k1++){
            arr[k1]=temp[k1];
        }
    }
}
