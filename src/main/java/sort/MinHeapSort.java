package sort;

/**
 * 堆排序
 * author: fupeng
 * time: 2018-07-26 11:38
 */
public class MinHeapSort {

	public static void main(String[] args) {
		int i;
		int a[] = {2,1,3,4,5};
		int len = a.length;
		myMinHeapSort(a);
		for(i = 0;i<len;i++){
			System.out.println(a[i] + " ");
		}
	}

	public static void adjustMinHeap(int[] a,int pos,int len){
		int temp;
		int child;
		for(temp = a[pos];2*pos + 1 <=len;pos=child){
			//数组从0开始，r(i)<=r(2i) r(i)<=r(2i+1)  对应 pos => 2 * pos + 1 和 2 * pos +2
			child = 2 * pos + 1;
			if (child < len && a[child] > a[child + 1]) {
				child++;
			}
			if (a[child] < temp) {
				a[pos] = a[child];
			}else {
				break;
			}
		}
		a[pos] = temp;
	}

	public static void myMinHeapSort(int[] array){
		int i;
		int len = array.length;
		//构建最小堆
		for (i = len/2 -1;i >= 0;i--) {
			adjustMinHeap(array, i, len - 1);
		}
		//堆顶是最小值，交换堆顶和最后一个数，再重新调整最小堆，下一次循环   i--
		for(i = len -1;i>=0;i--){
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			adjustMinHeap(array, 0, i - 1);
		}
	}

}
