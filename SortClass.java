package sortSummary;

public class SortClass {

	public static void swap(int a, int b){
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void BubbleSort1(int array[], int n)
	{
		for(int i = 0 ; i < n - 1 ; i ++ ){
			for( int j = 1 ; j < n - i; j ++ ){
				if (array[j-1] > array[j])
				{
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void BubbleSort2(int array[], int n)
	{
		boolean flag = true;
		int i = 0 ;
		int j = 1 ;
		while(flag)
		{
			flag = false;
			for(j = 1 ; j < n - i ; j ++ )
			{
				if(array[j-1] > array[j]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
					flag = true;
				}
			}
			i++;
		}
	}
	
	public static void BubbleSort3(int array[], int n)
	{
		int flag = n ;
		int i = 0 ; 
		while(flag > 0 ) 
		{
			i = flag;
			flag = 0;
			for(int j = 1; j < i ; j ++ )
			{
				if(array[j-1] > array[j]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
					flag = j;
				}
			}
			
		}
	}
	
	
	public static void randomProduce(int array[], int n){
		for (int i = 0 ; i < n ; i ++ )
		{
			array[i] = (int)(Math.random()*20);
		}
		System.out.println("Original array is:");
		printArray(array,20);
	}
	
	
	public static void printArray(int array[], int n){
		for (int i = 0 ; i < n ; i ++ )
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void selectionSort(int array[], int n){
		int current = Integer.MAX_VALUE;
		for (int i = 0 ; i < n -1; i ++ ){
			current = i;
			for(int j = i + 1; j < n ; j ++ ){
				if(array[current] > array[j])
					current = j;
			}
			int temp = array[current];
			array[current] = array[i];
			array[i] = temp;
		}
	}

	
	public static void insertSort(int array[], int n){
		int i,j;
		for(j = 1; j < n ; j ++ )
		{
			int temp = array[j];
			for(i = j - 1 ; i >=0 && array[i] > temp  ; i-- )
			{
				array[i+1]=array[i];
			}
			array[i+1] = temp;
		}
	}
	
	
	public static void mergeSort(int array[], int helper[], int left, int right){
		int middle = (left + right )/ 2;
		if(left < right) {
		mergeSort(array, helper, left, middle);
		mergeSort(array, helper, middle+1, right);
		merge(array, helper, left, middle, right);
		}
		
	}
	
	public static void merge(int array[], int helper[], int left, int middle, int right){
		for(int i = left ; i <=right; i ++ ){
			helper[i] = array[i];
		}
		int first_index = left;
		int second_index = middle+1;
		int current = left;
		while(first_index <=middle && second_index <= right){
			if(helper[first_index] <= helper[second_index])
			{
				array[current++]=helper[first_index++];
			}
			else
			{
				array[current++]=helper[second_index++];
			}
		}
		if(first_index<=middle){
			while(first_index <= middle)
				array[current++] = helper[first_index++];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int basicArray[] = new int[20];
		randomProduce(basicArray,20);
		
		int helper[] = new int[20];
		mergeSort(basicArray, helper, 0, 19);
		printArray(basicArray, 20);
	}

}
