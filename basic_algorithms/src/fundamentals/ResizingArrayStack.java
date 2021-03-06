package fundamentals;
/*imports*/
import java.util.Iterator;

/*implementation*/

/* Observe first that the class ResizingArrayStack implements the Iterable interface
 * that belongs to the java.lang package (imported by default). This allows it to use 
 * the foreach construct for its objects. 
 * 
 * In order to implement the Iterable interface,
 * this class must contain a method that returns an Iterator object! 
 * 
 * And in order to 
 * implement the Iterator interface (see nested class below), we must write a class
 * that has a hasNext() and next() implementation */

public class ResizingArrayStack<Item> implements Iterable <Item> 
{
	/* instance variables*/
	private Item[] a = (Item[]) new Object[1]; //understand how this object declaration works
	private int N = 0;
	
	/* private instance methods, not invokable by client, used for internal 
	 * implementation purposes
	 */
	
	/* method to resize the array implementing the stack, based on the number of 
	 * items currently in it.
	 */
	private void resize(int max)
	{
		Item[] temp = (Item[]) new Object[max];
		for (int i=0; i<N ; i++)
			temp[i] = a[i];
		a = temp;
	}
	
	/* public instance methods, invokable by client */
	
	/* check whether stack is empty */
	public boolean isEmpty()
	{
		return (N==0);
	}
	
	/* check size of stack */
	public int size()
	{
		return (N);
	}
	
	/* push an item into stack */
	public void push (Item item)
	{
		if (N == a.length)
			resize (2*a.length);
		a[N++] = item;
	}
	
	/* pop an item from the stack */
	public Item pop()
	{
		Item item = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length/4)
			resize (a.length/2);
		return item;
	}
	
	/*implementation of iterator which must return an Iterator object */
	public Iterator<Item> iterator()
	{
		/* We initialize a new ReverseArrayIterator object, hence the 'new' keyword */
		return (new ReverseArrayIterator()); 
	}
	
	/* implementation of the iterator class using the Iterator interface. Note that this
	 * interface is not contained in the java.lang.Iterable, but in java.util.Iterator. Hence our import.  */
	private class ReverseArrayIterator implements Iterator<Item>
	{
		private int i = N;
		public boolean hasNext()
		{
			return (i>0);
		}
		public Item next ()
		{
			return (a[--i]);
		}
		public void remove ()
		{}
	}
	
	/* main method */
	public static void main(String[] args)
	{
		System.out.println ("This works");
	}
	
}



