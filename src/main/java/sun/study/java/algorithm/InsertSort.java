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
public class InsertSort {


    public static int[] sort(int[] target){
        System.out.println("insert-----------------------------------------------------------------");
        int[] array = target.clone();
        int cnt =0;
        for (int i = 1; i <array.length ; i++) {
            int temp = array[i];
            int j ;
            for (j = i; j >0 && temp<array[j-1] ; j--) {
                array[j]=array[j-1];
                cnt++;
            }
            array[j] = temp;
        }
        System.out.println("done! use time:"+ cnt);
        return array;
    }

}
