package test;

public class YuanJing1 {

    /*
     * 远景面试题1：
     * 给出一个整数，看时候存在一个整数的平方等于它
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 49;

        //二分法
        int result = method1(a);
        System.out.println(result);

        //1 = 1  2^2 = 1 + 3  3^2 = 1 + 3 + 5  等差数列  公式法
        result = method2(a);
        System.out.println(result);
    }

    public static int method1(int a) {
        if (a < 1) {
            return -1;
        }
        int low = 1;
        int high = a;
        int mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (mid * mid == a) {
                return mid;
            } else if (mid * mid > a) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return -1;

    }


    public static int method2(int n) {
        if (n < 1) {
            return -1;
        }
        int count = 1;
        int d = 1;
        while (n > 0) {
            n -= d;
            d += 2;
            if (n == 0) {
                return count;
            }
            count++;
        }
        return -1;
    }

}
