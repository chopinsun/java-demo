package sun.study.java;

import sun.study.java.algorithm.QuickSort;
import sun.study.java.algorithm.QuickSort1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlgorithmTest {

    public static void main(String[] args) {
        int[] arr = {12,4,62,5,28,45,94,924,73,75,23,8,43,88,46,765,98};
        int[] result = QuickSort.sort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }
    }

}