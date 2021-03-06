package sorting;

/* we implement the merge sort algorithm only for primitve integers now; we will
 * figure our the more generic implementation using the Comparable interface later. Note 
 * that this a recursive (or top-down) implementation of the algorithm. While more 
 * intuitive, each recursive call implies the creation of a new stack frame which 
 * might lead to run-time memory issues. See the MergeIterative implementation for a bottom up
 * approach.
 */
public class MergeRecursive 
{

	/* the auxiliary array should be global static variable to avoid 
	 * repeated declarations and initializations
	 */
	private static int[] aux;
			
		
	/* function to merge two sorted arrays */
	private static void merge (int[] arr, int lo, int hi, int mid)
	{
		int i = lo; // i keeps track of the left side of the array
		int j = mid + 1;  // j keeps track of the right side of the array
		
		/* copy the array into the auxiliary one */
		for (int k = lo ; k <= hi ; k++)
			aux[k] = arr[k];
		
		/* perform the merge */
		for (int k = lo ; k <= hi ; k++)
		{
			/* if the left side of the array is exhausted, add element from right side */
			if (i > mid)
				arr[k] = aux[j++];
			/* if the right side of the array is exhausted, add element from the left side */
			else if (j > hi)
				arr[k] = aux[i++];
			/* current key on the right >= key on left */
			else if (aux[i] < aux[j])
				arr[k] = aux[i++];
			else
				arr[k] = aux[j++];
						
		}
		
	}
	
	/* merge sort helper function */
	
	private static void mergeSortHelper (int[] arr, int lo, int hi)
	{
		/* base case; note that the base case returns an empty value because
		 * this algorithm implements the sort using an array */
		if (hi <= lo)
			return ;
		int mid = lo + (hi-lo)/2 ;
		/* sort the left half of the present array */
		mergeSortHelper (arr, lo, mid);
		/* sort the right half of the present array */
		mergeSortHelper (arr, mid+1 , hi);
		/* merge the two sorted halves */
		merge (arr, lo, hi, mid);
				
	}
	
		
	/* main sort function */
	public static void mergeSort (int[] arr)
	{
		/* initialize the auxiliary array */
		aux = new int [arr.length];
		mergeSortHelper (arr, 0, arr.length-1);
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
	
	/* function to print sorted array */
	private static void printArray (int[] arr)
	{
		System.out.println("Printing the array ");
		for (int i=0 ; i<arr.length ; i++)		
			System.out.println(arr[i]);
	}
	
	
	/* main function to test the API code */
	public static void main (String[] args)
	{
		int[] arr1 = {7, 6, 5, 4, 3, 2, 1};
		mergeSort (arr1);
		printArray (arr1);
		assert (isSorted (arr1));
		
		int[] arr2= {2, 18, 2, 1, -89, 33 , 23, 9};
		mergeSort(arr2);
		printArray (arr2);
		assert (isSorted (arr2));
		
		int[] arr3= {99, 108, 32, -8, 89, 69, 420, 320 , 1085};
		mergeSort(arr3);
		printArray (arr3);
		assert (isSorted (arr3));
		
	}
	
}