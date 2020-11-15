package algorithm.二分查找;

import java.util.Arrays;

/**
 * 二叉排序树寻找第k大的数；找出一个有序数组种所有值为m的数位置，要求时间复杂度在最坏情况下也为logn
 *
 * author: fupeng
 * time: 2020-10-25 22:50
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,6,6,6,8};
        System.out.println(Arrays.toString(searchAllIndex(6, arr)));
    }



    public static int[] searchAllIndex(int key, int[] arr) {
        int[] result;
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int start = 0;
        int end = arr.length - 1;
        if (arr[start] > key || arr[end] < key) {
            return new int[0];
        }

        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] > key) {
                end = mid - 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                int midL = mid;
                int midR = mid;
                int count = 1;

                while (midL - 1 >= 0 && arr[midL - 1] == key) {
                    count++;
                    midL--;
                }
                while (midR + 1 < arr.length && arr[midR + 1] == key) {
                    count++;
                    midR++;
                }
                result = new int[count];
                for (int i = 0, from = midL; i < count; i++, from++) {
                    result[i] = from;
                }
                return result;
            }
        }
        return new int[0];
    }

    public static int searchIndex(int key, int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        if (arr[start] > key || arr[end] < key) {
            return -1;
        }

        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] > key) {
                end = mid - 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                while (mid - 1 >= 0 && arr[mid - 1] == key) {
                    mid--;
                }
                return mid;
            }
        }
        return -1;
    }

}
