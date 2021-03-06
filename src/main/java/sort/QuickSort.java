package sort;

import java.util.Arrays;

/**
 * 快速排序
 * author: fupeng
 * time: 2018-07-26 11:38
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] a, int low, int high) {
        int i = low;
        int j = high;
        if (a.length <= 1) {
            return;
        }
        if (i >= j) {
            return;
        }
        int index = a[i];
        while (i < j) {
            while (i < j && a[j] >= index) {
                j--;
            }
            if (a[j] < index) {
                a[i++] = a[j];
            }
            while (i < j && a[i] <= index) {
                i++;
            }
            if (a[i] > index) {
                a[j--] = a[i];
            }
        }
        a[i] = index;
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }

}
