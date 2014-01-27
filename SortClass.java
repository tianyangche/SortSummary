package sortSummary;

public class SortClass {

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static void randomProduce(int array[], int n) {
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 80) + 10;
		}
		System.out.println("Original array is:");
		printArray(array, 20);
	}

	public static void printArray(int array[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void isSorted(int array[], int n) {
		boolean result = true;
		for (int i = 1; i < n; i++) {
			if (array[i] < array[i - 1])
				result = false;
		}
		if (result)
			System.out.println("Sorted");
		else
			System.out.println("Unsorted");
	}

	// 1. bubble sort
	/*
	 * public static void BubbleSort1(int array[], int n) { for(int i = 0 ; i <
	 * n - 1 ; i ++ ){ for( int j = 1 ; j < n - i; j ++ ){ if (array[j-1] >
	 * array[j]) { int temp = array[j-1]; array[j-1] = array[j]; array[j] =
	 * temp; } } } }
	 */

	public static void BubbleSort2(int array[], int n) {
		boolean flag = true;
		int i = 0;
		int j = 1;
		while (flag) {
			flag = false;
			for (j = 1; j < n - i; j++) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					flag = true;
				}
			}
			i++;
		}
	}

	public static void BubbleSort3(int array[], int n) {
		int flag = n;
		int i = 0;
		while (flag > 0) {
			i = flag;
			flag = 0;
			for (int j = 1; j < i; j++) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					flag = j;
				}
			}

		}
	}

	// 2. selection sort
	public static void selectionSort(int array[], int n) {
		int current = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			current = i;
			for (int j = i + 1; j < n; j++) {
				if (array[current] > array[j])
					current = j;
			}
			int temp = array[current];
			array[current] = array[i];
			array[i] = temp;
		}
	}

	// 3. insertion sort
	public static void insertSort(int array[], int n) {
		int i, j;
		for (i = 1; i < n; i++) {
			if (array[i] < array[i - 1]) {
				int temp = array[i];
				for (j = i - 1; j >= 0 && temp < array[j]; j--)
					array[j + 1] = array[j];
				array[j + 1] = temp;
			}
		}
	}

	// 4. mergeSort
	public static void mergeSort(int array[], int n) {
		int helper[] = new int[n];
		mergeSort(array, 0, n - 1, helper);
	}

	public static void mergeSort(int array[], int left, int right, int helper[]) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergeSort(array, left, middle, helper);
			mergeSort(array, middle + 1, right, helper);
			merge(array, left, middle, right, helper);
		}
	}

	public static void merge(int array[], int left, int middle, int right,
			int helper[]) {
		int firstIndex = left;
		int secondIndex = middle + 1;
		int current = left;
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}
		while (firstIndex <= middle && secondIndex <= right) {
			if (helper[firstIndex] <= helper[secondIndex])
				array[current++] = helper[firstIndex++];
			else
				array[current++] = helper[secondIndex++];
		}
		if (firstIndex != middle) {
			while (firstIndex <= middle)
				array[current++] = helper[firstIndex++];
		}
	}

	// 5. quick sort
	public static void quickSort(int array[], int n) {
		quickSort(array, 0, n - 1);
	}

	public static void quickSort(int array[], int left, int right) {
		if (left < right) {
			int middle = partition(array, left, right);
			quickSort(array, left, middle - 1);
			quickSort(array, middle + 1, right);
		}
	}

	public static int partition(int array[], int left, int right) {
		int position = left;
		int j;

		for (j = left; j < right; j++) {
			if (array[j] < array[right]) {
				int temp = array[position];
				array[position] = array[j];
				array[j] = temp;
				position++;
			}
		}

		int temp = array[right];
		array[right] = array[position];
		array[position] = temp;

		return position;

	}

	// 6. shell sort
	public static void shellSort(int array[], int n) {
		int i, j;
		for (int increment = n / 2; increment > 0; increment /= 2) {
			for (i = increment; i < n; i++) {
				if (array[i] < array[i - increment]) {
					int temp = array[i];
					for (j = i - increment; j >= 0 && temp <= array[j]; j -= increment)
						array[j + increment] = array[j];
					array[j + increment] = temp;
				}
			}
		}
	}

	// 7. counting sort
	public static void countingSort(int array[], int n, int k) {
		int array_B[] = new int[n];
		int array_C[] = new int[k];
		for (int i = 0; i < k; i++)
			array_C[i] = 0;
		for (int i = 0; i < n; i++) {
			array_C[array[i]]++;
		}

		for (int i = 1; i < k; i++) {
			array_C[i] = array_C[i] + array_C[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			array_B[array_C[array[i]] - 1] = array[i];
			array_C[array[i]]--;
		}
		printArray(array_B, 20);
		isSorted(array_B, 20);
	}

	// 8. radix sort

	public static int getKthDigit(int num, int k) {
		int result = ((int) (num / Math.pow(10, k - 1))) % 10;
		return result;
	}

	public static void radixSort(int array[], int n, int numDigit) {
		int count[] = new int[10];
		int tempArray[] = new int[n];
		for (int currentDigit = 1; currentDigit <= numDigit; currentDigit++) {

			for (int i = 0; i < 10; i++)
				count[i] = 0;

			for (int i = 0; i < n; i++) {
				count[getKthDigit(array[i], currentDigit)]++;
			}

			for (int i = 1; i < 10; i++) {
				count[i] += count[i - 1];
			}

			
			// watch out here! We must start from n
			for (int i = n-1 ; i >=0 ; i--) {
				tempArray[count[getKthDigit(array[i], currentDigit)] - 1] = array[i];
				count[getKthDigit(array[i], currentDigit)]--;
			}

			for (int i = 0; i < n; i++) {
				array[i] = tempArray[i];
			}
			printArray(array, n);
		}

		printArray(array, n);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int basicArray[] = new int[20];
		randomProduce(basicArray, 20);
		radixSort(basicArray, 20, 2);
		printArray(basicArray, 20);
	}

}
