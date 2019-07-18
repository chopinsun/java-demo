package sun.study.java.algorithm;

/**
 * 插入排序
 * ①从第一个元素开始，该元素可以认为已经被排序
 * ②取出下一个元素，在已经排序的元素序列中从后向前扫描
 * ③如果该元素（已排序）大于新元素，将该元素移到下一位置
 * ④重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * ⑤将新元素插入到该位置后
 * ⑥重复步骤2~5
 */
public class InsertSort2 {

    public static int[] sort(int[] target){
        int[] arr = target.clone();
        insert(arr,1);
        return arr;

    }

    private static void insert(int[] arr,int end){
        if(end >arr.length-1){
            return;
        }
        int t = arr[end];
        int i = end;
        for (; i >0 && arr[i-1]>t; i--) {
            arr[i] = arr[i-1];
        }
        arr[i]=t;
        insert(arr,end+1);
    }

}
