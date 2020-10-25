package algorithm.数组;

import java.util.Arrays;

/**
 * 两个有序数组合并成一个有序数组，去除重复元素，并使其依然保持有序
 *
 * author: fupeng
 * time: 2020-10-25 20:46
 */
public class ArrayMerge {


    public static void main(String[] args) {
        int[] nums1 = {1,2,4};
        int[] nums2 = {2,3,5};

        System.out.println("it should be 1,2,3,4,5");
        System.out.println("=============================");
        System.out.println(Arrays.toString(merge(nums1, nums1.length, nums2, nums2.length)));

        nums1 = new int[]{2,3,5};
        nums2 = new int[]{1,2,4};

        System.out.println();
        System.out.println(("it should be 1,2,3,4,5"));


        System.out.println("=============================");
        System.out.println(Arrays.toString(merge(nums1, nums1.length, nums2, nums2.length)));

    }

    /**
     *
     * @param nums1
     * @param m         nums1的length
     * @param nums2
     * @param n         nums2的length
     */
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int p = 0;
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while (p1 < m && p2 < n) {
            int min = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
            if (p == 0) {
                nums[p++] = min;
                count++;
            } else {
                if (min > nums[p - 1]) {
                    nums[p++] = min;
                    count++;
                }
            }
        }
        if (p1 < m) {
            System.arraycopy(nums1, p1, nums, p, m - p1);
            count += m - p1;
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums, p, n - p2);
            count += n - p2;
        }

        int[] result = new int[count];
        System.arraycopy(nums, 0, result, 0, count);
        return result;
    }

}
