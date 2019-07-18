package sun.study.java.algorithm;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 排序算法,
 * 从小到大排
 */
public class Sort {
    private final static int[] target ={19,32,1,45,93,23,63,2,9,43,78,34,49,33,8,5,27,6,37,94,84,59,36,12};//一个无序数组
    //TODO 快排
    public static int[] quick(){
        int[] array = target.clone();

        return array;
    }

    private static void swap(int[] array,int p1,int p2){
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }

    private static void print(int[] array){
        StringBuilder st = new StringBuilder();
        Arrays.stream(array).forEach(x-> st.append(x).append(","));
        System.out.println(st.deleteCharAt(st.length()-1).toString());
    }

    public static void main(String[] args) {
//        print(PopSort.sort(target));
        print(InsertSort2.sort(target));
//        print(ChooseSort2.sort(target));
//        print(HeapSort.sort(target));
//        print(MergeSort.sort(target));
//        print(QuickSort.sort(target));
//        print(MergeSort.sort(target));

    }

}
