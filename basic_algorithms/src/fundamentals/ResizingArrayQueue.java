package fundamentals;
/*imports*/
import java.util.Iterator;

public class ResizingArrayQueue<Item> implements Iterable <Item>
{
	/* instance variables*/
	private Item[] a = (Item[]) new Object[1]; //understand how this object declaration works
	private int T = 0; //this keeps track of the index of the tail of the queue
	private int H = 0; //this keeps track of the index of the head of the queue
	
	/* private instance methods, not invokable by client, used for internal 
	 * implementation purposes
	 */
	
	/* method to resize the array implementing the queue, based on the number of 
	 * items currently in it.
	 */
	private void resize(int max)
	{
		Item[] temp = (Item[]) new Object[max];
		for (int i=0; i<(T-H); i++)
			temp[i] = a[i+H];
		a = temp;
		
		/* reset the head and tail variables */
		int temp1 = (T-H); 
		H = 0;
		T = temp1;
	}
	
	/* public instance methods, invokable by client */
	
	/* check whether queue is empty */
	public boolean isEmpty()
	{
		/* if the tail and the head are at the same index,
		 * the queue is empty*/
		return (T==H);
	}
	
	/* check size of queue*/
	public int size()
	{
		return ((T-H));
	}
	
	/*queue an item*/
	public void enqueue (Item item)
	{
		if (T == a.length)
			resize (2*a.length);
		a[T++] = item;
	}
	
	/* dequeue item at head of queue*/
	public Item dequeue ()
	{
		Item item = a[H++];
		if ((T-H) > 0 && (T-H) == a.length/4)
		{
			/* invoke the resize function */
			resize (a.length/2);
			
			
		}
			
		return item;
	}

	
	/*implementation of iterator which must return an Iterator object */
	public Iterator<Item> iterator()
	{
		/* We initialize a new ReverseArrayIterator object, hence the 'new' keyword */
		return (new ArrayIterator()); 
	}
	
	/* implementation of the iterator class using the Iterator interface. Note that this
	 * interface is not contained in the java.lang.Iterable, but in java.util.Iterator. Hence our import.  */
	private class ArrayIterator implements Iterator<Item>
	{
		private int i = T-H;
		public boolean hasNext()
		{
			return (i>0);
		}
		public Item next ()
		{
			return (a[++H]);
		}
		public void remove ()
		{}
	}
	
	/* method to print queue of a specific type; this is part of the testing
	 * code */
	public void printQueue()
	{
		System.out.println ("Printing the current queue");
		for (Item s : this.a)
			if (s != null)
				System.out.println ((String) s);
			else
				break;
		System.out.println ();
	}
	
	
	/* main method : use this for unit testing */
	public static void main(String[] args)
	{
		/* instantiate a queue */
		ResizingArrayQueue<String> q = new ResizingArrayQueue<String>();
		
		/* testing enqueue()*/
		q.enqueue("Hello");
		q.printQueue();
		q.enqueue("I love you");
		q.printQueue();
		q.enqueue("Won't you tell me your name");
		q.printQueue();
		
		/* testing size(), isEmpty(), and dequeue() */
		int size = q.size();
		assert (size == 3); 
		
		boolean val = q.isEmpty();
		assert (!val);
		
		String item = q.dequeue();
		assert (item == "Hello");
		size = q.size();
		assert (size == 2);
		
		item = q.dequeue();
		q.printQueue();
		assert (item == "I love you");
		size = q.size();
		assert (size == 1);
		
		item = q.dequeue();
		assert (item == "Won't you tell me your name");
		val = q.isEmpty();
		assert (val);
				
	}
}