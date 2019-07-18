package sun.study.java.algorithm;

/**
 * 快排
 * 取基数，一般是第一个元素
 * 将小于基数的数排列在基数左边，大于基数的数排列在基数右边
 * 在左右两边重复上述过程，直到不能再分
 */
public class QuickSort {

    public static int[] sort(int[] target){
        System.out.println("quick-------------------------------------------------------------------");
        int[] array = target.clone();

        compiler(array,0,array.length-1);

        return array;
    }

    public static void compiler(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int temp = arr[left],l=left,r=right;
        while(l<r){
            while(l<r && arr[r]>=temp){
                r--;
            }
            if(l<r){
                arr[l++]=arr[r];
            }
            while(l<r  && arr[l]<=temp){
                l++;
            }
            if(l<r){
                arr[r--] = arr[l];
            }
        }
        arr[l] = temp;
        compiler(arr,left,r-1);
        compiler(arr,l+1,right);
    }

    private static void swap(int[] array,int p1,int p2){
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}
