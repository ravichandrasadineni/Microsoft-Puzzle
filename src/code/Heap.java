package code;


public class Heap {

	
	public static void main(String[] args)  {
		int array[] = {10,9,8,7,6,5,4,3,2,1};
		
		for (int i =0; i < 10; i ++) {
			System.out.print(array[i] + "\t");			
		}
		System.out.println();			
		constructHeap(array);
		for (int i =0; i < 10; i ++) {
			System.out.print(array[i] + "\t");			
		}
		
		
		
	}
	
	static void constructHeap(int[] array) {
		for(int i = (array.length)/2; i>=0; i--) {
			minHeapify(array,i);
		}
		
		
	}
	
	static void  maxHeapify(int array[], int index) {
		int maxIndex = index;
		int temp;
		if(index*2 +1 < array.length )
		{
			if(array[maxIndex] < array[index*2 +1]) {
				maxIndex = index*2 +1;
			}
		}
		else if(index*2 +2 < array.length) {
			if (array [maxIndex] < array[index*2 +2]) {
				maxIndex = index*2 +2;
			}
		}
		
		if (maxIndex != index) {
			temp = array[maxIndex];
			array[maxIndex] = array[index];
			array[index] = temp;
			maxHeapify(array, maxIndex);
		}
	}
	
	
	static void minHeapify(int array[], int index) {
		int minIndex = index;
		int temp;
		if(index*2 + 1< array.length )
		{
			if(array[minIndex] > array[index*2 + 1]) {
				minIndex = index*2 +1;
			}
		}
		if(index*2 +2 < array.length) {
			if (array [minIndex] > array[index*2 +2]) {
				minIndex = index*2 +2;
			}
		}
		
		if (minIndex != index) {
			temp = array[minIndex];
			array[minIndex] = array[index];
			array[index] = temp;
			minHeapify(array, minIndex);
		}
	}
}
