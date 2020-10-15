package test;

public class MaxSubArray {

    public static int max(int m, int n) {
        return m > n ? m : n;
    }

    public static int maxSubArray(int arr[]) {
        int n = arr.length;
        int End[] = new int[n];
        int All[] = new int[n];
        End[n - 1] = arr[n - 1];
        All[n - 1] = arr[n - 1];
        End[0] = All[0] = arr[0];
        for (int i = 1; i < n; ++i) {
            End[i] = max(End[i - 1] + arr[i], arr[i]);
            All[i] = max(End[i], All[i - 1]);
        }
//		return All[n - 1];
        return End[n - 1];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, -2, 4, 8, -4, 7, -1, -5};
        System.out.println(maxSubArray(array));
    }

}
