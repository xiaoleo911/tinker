package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * author: fupeng
 * time: 2020-04-19 17:04
 */
public class BubbleSort {

    /**
     * @author fupeng
     * 冒泡排序优化第二版
     * 第一版优化增加flag标记，没有数字交换直接return，最优时间复杂度O(n)
     * 第二版优化，增加tempPostion记录内循环最后一次交换的位置，来缩减内循环的次数
     */
    public static void bubbleSort(int[] array) {
        int len = array.length - 1;
        int temp; // 开辟一个临时空间, 存放交换的中间值
        int tempPostion = 0;  // 记录最后一次交换的位置
        // 要遍历的次数
        for (int i = 0; i < array.length - 1; i++) {
            int flag = 1; // 设置一个标志位
            // 依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = 0; j < len; j++) {
                // 比较相邻的元素，如果前面的数大于后面的数，交换
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = 0;  // 发生交换，标志位置0
                    tempPostion = j;  // 记录交换的位置
                }
            }
            len = tempPostion; // 把最后一次交换的位置给len，来缩减内循环的次数
            if (flag == 1) {// 如果没有交换过元素，则已经有序
                System.out.println(Arrays.toString(array));
                return;
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
