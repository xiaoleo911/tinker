package test;

public class YuanJing2 {

    /*
     * 远景面试题2：
     * 给出一个数组，只有一个数出现一次，其他书都出现两次，找出这个数
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int result = findOneNum(a);
        System.out.println(result);

    }

    public static int findOneNum(int[] a) {
        int b = 0;
        for (int i = 0; i < a.length; i++) {
            b = b ^ a[i];
        }
        return b;
    }


}
