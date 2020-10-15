package test;

public class GetKMin {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1, 5, 2, 6, 8, 0, 6};
        int kMin = getKMin(a, 4);
        System.out.println(kMin);
    }

    public static int getKMin(int array[], int k) {
        if (array == null) {
            return Integer.MIN_VALUE;
        }
        if (array.length < k) {
            return Integer.MIN_VALUE;
        }
        return quickSort(array, 0, array.length - 1, k);
    }

    public static int quickSort(int array[], int low, int high, int k) {
        int i, j;
        int tmp;
        if (low > high) {
            return Integer.MIN_VALUE;
        }
        i = low;
        j = high;
        tmp = array[low + 1];
        while (i < j) {
            while (i < j && array[j] >= tmp)
                j--;
            if (i < j)
                array[i++] = array[j];
            while (i < j && array[i] < tmp)
                j++;
            if (i < j)
                array[j--] = array[i];
        }
        array[i] = tmp;
        if (i + 1 == k)
            return tmp;
        else if (i + 1 > k)
            return quickSort(array, low, i - 1, k);
        else
            return quickSort(array, i + 1, high, k);
    }


}
