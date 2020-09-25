package sort;

import java.util.Arrays;

public class NutsAndBolts {
	static int nuts[] = {'a', 'b', 'c', 'd'};
	static int bolts[] = {'b', 'c', 'a', 'd'};
	
	public static void main(String args[]) {
		sort(0, nuts.length - 1);
		System.out.println(Arrays.toString(nuts));
		System.out.println(Arrays.toString(bolts));
	}
	
	private static void swap(int arr[], int pos, int withPos) {
		int temp = arr[pos];
		arr[pos] = arr[withPos];
		arr[withPos] = temp;
	}
    
	public static int partition(int arr[], int p, int low, int high) {
		int i = low - 1;
		while(low < high) {
			if (arr[low] < p)
				swap(arr, ++i, low);
			else if (arr[low] == p)
				swap(arr, low--, high);
			++low;
		}
		swap(arr, ++i, high);
		return i;
	}
	
	public static void sort(int low, int high) {
		if (low < high) {
			int i = partition(nuts, bolts[high], low, high);
			partition(bolts, nuts[i], low, high);
			sort(low, i-1);
			sort(i+1, high);
		}
	}
}
