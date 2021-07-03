package algorithm.编程之美.字符串;

/**
 * 1.2 字符串包含
 * 给定一长字符串a 和 一短字符串b，判断短字符串b中的所有字符是否都在长字符串a中
 * @Author: tinker
 * @Date: 2021/07/03 15:26
 */
public class StringContain {

    public static void main(String[] args) {
        String a = "ABCD";
        String b = "BAD";
        System.out.println(stringContain1(a, b));
        System.out.println(stringContain2(a, b));
    }

    private static boolean stringContain1(String a, String b) {
        if (a == null || a.length() <= 0) return false;
        if (b == null || b.length() <= 0) return false;
        char[] bChars = b.toCharArray();
        for (char bChar : bChars) {
            if (!a.contains(String.valueOf(bChar))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 位运算解法，一个字符对应hash二进制值为1的一个数字
     * @param a
     * @param b
     * @return
     */
    private static boolean stringContain2(String a, String b) {
        if (a == null || a.length() <= 0) return false;
        if (b == null || b.length() <= 0) return false;
        int hash = 0;
        for (int i = 0; i < a.length(); i++) {
            hash |= 1 << (a.charAt(i) - 'A');
        }
        for (int j = 0; j < b.length(); j++) {
            if ((hash & (1 << (b.charAt(j) - 'A'))) == 0) {
                return false;
            }
        }
        return true;
    }


}
