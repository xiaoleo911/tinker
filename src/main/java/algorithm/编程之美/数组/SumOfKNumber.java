package algorithm.编程之美.数组;

import java.util.*;

/**
 * 2.3 寻找和为定值的多个数
 *
 * @Author: tinker
 * @Date: 2021/07/03 16:45
 */
public class SumOfKNumber {

    private static int length;
    private static int[] flag;

//    public static void main(String[] args) {
//        int sum = 10, n = 10;
//        length = n;
//        flag = new int[n];
//        sumOfKNumber(sum, n);
//    }

    /**
     * 解法1：转换为 n - 1 的问题
     * 入参为：1 - n 的连续正整数
     *
     * @param sum
     * @param n
     */
    private static void sumOfKNumber(int sum, int n) {
        if (n <= 0 || sum <= 0) {
            return;
        }
        if (n > sum) {
            n = sum;
        }
        if (n == sum) {
            flag[n - 1] = 1;
            for (int i = 0; i < length; i++) {
                if (flag[i] == 1) {
                    System.out.print(i + 1 + " ");
                }
            }
            System.out.println();
            flag[n - 1] = 0;
        }
        // 包含第n - 1 个数
        flag[n - 1] = 1;
        sumOfKNumber(sum - n, n - 1);
        // 不包含第n - 1 个数
        flag[n - 1] = 0;
        sumOfKNumber(sum, n - 1);
    }

    public static void main(String[] args) {
        int[] candidates = {4, 3, 2, 1, 5};
        List<List<Integer>> result = combinationSum(candidates, 10);
        System.out.println(result);
    }

    /**
     * 解法二：回溯剪枝法
     * https://blog.csdn.net/dadongwudi/article/details/108485315
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 此处排序为了后续的剪枝
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
//            dfs(candidates, i, len, target - candidates[i], path, res);
            // 注意：由于每一个元素不可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i + 1, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }
    }


}
