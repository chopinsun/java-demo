package sun.study.java.algorithm;
/**
 * 选择排序
 * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。
 */
public class ChooseSort {

    public static int[] sort(int[] target){
        System.out.println("choose-----------------------------------------------------------------");
        int[] array = target.clone();
        for (int i = 0; i < array.length; i++) {
            int min  = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j]<array[min]){
                    min = j;
                }
            }
            swap(array,i,min);
        }
        return array;
    }

    private static void swap(int[] array,int p1,int p2){
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}
