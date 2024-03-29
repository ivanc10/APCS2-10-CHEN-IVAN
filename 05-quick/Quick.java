import java.util.Arrays;
public class Quick {
	public static int partition (int[] data, int start, int end) {
		if (start==end) {
			return start;
		}
		int randomIndex = start + (int) ( Math.random()*(end-start));
		swap(data, start, randomIndex);
		int pivot = data[start];

		int si = start+1;
		int ei = end;

		boolean right = false;

		while (si < ei) {
			if (data[si] < pivot) {
				si++;
			}
			else if (data[si] > pivot) {
				swap(data, si, ei);
				ei--;
			}
			else if (right) {
				swap(data, si, ei);
				right = false;
				ei--;
			}
			else {
				right = true;
				si++;
			}
		}
		if (data[si] < pivot) {
			swap(data, si, start);
			return si;
		}
		else {
			swap(data, si-1, start);
			return si-1;
		}
	}
	private static void swap(int[] data, int i1, int i2) {
		int temp = data[i1];
		data[i1] = data[i2];
		data[i2] = temp;
	}
	public static int quickselect(int []data, int k) {
		int start = 0;
		int end = data.length-1;
		int pivotIndex = partition(data, start, end);
		while (k != pivotIndex) {
			if (k < pivotIndex) {
				end = pivotIndex-1;
			}
			else {
				start = pivotIndex+1;
			}
			pivotIndex = partition(data, start, end);
		}
		return data[k];
	}
	public static void quicksort(int[] data) {
		quicksort(data, 0, data.length-1);
	}
	private static void quicksort(int[] data, int start, int end) {
		// System.out.println(Arrays.toString(data) +"\n");
		// if (start <= end) {
		// 	// System.out.println(Arrays.toString(data) +"\n");
		// 	int pivotIndex = partition(data, start, end);
		// 	quicksort(data, pivotIndex+1, end);
		// 	quicksort(data, start, pivotIndex-1);
		// }
		if (start <= end) {
			int[] bounds = partitionDutch(data, start, end);
			quicksort(data, bounds[1]+1, end);
			quicksort(data, start, bounds[0]-1);
		}
	}
	public static int[] partitionDutch(int[] data, int start, int end) {
		int[] retArray = new int[2];
		if (start == end) {
			retArray[0] = start;
			retArray[1] = end;
			return retArray;
		}
		int randomIndex = start + (int) ( Math.random()*(end-start));
		swap(data, start, randomIndex);
		int pivot = data[start];

		int si = start+1;
		int ci = start+1;
		int ei = end;
		while (ci < ei) {
			if (data[ci] < pivot) {
				swap(data, si, ci);
				si++;
				ci++;
			}
			else if (data[ci] == pivot) {
				ci++;
			}
			else {
				swap(data, ci, ei);
				ei--;
			}
		}
		if (data[ci] < pivot) {
			swap(data, ci, start);
		}
		else if (data[ci] == pivot) {
			si--;
			swap(data, si, start);
		}
		else {
			si--;
			swap(data, si, start);
			ei--;
		}
		retArray[0] = si;
		retArray[1] = ei;
		return retArray;
	}
	public static int median3(int v0, int v1, int v2) {
		if (v0 < v1) {
			if (v1 < v2) {
				return v1;
			}
			else if (v2 > v0) {
				return v2;
			}
			else {
				return v0;
			}
		}
		else if (v0 < v2) {
				return v0;
		}
		else if (v2 > v1) {
			return v2;
		}
		else {
			return v1;
		}			
	}
}