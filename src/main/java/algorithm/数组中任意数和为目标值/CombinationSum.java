package algorithm.数组中任意数和为目标值;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求数组中任意数的和为目标值（数字可重复 or 不可重复）
 * 例如：
 * {1, 1, 1, 2, 2, 3} target = 6
 * 组合为：
 * [[1, 1, 1, 3], [1, 1, 2, 2], [1, 1, 2, 2], [1, 2, 3], [1, 2, 3], [1, 1, 2, 2], [1, 2, 3], [1, 2, 3], [1, 2, 3], [1, 2, 3]]
 *
 * @author: fupeng
 * @date: 2020/11/20 11:40
 */
public class CombinationSum {

    private static List<List<Integer>> res;

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 2, 2, 3};

        // 数字可以重复（解法一）
        res = new ArrayList<>();
        long startTime1 = System.currentTimeMillis();
        combinationSumCanRepeat(array, 6);
        System.out.println(Arrays.toString(res.toArray()));
        long endTime1 = System.currentTimeMillis();
        System.out.println("执行时间： " + (endTime1 - startTime1) + "ms");

        // 数字可以重复（解法二）
        res = new ArrayList<>();
        result = new int[array.length];
        long startTime2 = System.currentTimeMillis();
        combinationSumRecursive(array, array.length, 6);
        System.out.println(Arrays.toString(res.toArray()));
        long endTime2 = System.currentTimeMillis();
        System.out.println("执行时间： " + (endTime2 - startTime2) + "ms");


        // 数字不可以重复
        res = new ArrayList<>();
        long startTime3 = System.currentTimeMillis();
        combinationSumNoRepeat(array, 6);
        System.out.println(Arrays.toString(res.toArray()));
        long endTime3 = System.currentTimeMillis();
        System.out.println("执行时间： " + (endTime3 - startTime3) + "ms");

    }

    /**
     * 数字可以重复
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSumCanRepeat(int[] candidates, int target) {
        Arrays.sort(candidates);
        helperCanRepeat(candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    private static void helperCanRepeat(int[] candidates, int target, ArrayList<Integer> list, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                helperCanRepeat(candidates, target - candidates[i], list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private static int result[];
    private static int index = 0;

    /**
     * 数字可以重复(递归法)
     *
     * @param candidates
     * @return
     */
    public static void combinationSumRecursive(int[] candidates, int n, int target) {
//        if (n <= 0 || target <= 0) {
//            return;
//        }
//        if (index > 0) {
//            if (target == candidates[n - 1]) {
//                for (int i = index - 1; i >= 0; i--) {
//                    System.out.print(result[i] + "+");
//                }
//                System.out.println(candidates[n - 1]);
//            }
//        }
//        // 取第n个数
//        result[index++] = candidates[n - 1];
//        combinationSumRecursive(candidates, n - 1, target - candidates[n - 1]);
//        // 不取第n个数
//        index--;
//        combinationSumRecursive(candidates, n - 1, target);
        if (n <= 0 || target <= 0) {
            return;
        }
        if (index > 0) {
            if (target == candidates[n - 1]) {
                List<Integer> list = new ArrayList<>();
                for (int i = index - 1; i >= 0; i--) {
                    list.add(result[i]);
                }
                list.add(candidates[n - 1]);
                res.add(list);
            }
        }
        // 取第n个数
        result[index++] = candidates[n - 1];
        combinationSumRecursive(candidates, n - 1, target - candidates[n - 1]);
        // 不取第n个数
        index--;
        combinationSumRecursive(candidates, n - 1, target);
    }



    /**
     * 数字不可以重复
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSumNoRepeat(int[] candidates, int target) {
        Arrays.sort(candidates);
        helperNoRepeat(candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    private static void helperNoRepeat(int[] candidates, int target, ArrayList<Integer> list, int index) {
        if (target == 0) {
            if (!res.contains(list)) {
                res.add(new ArrayList<>(list));
            }
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                helperNoRepeat(candidates, target - candidates[i], list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }


}
