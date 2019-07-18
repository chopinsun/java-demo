package sun.study.java.algorithm;
/**
 * 选择排序
 * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。
 */
public class ChooseSort2 {

    public static int[] sort(int[] target){
        int[] arr = target.clone();
        choose(arr,0);
        return arr;
    }

    private static void choose(int[] arr,int start){
        if(start< arr.length){
            int min = findMin(arr,start);
            swap(arr,min,start);
            choose(arr,start+1);
        }
    }

    private static int findMin(int[] arr,int start){
        int t = arr[start];
        int position = start;
        for (int i = start+1; i < arr.length; i++) {
            if(t>arr[i]){
                t = arr[i];
                position = i;
            }
        }
        return position;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
