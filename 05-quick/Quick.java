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

		while (si < ei) {
			if (data[si] < pivot) {
				si++;
			}
			else if (data[si] > pivot) {
				swap(data, si, ei);
				ei--;
			}
			else if (Math.random() < 0.5) {
				swap(data, si, ei);
				ei--;
			}
			else {
				si++;
			}
		}
		if (data[si] <= pivot) {
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
				end = pivotIndex;
			}
			else {
				start = pivotIndex;
			}
			pivotIndex = partition(data, start, end);
		}
		return data[k];
	}
}