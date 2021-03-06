package sort;

import java.util.Arrays;

/**
 * 堆排序
 * author: fupeng
 * time: 2018-07-26 11:38
 */
public class HeapSort {


    /**
     * 小顶堆排序
     *
     * @param array
     */
    public static void minHeapSort(int[] array) {
        int i;
        int len = array.length;
        // 构建最小堆
        for (i = len / 2 - 1; i >= 0; i--) {
            adjustMinHeap(array, i, len);
        }
        // 堆顶是最小值，交换堆顶和最后一个数，再重新调整最小堆，下一次循环   i--
        for (i = len - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustMinHeap(array, 0, i);
        }
        System.out.println(Arrays.toString(array));
    }

    private static void adjustMinHeap(int[] a, int pos, int len) {
        int temp;
        int child;
        for (temp = a[pos]; 2 * pos + 1 < len; pos = child) {
            // 数组从0开始，r(i)<=r(2i) r(i)<=r(2i+1)  对应 pos => 2 * pos + 1 和 2 * pos +2
            child = 2 * pos + 1;
            // 有右孩子，且右孩子数值更小
            if (child + 1 < len && a[child] > a[child + 1]) {
                child++;
            }
            // 最小的孩子小于根节点
            if (a[child] < temp) {
                a[pos] = a[child];
            } else {
                break;
            }
        }
        a[pos] = temp;
    }

    /**
     * 大顶堆排序
     *
     * @param array
     */
    public static void maxHeapSort(int[] array) {
        int i;
        int len = array.length;
        // 构建最大堆
        for (i = len / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(array, i, len);
        }
        // 堆顶是最大值，交换堆顶和最后一个数，再重新调整最大堆，下一次循环   i--
        for (i = len - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustMaxHeap(array, 0, i);
        }
        System.out.println(Arrays.toString(array));
    }

    private static void adjustMaxHeap(int[] a, int pos, int len) {
        int temp;
        int child;
        for (temp = a[pos]; 2 * pos + 1 < len; pos = child) {
            // 数组从0开始，r(i)>=r(2i) r(i)>=r(2i+1)  对应 pos => 2 * pos + 1 和 2 * pos +2
            child = 2 * pos + 1;
            // 有右孩子，且右孩子数值更大
            if (child + 1 < len && a[child] < a[child + 1]) {
                child++;
            }
            // 最大的孩子大于根节点
            if (a[child] > temp) {
                a[pos] = a[child];
            } else {
                break;
            }
        }
        a[pos] = temp;
    }

}
