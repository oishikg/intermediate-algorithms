package sorting;
import java.util.*;

public class QuickSort
{
	/* helper function to exchange items based on keys */
	private static void exchange (int[] arr, int k1, int k2)
	{
		int temp = arr[k1];
		arr[k1] = arr[k2];
		arr[k2] = temp;
	}
	
	/* function to implement quick sort partitioning */
	private static int partition (int[] arr, int lo, int hi)
	{
		/* initialize the left and right scanners*/
		int i = lo;
		int j = hi + 1;
		/* set the pivot */
		int pivot = arr[lo];
		/* scan from left and right */
		while (true)
		{
			/* left-scan */
			while (arr[++i] <= pivot)
			{
				/* if i == hi, we have reached the end of this partition,
				 * so we break; note that at this stage, i > j, i = j, or i < j;
				 * Case 1 (i > j) : we break out of the outer while loop 
				 * Case 2 (i = j) : in the following loop, the control first decrements
				 * j, so we are guaranteed that i > j and that the outer loop breaks
				 * Case 3 (i < j) : this would happen if the control has not reached the 
				 * next loop, and so j = hi + 1 = i + 1; in this case, there is the 
				 * possibility that arr[hi] < pivot, which would take the control
				 * back to this while loop, and cause and IndexOutOfBounds Exception. 
				 * To handle this case where it is not possible for 
				 * j and i to cross over, the last condition in the outer loop utilizes
				 * a less than equal to, and not just a less than.  
				 */
				if (i == hi)
					break;
			}
			
			/* right-scan */
			while (arr[--j] >= pivot)
			{
				/* if j == lo, we have reached the end of this partition ,
				 * so we break.  
				 */
				if (j == lo)
					break;
			}
			
			/* if the control reaches this point in the program, we may have 
			 * two elements that require to be switched; first check if i and j
			 * have crossed over or not
			 */
			if (j <= i)
				break;
			/* if i and j have not crossed over, switch the elements */
			exchange (arr, i, j);
		}
		/* once i and j have crossed over OR i=hi or j=lo (these 
		 * two cases indicate the pathological cases of the array already being
		 * in ascending or descending order respectively), exchange the pivot element
		 * and the element in the current j-th index
		 */
		exchange (arr, lo, j);
		/* finally, return the most current position of the pivot element, i.e., j*/
		return (j);
	}
	
	/* helper function to implement sort */
	private static void quickSortHelper (int[] arr, int lo, int hi)
	{
		/* base case: if the hi index has crossed over (or equal to) the lo
		 * index, then there are no sub-arrays left to be sorted, so we return; note
		 * that there is no operation performed after the return, making this
		 * algorithm tail recursive */
		if (hi <= lo)
			return;
		/* invoke the partition function */
		int pivot = partition (arr, lo, hi);
		/* once the partition has been implemented and 
		 * the pivot element moved into place, recursively call 
		 * the helper function on the left and right halves of the array
		 */
		quickSortHelper (arr, lo, pivot-1);
		quickSortHelper (arr, pivot+1, hi);
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
	public static void quickSort (int[] arr)
	{
		/* randomly shuffle input array to remove dependence on
		 * the input order; see discussion in textbook regarding this shuffle
		 */
		shuffleArray (arr);
		/* invoke the helper function which recursively implements the quick sort
		 * algorithm
		 */
		quickSortHelper (arr, 0, arr.length-1);
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
		int[] arr0 = {2, 1, 7, 5, 4, 3, 6};
		quickSort (arr0);
		printArray (arr0);
		assert (isSorted (arr0));
		
		int[] arr1 = {7, 6, 5, 4, 3, 2, 1};
		quickSort (arr1);
		printArray (arr1);
		assert (isSorted (arr1));
		
		int[] arr2= {2, 18, 2, 1, -89, 33 , 23, 9};
		quickSort(arr2);
		printArray (arr2);
		assert (isSorted (arr2));
		
		int[] arr3= {99, 108, 32, -8, 89, 69, 420, 320 , 1085};
		quickSort(arr3);
		printArray (arr3);
		assert (isSorted (arr3));
	}
	
}
