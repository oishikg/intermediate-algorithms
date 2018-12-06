package sorting;
/* Not to be run, this file only serves as a template for all 
 * the other sorting classes that we will be writing */


public class SortTemplate 
{
	/* helper function to exchange items based on keys */
	private static void exchange (int[] arr, int k1, int k2)
	{
		int temp = arr[k1];
		arr[k1] = arr[k2];
		arr[k2] = temp;
	}
	
	/* main sort function */
	public static void sortFunction (int[] arr)
	{
		
	}
	
	/* function to check if one of the two items being compared
	 * is less than the other */
	private static boolean isLessThan (int v, int w)
	{
		return (v.compareTo(w) < 0)
	}
		
		
	/* function to certify whether the resultant array is 
	 * at all sorted
	 */
	public static boolean isSorted (int[] a)
	{
		for (int i=1 ; i<arr.length ; i++)
		{
			if (isLessThan (arr[i], arr[i-1]))
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
	
	}
	
}