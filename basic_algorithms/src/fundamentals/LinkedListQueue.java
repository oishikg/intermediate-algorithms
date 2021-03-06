package fundamentals;

public class LinkedListQueue<Item>
{
	/* nested class for user defined node */
	private class Node
	{
		/* every node in a linked list contains an item, and a refernce
		to the next node in the list */
		Item item;
		Node next;
	}
	
	/* instance variables*/
	Node pointerToHead;
	Node pointerToTail;
	int N;
	
	/* instance methods */
	
	
	public boolean isEmpty()
	{ return (N==0);}
	
	
	public int size()
	{ return (N);}
	
	public void enqueue (Item item)
	{
		/* create new node */
		Node temp = pointerToTail;
		pointerToTail = new Node();
		pointerToTail.item = item;
		
		/* check whether this is the first entry or not */
		if (this.isEmpty())
			pointerToHead = pointerToTail;
		else
			temp.next = pointerToTail;
	
		/* increment counter */
		N++; 
	}
	
	public Item dequeue ()
	{
		Item dequeuedItem = pointerToHead.item; 
		pointerToHead = pointerToHead.next;
		N--; 
		return (dequeuedItem); 
	}
	
	
	/* method to print the Queue*/
	public void printQueue()
	{ 
		System.out.println ("Printing the queue: ");
		for (Node i = this.pointerToHead; i!= null; i=i.next)
			System.out.println (i.item); 
		System.out.println ();
			
	}
	
	
	/* to test */
	public static void main(String[] args) 
	{
		/* create testing object */
		LinkedListQueue<String> testObject = new LinkedListQueue<String> ();
		
		/* test push() */
		testObject.enqueue("hello");
		testObject.printQueue();
		testObject.enqueue("I love you");
		testObject.printQueue();
		testObject.enqueue("Won't you tell");
		testObject.printQueue();
		testObject.enqueue("me your name");
		testObject.printQueue();
		
		
		/* test isEmpty(),  size(), pop() */
		boolean bv = testObject.isEmpty();
		assert (!bv);
		
		int size = testObject.size();
		assert (size == 4);
		
		String popVal = testObject.dequeue();
		assert (popVal == "hello");
		
		popVal = testObject.dequeue();
		assert (popVal == "I love you");
		
		popVal = testObject.dequeue();
		popVal = testObject.dequeue();
		
		bv = testObject.isEmpty();
		assert (bv);
	}

}
