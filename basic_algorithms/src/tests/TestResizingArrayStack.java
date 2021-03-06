package tests;
import fundamentals.ResizingArrayStack;


public class TestResizingArrayStack
{	
	/* instance variables */
	ResizingArrayStack <Integer> stack;
	
	/* instance methods */
	
	public void instantiateStack ()
	{stack = new ResizingArrayStack <Integer>(); }
	
	public void printStack ()
	{
		System.out.println("The current stack is as follows :");
		for (int val : stack)
			System.out.println(val);
		System.out.println();
	}
	
	public void testPush (int valueToPush)
	{
		this.stack.push(valueToPush);
		this.printStack ();
	}
	
	public int testPop ()
	{
		return (this.stack.pop ());  
	}
	
	public int testSize ()
	{
		return (this.stack.size());  
	}
	
	public boolean testIsEmpty()
	{
		return (this.stack.isEmpty());
	}
	
	public static void main (String args[])
	{
		/* instantiate an object of the testing class */
		TestResizingArrayStack testObject = new TestResizingArrayStack();
		
		/* invoke the testing instance methods */
		testObject.instantiateStack();
				
		/* test push() */
		testObject.testPush(3);
		testObject.testPush(4);
		testObject.testPush(36);
		testObject.testPush(89);
		
		/* test size(), pop(), isEmpty() */
		int size = testObject.testSize(); 
		assert (size == 4);
		
		boolean boolVal = testObject.testIsEmpty();
		assert (!boolVal); 
		
		int popVal = testObject.testPop();
		assert (popVal == 89);
		
		popVal = testObject.testPop();
		assert (popVal == 36);
		
		size = testObject.testSize(); 
		assert (size == 2);
		
		popVal = testObject.testPop();
		popVal = testObject.testPop();
		
		boolVal = testObject.testIsEmpty();
		assert (boolVal); 
	}
}
