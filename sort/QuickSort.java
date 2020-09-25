package sort;

public class QuickSort {
	static int arr[] = {10, 7, 8, 9, 1, 5}; 
	
	public static void main(String args[]) {
		sort(0, arr.length - 1);
		for (int loop=0; loop<arr.length; ++loop)
			System.out.print(arr[loop] + ", ");
	}
	
	private static void swap (int pos, int withPos) {
		int temp = arr[pos];
		arr[pos] = arr[withPos];
		arr[withPos] = temp;
	}
	
	private static int partition(int l, int h) {
		int i = l - 1;
		while(l<h) {
			if (arr[l] < arr[h])
				swap(++i, l);
			++l;
		}
		
		swap(++i, h);
		return i;
	}
	
	private static void sort(int low, int high) {
		if (low < high) {
			int i = partition(low, high);
			sort(low, i-1);
			sort(i+1, high);
		}
	}
}
