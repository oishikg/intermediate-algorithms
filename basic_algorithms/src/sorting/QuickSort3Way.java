package sorting;
import java.util.*;

/* this algorithm partitions the array into 3 parts, one for elements less than the
 * pivot, one for elements greater than the pivot, and the middle part for
 * elements equal to the pivot; in this way, we avoid including repeated pivot 
 * elements in the smaller sub-arrays thereby improving computational efficiency 
 * for inputs with a large number of repeated elements
 */
public class QuickSort3Way
{
	/* helper function to exchange items based on keys */
	private static void exchange (int[] arr, int k1, int k2)
	{
		int temp = arr[k1];
		arr[k1] = arr[k2];
		arr[k2] = temp;
	}
	
	/* integer implementation of compareTo */
	private static int compareTo (int v1, int v2)
	{
		if (v1 < v2)
			return (-1);
		else if (v1 > v2)
			return (1);
		else
			return (0);
	}
	
	/* helper function to implement the 3 way quick sort helper function */
	private static void quickSort3WayHelper (int[] arr, int lo, int hi)
	{
		/* base case: when we have one or no elements left in nnthe
		 * sub-array (indicated by the index conditions below), then 
		 * we return */
		if (hi <= lo)
			return;
		
		/* initialize the scanning variables */
		int lt = lo, gt = hi, i = lo + 1;
		int pivot = arr[lo];
		
		while (i <= gt)
		{
			int cmp = compareTo (arr[i], pivot);
			
			/* cmp > 0 implies that a[i] > pivot, in which case we 
			 * want to move it to the arr [gt + 1 ... hi] section of the array
			 */
			if (cmp > 0)
				exchange (arr, i, gt--);
			/* in this case, a[i] < pivot, and we would want it to be in the
			 * arr [0 ... lt-1] section of the array; consequently, we exchange the
			 * elements in the ith and lt-th position, and then increment i and lt; 
			 */
			else if (cmp < 0)
				exchange (arr, i++, lt++);
			/* when cmp = 0, the a[i] = pivot, and we want it in the arr [ lt ... i-1]
			 * section of the array; in our implementation, that means leaving
			 * a[i] as it is, and incrementing i
			 */
			else
				i++;
		}
		
		/* once the pass through the array is complete, invoke
		 * recursively the helper function on arr [0 ... lt-1] and arr [gt ... hi];
		 * notice that the arr [lt ... i-1] elements are not passed in the recursive 
		 * calls, which greatly improves the algorithm's efficiency if there are 
		 * a high number of repetitions
		 */
		quickSort3WayHelper (arr, lo, lt - 1);
		quickSort3WayHelper (arr, gt + 1, hi);
	}
	
	/* function to randomly shuffle the array, code taken from : 
	 * https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array */
	private static void shuffleArray(int[] arr)
	{
		int index, temp;
		Random random = new Random();
		for (int i = arr.length - 1; i > 0; i--)
		{
	        index = random.nextInt(i + 1);
	        temp = arr[index];
	        arr[index] = arr[i];
	        arr[i] = temp;
	    }
	}
	
	
	/* main sort function */
	public static void quickSort3Way (int[] arr)
	{
		/* randomly shuffle input array to remove dependence on
		 * the input order; see discussion in textbook regarding this shuffle
		 */
		shuffleArray (arr);
		/* invoke the helper function which recursively implements the quick sort
		 * algorithm
		 */
		quickSort3WayHelper (arr, 0, arr.length-1);
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
		int[] arr0 = {2, 1, 7, 5, 7, 7, 3, 3, 5, 1, 3, 4, 3, 6};
		quickSort3Way (arr0);
		printArray (arr0);
		assert (isSorted (arr0));
		
		int[] arr1 = {7, 6, 5, 4, 6, 8, 8, 3, 2, 1};
		quickSort3Way (arr1);
		printArray (arr1);
		assert (isSorted (arr1));
		
		int[] arr2= {2, 18, 2, 1, -89, 33 ,-21, -89, 18, 18, 18, 23, 9};
		quickSort3Way (arr2);
		printArray (arr2);
		assert (isSorted (arr2));
		
		int[] arr3= {99, 108, 32, -8, 89, 69, 69, 69, 108, 420, 320 , 1085};
		quickSort3Way (arr3);
		printArray (arr3);
		assert (isSorted (arr3));
	}
	
}