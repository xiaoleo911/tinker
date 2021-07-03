package algorithm.编程之美.数组;

import java.util.ArrayList;

/**
 * 2.1 寻找最小的k个数
 *
 * @Author: tinker
 * @Date: 2021/07/03 17:35
 */
public class SearchMinK {

    public static void main(String[] args) {
        SearchMinK test = new SearchMinK();
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = test.searchMinK(array, 4);
        System.out.println(result);
    }

    /**
     * 线性选择算法（参考快速排序思想）
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> searchMinK(int[] input, int k) {
        // 由于本题需要返回ArrayList<Integer>，所以新建之
        ArrayList<Integer> list = new ArrayList<>();
        // 若输入数组长度小于k。直接返回数空的ArrayList
        if (input.length < k) {
            return list;
        }

        findKMin(input, 0, input.length - 1, k);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private void findKMin(int[] a, int start, int end, int k) {
        if (start < end) {
            int pos = partition(a, start, end);
            if (pos == k - 1) {
                return;
            } else if (pos < k - 1) {
                findKMin(a, pos + 1, end, k - pos);
            } else {
                findKMin(a, start, pos - 1, k);
            }
        }
    }

    /**
     * 快排中的每次排序实现（挖坑填数法），每次返回的是交换后start位置（快排一次后的中轴点，中轴点左边全是小于它的，右边都是大于它的）
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    public int partition(int[] a, int start, int end) {
        int pivot = a[start];
        while (start < end) {
            while (start < end && a[end] >= pivot) {
                end--;
            }
            a[start] = a[end];
            while (start < end && a[start] <= pivot) {
                start++;
            }
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;
    }


}
