package sun.study.java.algorithm;

/**
 * 归并排序
 */
public class MergeSort {

    public static int[] sort(int[] target){
        System.out.println("merge-------------------------------------------------------------------");
        int[] array=target.clone();
        int[] temp = new int[array.length];
        split(array,temp,0,array.length-1);
        array = temp;
        return array;
    }

    private static void split(int[] arr,int[] temp,int low,int height){
        if(low>=height){
            return;
        }
        int mid = (low + height)/2;
        split(arr,temp,low,mid);
        split(arr,temp,mid+1,height);
        merge(arr,temp,low,height,mid);
    }

    private static void merge(int[] arr,int[] temp,int low,int height,int mid){
        int i=low,j=mid+1,n=0;

        while(i <=mid && j<=height){
            if(arr[i]<=arr[j]){
                temp[n++]=arr[i++];
            }else{
                temp[n++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[n++] = arr[i++];
        }
        while(j<=height){
            temp[n++] = arr[j++];
        }
        n=0;
        while (low<=height){
            arr[low++] = temp[n++];
        }
    }

    private static void swap(int[] array,int p1,int p2){
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}
