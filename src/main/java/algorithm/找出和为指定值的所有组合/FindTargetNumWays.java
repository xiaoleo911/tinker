package algorithm.找出和为指定值的所有组合;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有和为target的组合
 * author: fupeng
 * time: 2020-11-18 14:21
 */
public class FindTargetNumWays {

    private static int res[];
    private static int index = 0;

    /**
     * 动态规划的解法没想出来。。。
     * 以下是递归的解法
     */
    public static void main(String[] args) {
        int[] array = new int[]{1,1,1,2,2,3};

        /**
         * test.txt
         * 1
         * 1
         * 1
         * 2
         * 2
         * 3
         */
//        int[] array = parseFile("D://test.txt");
        res = new int[array.length];
        findTargetSumWays(array, array.length, 6);
    }

    public static void findTargetSumWays(int[] array, int n, int sum) {
        if (n <= 0 || sum <= 0) {
            return;
        }
        if (index > 0) {
            if (sum == array[n - 1]) {
                for (int i = index - 1; i >= 0; i--) {
                    System.out.print(res[i] + "+");
                }
                System.out.println(array[n - 1]);
            }
        }
        // 取第n个数
        res[index++] = array[n - 1];
        findTargetSumWays(array, n - 1, sum - array[n - 1]);
        // 不取第n个数
        index--;
        findTargetSumWays(array, n - 1, sum);
    }

    /**
     * 按行读取文件
     *
     * @param strFile
     */
    public static int[] parseFile(String strFile) {
        List<Integer> list = new ArrayList<>();
        File file = new File(strFile);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String strLine;
            while (null != (strLine = bufferedReader.readLine())) {
                list.add(Integer.valueOf(strLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}
