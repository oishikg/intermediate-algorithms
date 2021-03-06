package fundamentals;

public class LinkedListStack<Item> 
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
	Node pointerToFirstNode;
	int N;
	
	/* instance methods */
	
	
	public boolean isEmpty()
	{ return (N==0);}
	
	
	public int size()
	{ return (N);}
	
	/* implementing the push function for a stack based linked list
	 * simply requires adding the new element to the front of the linked list
	 */
	public void push (Item item)
	{
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = pointerToFirstNode;
		pointerToFirstNode = newNode;
		N++;
	}
	
	/* implementing the pop function requires dereferncing the node
	 * pointed to by pointerToFirstNode */
	public Item pop ()
	{
		Item poppedItem = pointerToFirstNode.item;
		pointerToFirstNode = pointerToFirstNode.next; //shift the reference to the next node
		N--; 
		return (poppedItem);
	}
	
	
	/* method to print the Stack */
	public void printStack ()
	{
		System.out.println ("Printing the stack : ");
		for (Node i = this.pointerToFirstNode ; i!= null ; i=i.next)
			System.out.println (i.item); 
		System.out.println ();
			
	}
	/* testing code to be put here */
	public static void main (String[] args)
	{
		/* create testing object */
		LinkedListStack<Double> testObject = new LinkedListStack<Double> ();
		
		/* test push() */
		testObject.push(3.15);
		testObject.printStack();
		testObject.push(6.9);
		testObject.printStack();
		testObject.push(4.20);
		testObject.printStack();
		testObject.push(8.999);
		testObject.printStack();
		
		/* test isEmpty(),  size(), pop() */
		boolean bv = testObject.isEmpty();
		assert (!bv);
		
		int size = testObject.size();
		assert (size == 4);
		
		double popVal = testObject.pop();
		assert (popVal == 8.999);
		
		popVal = testObject.pop();
		assert (popVal == 4.20);
		
		popVal = testObject.pop();
		popVal = testObject.pop();
		
		bv = testObject.isEmpty();
		assert (bv);
	}
	
}
