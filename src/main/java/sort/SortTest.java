package sort;

/**
 * 八大排序算法
 * author: fupeng
 * time: 2020-04-19 12:23
 */
public class SortTest {

    private static final int[] DEFAULT_ARRAY = {2, 6, 8, 7, 9, 1, 5, 4, 3};

    public static void main(String[] args) {
        /**
         * 直接插入
         */
        InsertSort.insertSort(DEFAULT_ARRAY);

        /**
         * 希尔排序
         */
        ShellSort.shellSort(DEFAULT_ARRAY);

        /**
         * 简单选择排序
         */
        SelectSort.selectSort(DEFAULT_ARRAY);

        /**
         * 冒泡排序
         */
        BubbleSort.bubbleSort(DEFAULT_ARRAY);

        /**
         * 堆排序
         */
        // 小顶堆排序
        HeapSort.minHeapSort(DEFAULT_ARRAY);
        // 大顶堆排序
        HeapSort.maxHeapSort(DEFAULT_ARRAY);

        /**
         * 快速排序
         */
        QuickSort.quickSort(DEFAULT_ARRAY);

        /**
         * 归并排序
         */
        MergeSort.mergeSort(DEFAULT_ARRAY);

        /**
         * 基数排序
         */
        RadixSort.radixSort(DEFAULT_ARRAY);
    }

}
