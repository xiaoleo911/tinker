package algorithm.编程之美.字符串;

/**
 * 1.1 字符串的旋转
 * 给定一个字符串，要求将字符串前面的若干个字符移到字符串的尾部。
 *
 * @Author: tinker
 * @Date: 2021/07/03 14:54
 */
public class MoveStringToLeft {

    public static void main(String[] args) {
        String originStr = "abcwxyz";
        String expectStr = "wxyzabc";
        System.out.println(moveStringToLeft1(originStr, 3));
        System.out.println(moveStringToLeft2(originStr, 3));
    }

    /**
     * 解法1：字符串拼接
     * @param originStr
     * @param leftShiftNum
     * @return
     */
    private static String moveStringToLeft1(String originStr, int leftShiftNum) {
        if (leftShiftNum > originStr.length()) {
            return "";
        }
        String subStr = originStr.substring(0, leftShiftNum);
        return originStr.substring(leftShiftNum) + subStr;
    }

    /**
     * 解法二：先旋转0到leftShiftNum - 1， 再旋转leftShiftNum 到 len - 1，最后旋转 0 到 len - 1
     * @param originStr
     * @param leftShiftNum
     * @return
     */
    private static String moveStringToLeft2(String originStr, int leftShiftNum) {
        int len = originStr.length();
        if (len <= 0) {
            return "";
        }
        leftShiftNum = leftShiftNum % len;
        char[] charArray = originStr.toCharArray();
        reverseStr(charArray, 0, leftShiftNum - 1);
        reverseStr(charArray, leftShiftNum, len - 1);
        reverseStr(charArray, 0, len - 1);
        return String.valueOf(charArray);
    }

    private static void reverseStr(char[] charArray, int from, int to) {
        while (from < to) {
            char tmp = charArray[from];
            charArray[from++] = charArray[to];
            charArray[to--] = tmp;
        }
    }

}
