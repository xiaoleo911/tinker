package test;

public class QunShuo {

    /**
     * 例如a = [1,9]
     * <p>
     * a = 2
     * s = 2 +22
     * <p>
     * a = 4
     * s = 4 + 44 + 444 + 4444
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 9;
        int s = calucate(a);
        System.out.println(s);
    }

    public static int calucate(int a) {
        if (a < 1) {
            return -1;
        }
        int s = 0;
        int temp = 0;
        for (int i = 0; i < a; i++) {
            temp = temp * 10 + a;
            System.out.println(temp);
            s += temp;
        }
        return s;
    }

}
