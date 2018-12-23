package searching;

/* define the Binary Tree data structure as a public class
 * to enable access by all other classes dealing with
 * BTs  */
public class Node
{
	/* key-value pair in node; we stick to the integer 
	 * key and string value 
	 */
	public int key;
	public String value;
	/* pointers to the left and right sub-trees */
	public Node left;
	public Node right;
			
	/* constructor to instantiate a node; note that we also
	 * instantiate the left and right subtrees to allow us to 
	 * construct BTs for testing; in most cases, such as in the 
	 * creation of a node, we initialize l and r to be null 
	 */
	Node (int k, String v, Node l, Node r)
	{
		this.key = k;
		this.value = v;
		this.left = l;
		this.right = r;
	}
}


