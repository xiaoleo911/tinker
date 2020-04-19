package sort;

import java.util.Arrays;

/**
 * 希尔排序（直接插入排序升级版）
 * author: fupeng
 * time: 2020-04-19 12:22
 */
public class ShellSort {

    public static void shellSort(int[] array) {
        int length = array.length;
        for (int i = length / 2; i > 0; i /= 2) {//序列的间隔，一直到间隔为一，这时候就只有一个子序列
            for (int j = i; j < length; j++) {//从i之后每个数字都要进行插入排序，就是插入的序列是各自不同的序列
                int temp = array[j];//里面就是直接插入算法
                int k;
                for (k = j - i; k >= 0; k -= i) {//实现各个数字插入排序到不同的序列中，直到间隔为1的时候，只有一个序列，就是完全的一个直接插入排序
                    if (temp < array[k]) {
                        array[k + i] = array[k];
                    } else {
                        break;
                    }
                }
                array[k + i] = temp;//把数字插入到位置上
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
