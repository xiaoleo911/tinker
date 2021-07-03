package algorithm.编程之美.字符串;

import java.util.ArrayList;

/**
 * 1.3 字符串的全排列
 * 输入一个字符串，打印出该字符串中字符的所有排列
 *
 * @Author: tinker
 * @Date: 2021/07/03 15:41
 */
public class CallAllPerMutation {

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(findPermutation(str));
    }

    /**
     * 递归实现
     * @param s
     * @return
     */
    public static ArrayList<String> findPermutation(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        findPermutation(res, s.toCharArray(), 0);
        return res;
    }

    public static void findPermutation(ArrayList<String> res, char[] chars, int i) {
        if (i == chars.length) {
            res.add(new String(chars));
            return;
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            findPermutation(res, chars, i + 1);
            swap(chars, i, j);
        }
    }

    public static void swap(char[] chars, int from, int to) {
        if (from >= chars.length || to >= chars.length) {
            return;
        }
        char tmp = chars[from];
        chars[from] = chars[to];
        chars[to] = tmp;
    }

}
