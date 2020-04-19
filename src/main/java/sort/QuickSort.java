package sort;

/**
 * 快速排序
 * author: fupeng
 * time: 2018-07-26 11:38
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] a = { 2, 6, 8, 7, 9, 1, 5, 4, 3 };
		quickSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void quickSort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	public static void sort(int[] a, int low, int high) {
		int i = low;
		int j = high;
		int index = a[i];
		if (a.length <= 1) {
			return;
		}
		if (i >= j) {
			return;
		}
		while (i < j) {
			while(i < j && a[j] >= index)
				j--;
			if (a[j] < index)
				a[i++] = a[j];
			while(i < j && a[i] <= index)
				i++;
			if (a[i] > index)
				a[j--] = a[i];
		}
		a[i] = index;
		sort(a, low, i-1);
		sort(a, i+1, high);
		
	}

}
