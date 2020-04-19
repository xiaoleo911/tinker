package sort;

import java.util.Arrays;

/**
 * 简单选择排序
 * author: fupeng
 * time: 2020-04-19 13:10
 */
public class SelectSort {

    public static void selectSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {//确定每次开始的位置
            int min = array[i];//设定开始数字为最小的值最小值
            int flag = i;
            for (int j = i + 1; j < len; j++) {//把最小值存放到min,从开始数字向后一个个和min比较，再把最小值存放到min
                if (min > array[j]) {
                    min = array[j];
                    flag = j;
                }
            }
            if (flag != i) {
                array[flag] = array[i];
                array[i] = min;
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
