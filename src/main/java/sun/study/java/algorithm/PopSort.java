package sun.study.java.algorithm;

/**
 * 冒泡排序
 * 比较相邻的两个元素，如果顺序不对就交换，直到遍历完整个数组
 *
 */
public class PopSort {

    public static int[] sort(int[] target){
        System.out.println("pop-------------------------------------------------------------------");
        int cnt=0;
        int[] array = target.clone();
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if(array[j]<array[j-1]){
                    swap(array,j-1,j);
                }
                cnt++;
            }
        }
        System.out.println("dene! use time:"+ cnt);
        return array;
    }
    private static void swap(int[] array,int p1,int p2){
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}
