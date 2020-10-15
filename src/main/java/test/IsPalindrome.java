package test;

public class IsPalindrome {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        boolean result = isPalindrome(123321);
        System.out.println(result);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        String result = "";
        int a = 0;
        int b = x;
        while (b != 0) {
            a = b % 10;
            result += a;
            b = b / 10;
        }
        if (result.equals("" + x)) {
            return true;
        } else {
            return false;
        }
    }

}
