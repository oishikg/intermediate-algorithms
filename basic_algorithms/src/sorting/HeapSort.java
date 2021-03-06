package sorting;

public class HeapSort 
{
	/* implementation of exchange () */
	private static void exchange (int[] pq, int k1, int k2)
	{
		int temp = pq [k1];
		pq [k1] = pq [k2];
		pq [k2] = temp;
	}
		
	
	/* modified sink () implementation */
	private static void sink (int[] pq, int k, int N)
	{
		while (2*k < N)
		{
			/* first find the larger of the two children */
			int largerChildIndex = 0;
			if (2*k + 1 == N)
				largerChildIndex = 2*k;
			else if (pq [2*k] > pq [2*k + 1])
				largerChildIndex = 2*k;
			else
				largerChildIndex = 2*k + 1;
						
			/* now check if the parent is lesser; if so,
			 * swap and continue sinking, otherwise break
			 */
			if (pq[k] < pq[largerChildIndex])
			{
				exchange (pq, k, largerChildIndex);
				k = largerChildIndex;
				continue;
			}
			else
				break;
		}
	}
	
	/* function to shift the entire array to the right by one position, in accordance
	 * with the heap condition that requires arr[0] to be empty 
	 */
	private static int[] shift (int[] arr)
	{
		int[] temp = new int [arr.length + 1];
		for (int i = 1 ; i < temp.length ; i++)
			temp [i] = arr [i-1];
		/* return the reference to the newly modified array; remember that
		 * while arrays in java are passed by references, the references to
		 * the arrays themselves are passed by value
		 */
		return (temp);
	}
	
		/* function to display the contents of the array; use for debugging */
	public static void printArray (int[] arr)
	{
		System.out.println ("The array is currently as follows: ");
		for (int i = 1 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println ();
	}
	
	/* heap sort implementation: starting from the middle of the input array,
	 * reheapify in descending order until the array is heap-ordered; then exchange the first
	 * and last element, reheapify the entire array with the exception of the
	 * last element (which is already in its correct position; continue 
	 * until the entire array is sorted; */
	
	public static void heapSort (int[] arr)
	{
		/* shift all elements in arr by one position to the right; the shifted array
		 * is reference by a temporary reference temp; we perform the heap sort on temp
		 * and finally copy the sorted array back into arr at the end */
		int[] temp;
		temp = shift (arr);
						
		/* heap order the array; note that we start from the middle, 
		 * because all the keys to the right of the middles element
		 * are single-element sub-heaps that do not need to be reheapified
		 */
		int N = temp.length;
		for (int k = N/2 ; k > 0 ; k--)
			sink (temp, k, N);
		
		
		/* sort the heapified array */
		N = N - 1; //decrement N by 1 to avoid IndexOutOfBound errors
		while (N > 1) 
		{
			/* exchange the first and last elements of the heap*/
			exchange (temp, N , 1);
			/* reheapify arr [1 ... N-1] */
			sink (temp, 1, N--);
		}
		
		/* copy the sorted array back to the original array */
		for (int i = 1 ; i < temp.length ; i++)
			arr[i-1] = temp[i];
	}
			
	/* function to certify whether the resultant array is 
	 * at all sorted
	 */
	public static boolean isSorted (int[] arr)
	{
		for (int i=1 ; i<arr.length ; i++)
		{
			if (arr[i] < arr[i-1])
				return false;
		}
		return true;
	}
	
	/* main function to test the sort function */
	public static void main (String[] args)
	{
		int[] arr1 = {0, 7, 6, 5, 4, 3, 2, 1};
		int[] arr2= {2, 18, 2, 1, -89, 33 , 23, 9};
		int[] arr3= {99, 108, 32, -8, 89, 69, 420, 320 , 1085};
		int[] arr4 = {5, 108, -54, 33, 38, 76, 0, 0, 1, 2, 9, 12};
		int[] arr5 = {67, 66, 134, 1035, -896, 345, 200};
		
		heapSort (arr1);
		printArray (arr1);
		assert (isSorted (arr1));
		
		heapSort (arr2);
		printArray (arr2);
		assert (isSorted (arr2));
		
		heapSort (arr3);
		printArray (arr3);
		assert (isSorted (arr3));
		
		heapSort (arr4);
		printArray (arr4);
		assert (isSorted (arr4));
		
		heapSort (arr5);
		printArray (arr5);
		assert (isSorted (arr5));
	}
}
