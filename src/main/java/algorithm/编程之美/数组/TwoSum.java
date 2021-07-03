package algorithm.编程之美.数组;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 2.2 寻找和为定值的两个数
 *
 * @Author: tinker
 * @Date: 2021/07/03 17:27
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 10, 11, 15};
        int target = 15;
        twoSum1(array, target);
        twoSum2(array, target);
    }

    public static void twoSum1(int[] array, int target) {
        if (array == null || array.length <= 0) {
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(array[0], 0);
        for (int i = 1; i < array.length; i++) {
            if (map.get(target - array[i]) != null) {
                System.out.println(array[i] + " + " + array[map.get(target - array[i])] + " = " + target);
                return;
            } else {
                map.put(array[i], i);
            }
        }
    }

    /**
     * 排序夹逼算法
     * @param array
     * @param target
     */
    public static void twoSum2(int[] array, int target) {
        if (array == null || array.length <= 0) {
            return;
        }
        Arrays.sort(array);
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            int currentSum = array[begin] + array[end];
            if (currentSum == target) {
                System.out.println(array[begin] + " + " + array[end] + " = " + target);
                return;

                // 如果需要打印所有的组合
                /*
                begin++;
                end--;
                 */
            } else if (currentSum < target) {
                begin++;
            } else {
                end--;
            }
        }
    }

}