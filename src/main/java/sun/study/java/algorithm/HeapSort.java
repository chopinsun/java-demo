package sun.study.java.algorithm;

/**
 * 堆排序
 */
public class HeapSort {

    public static int[] sort(int[] target){
        System.out.println("heap-----------------------------------------------------------------");
        int[] array = target.clone();
        //1.构建堆,从第一个非叶子节点，从下至上，从右至左 调整整个树
        for(int i=array.length/2 -1;i>=0;i--){
            build_heap(array,i,array.length);
        }
        //2. 把最后一个元素和堆顶元素交换，堆顶元素最为最后一个元素存于数组，并从树中排除。剩下的元素重新调整为堆，重复整个过程
        for (int j =array.length-1;j>0;j--){
            swap(array,0,j);
            build_heap(array,0,j);
        }
        return array;
    }

    /**
     *  构建子树，使其满足堆定义
     * @param arr 待调整的数据
     * @param s 待调整数组元素的位置
     * @param length 整个数组长度
     */
    private static void build_heap(int[] arr,int s,int length){
        int temp = arr[s];
        for(int k = 2*s+1;k<length;k=2*k+1){
            if(k+1<length && arr[k]<arr[k+1]){
                k+=1;
            }
            if(arr[k]>temp){
//                swap(arr,k,s);
                arr[s] = arr[k];
                s=k;
            }else{
                break;
            }
        }
        arr[s]= temp;
    }

    private static void swap(int[] array,int p1,int p2){
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }
}
