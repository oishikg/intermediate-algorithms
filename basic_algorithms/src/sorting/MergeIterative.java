package sorting;

/* iterative implementation of merge sort 
 */
public class MergeIterative
{

	/* the auxiliary array should be global static variable to avoid 
	 * repeated declarations and initializations
	 */
	private static int[] aux;
			
		
	/* function to merge two sorted arrays */
	private static void merge (int[] arr, int lo, int mid, int hi)
	{
		int i = lo; // i keeps track of the left side of the array
		int j = mid + 1;  // j keeps track of the right side of the array
		
		/* copy the array into the auxiliary one; note that
		 * there are 2N array accesses, N for arr, and N for aux */
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
	
			
	/* the bottom up implementation of merge sort requires
	 * setting a sub-array size, merging the sub-arrays, and then doubling
	 * the size and repeating the process
	 */
	public static void mergeSort (int[] arr)
	{
		/* initialize the auxiliary array */
		int N = arr.length;
		aux = new int [N];
		/* the outer loop iterates through the doubling sizes of the array */
		for (int sz = 1 ; sz < N ; sz *= 2)
		{
			/* the inner loop iterates through all the merges for a given sub-array size; 
			 * we want to limit the size of lo as follows so that a mid point may be established between
			 * the sub-arrays (notice that if lo exceeds N-sz, the mid point will be out of bounds
			 * */
			for (int lo = 0 ; lo <= N - sz ; lo += sz + sz)
			{
				int mid =  lo + sz -1;
				/* for the hi variable, we want to go past two sub-arrays of size sz; the offset of -1
				 * is due to array indices starting at 0; finally, since the array may not be 
				 * a perfect power of two, we have the option of using the last index of the array
				 * to prevent an overflow*/
				int hi = Math.min(lo + sz + sz - 1, N-1);
				merge (arr, lo, mid, hi);
			}
		}
		
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
