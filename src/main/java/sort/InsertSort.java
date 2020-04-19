package sort;

/**
 * 直接插入排序
 * author: fupeng
 * time: 2020-04-19 11:38
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = {2, 6, 8, 7, 9, 1, 5, 4, 3};
        insertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void insertSort(int[] data) {
        int temp;
        for (int i = 1; i < data.length; i++) {//取第i个数,插入前边的有序的序列
            temp = data[i];
            int j;
            for (j = i - 1; j >= 0; j--) {//从第i-1的位置上开始比较
                if (data[j] > temp) {//若前面的数大，则往后挪一位
                    data[j + 1] = data[j];
                } else {
                    break;//否则，说明要插入的数比较大
                }
            }
            data[j + 1] = temp;//找到这个位置，插入数据
        }
    }

}
