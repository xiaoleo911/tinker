package sort;

/**
 * author: fupeng
 * time: 2020-04-19 12:23
 */
public class SortTest {

    private static final int[] DEFAULT_ARRAY = {2, 6, 8, 7, 9, 1, 5, 4, 3};

    public static void main(String[] args) {
        // 直接插入
        InsertSort.insertSort(DEFAULT_ARRAY);

        // 希尔排序
        ShellSort.shellSort(DEFAULT_ARRAY);

        // 快速排序
        ShellSort.shellSort(DEFAULT_ARRAY);

        // 最小堆
        MinHeapSort.minHeapSort(DEFAULT_ARRAY);


    }

}
