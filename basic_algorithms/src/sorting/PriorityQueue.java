package sorting;


public class PriorityQueue 
{
	/* instance variables: note that we only implement a pq for integers, 
	 * and a variable N to keep track of the size of the pq */
	int[] pq; 
	int N = 0;
	int defaultPqSize = 5;
	
	/* constructor to instantiate the priority queue with a default  
	 * initial size; in addition to the initial size, we implement 
	 * the pq with array resizing */
	public PriorityQueue ()
	{
		pq = new int [defaultPqSize];
	}
	
	/* instance methods */
	
	/* private helper method to resize the pq; note that
	 * the loop bounds are slightly altered here owing to the
	 * the heap implementation */
	private void resize(int max)
	{
		int [] temp = new int[max];
		for (int i = 1 ; i <= N ; i++)
			temp[i] = pq [i];
		pq = temp;
	}
	
	/* helper function to exchange items based on keys */
	private void exchange (int k1, int k2)
	{
		int temp = pq [k1];
		pq [k1] = pq [k2];
		pq [k2] = temp;
	}
	
	/* swim() implementation */
	private void swim ()
	{
		/* set k to N, where the most recently inserted element sits */
		int k = N;
		
		/* swim up based on the heap criterion; note that k > 1 because when k = 1
		 * we have reached the root, and have no parent to check with; putting k > 0
		 * is incorrect, because the algorithm will then compare  pq[0] and pq[1],
		 * but by convention, pq[1] is the root, and there is no item in pq[0] */
		while ( k > 1)
		{
			if (pq [k/2] < pq [k])
				exchange (k/2, k);
			else
				break;
			k /= 2;
		}
	}

	
	/* sink () implementation */
	private void sink ()
	{
		int k = 1;
		while (2*k < N)
		{
			/* first find the larger of the two children */
			int largerChildIndex = 0;
			/* note that 2*k + 1 can equal at most N, and not more, because 2*k can equal 
			 * at most N-1 by the condition stipulated in the while loop; in this case 
			 * arr[k] has only one child at a[2*k]
			 */
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
				exchange (k, largerChildIndex);
				k = largerChildIndex;
				continue;
			}
			else
				break;
		}
		
	}
	
	/* method to return current size of pq */
	public int size ()
	{
		return N;
	}
		
	/* insert operation: recall that to insert a value in the pq, we place it at the
	 * end of the pq, and then swim up to reheapify */
	public void insert (int key)
	{
		/* check if resizing is required */
		if (N == pq.length - 1)
			resize (2 * pq.length);
				
		/* next, increment the pq size by 1, and then insert key at the end;
		 * note that we increment N first to follow the convention of leaving
		 * pq[0] empty*/ 
		pq [++N] = key;
		/* finally, reheapify by invoking swim */
		swim ();
	}
	
	/* deleteMax operation : delete the item in pq[1], reduce size of heap by 1, bring 
	 * item from end of of heap to the root position, them reheapify, this time by sinking*/
	public int deleteMax ()
	{
		/* first check if the pq is empty or not; if so
		 * throw an exception; we haven't implemented this, because 
		 * this version of the algorithm is quick-and-dirty run 
		 * through of the algorithm; 
		 */
		
		/* extract the max item */
		int max = pq[1];
		
		/* place item at end of heap in its position and decrement heap size */
		pq[1] = pq [N--];
		
		/* nullify the last position */
		pq [N+1] = 0;
		
		/* check if resizing is required */
		if (N > 0 && N < pq.length/4)
			resize (pq.length/2);
		
		/* reheapify by sinking */
		sink ();
		
		/* return the maximum value */
		return max;
	}
	
	/* function to print pq in its current form */
	public void printPq ()
	{
		System.out.println ("The pq is currently as follows: ");
		for (int i = 1 ; i <= N ; i++)
			System.out.print(pq[i] + " ");
		System.out.println ();
		System.out.println ("The size of the array  : " + pq.length);
		System.out.println ();
	}
	
	
	/* main function to test the pq */
	public static void main (String[] args)
	{
		/* create new pq */
		PriorityQueue pq = new PriorityQueue ();
		
		/* test the insert operations first */
		pq.insert(3);
		pq.printPq();
		pq.insert(10);
		pq.printPq();
		pq.insert(15);
		pq.printPq();
		pq.insert(6);
		pq.printPq();
		pq.insert (18);
		pq.printPq();
		pq.insert(17);
		pq.printPq();
		pq.insert(-8);
		pq.printPq();
		pq.insert(399);
		pq.printPq();
		pq.insert(-98);
		pq.printPq();
		pq.insert(32);
		pq.printPq();
				
		/* test the delete operations next */
		int m = pq.deleteMax();
		System.out.print ("The maximum value is : ");
		System.out.println (m);
		pq.printPq();
		
		m = pq.deleteMax();
		System.out.print ("The maximum value is : ");
		System.out.println (m);
		pq.printPq();
		
		m = pq.deleteMax();
		System.out.print ("The maximum value is : ");
		System.out.println (m);
		pq.printPq();
		
		m = pq.deleteMax();
		System.out.print ("The maximum value is : ");
		System.out.println (m);
		pq.printPq();
		
		m = pq.deleteMax();
		System.out.print ("The maximum value is : ");
		System.out.println (m);
		pq.printPq();
		
		m = pq.deleteMax();
		System.out.print ("The maximum value is : ");
		System.out.println (m);
		pq.printPq();
		
		m = pq.deleteMax();
		System.out.print ("The maximum value is : ");
		System.out.println (m);
		pq.printPq();
		
		System.out.println ("Testing pq on interleaveing inserts and deletes");
		System.out.println(); 
		
		/* test operations more realistically, with interleaving inserts and deletes */
		pq.insert(88);
		pq.printPq();
		
		pq.insert(12);
		pq.printPq();
		
		m = pq.deleteMax();
		System.out.print ("The maximum value is : ");
		System.out.println (m);
		pq.printPq();
		
		pq.insert(19);
		pq.printPq();
		
		pq.insert(299);
		pq.printPq();
		
		pq.insert(-356);
		pq.printPq();
		
		m = pq.deleteMax();
		System.out.print ("The maximum value is : ");
		System.out.println (m);
		pq.printPq();
		
		m = pq.deleteMax();
		System.out.print ("The maximum value is : ");
		System.out.println (m);
		pq.printPq();
	}
}
