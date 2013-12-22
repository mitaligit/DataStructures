import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
// An IntTree object represents an entire binary tree of ints.
public class IntTree {
	IntTreeNode overallRoot;

	// Constructs an empty binary tree
	public IntTree() {
		overallRoot = null;
	}

	// Constructs a binary tree with the given node as its root.
	public IntTree(IntTreeNode overallRoot) {
		this.overallRoot = overallRoot;
	}

	// Prints a pre-order traversal of this tree.
	public void printPreOrder() {
		printPreOrder(overallRoot);
		System.out.println();
	}

	// Prints a pre-order traversal of the tree starting at the specified root
	private void printPreOrder(IntTreeNode root) {
		// implicit base case: do nothing if we reach a null root
		if (root != null) {
			System.out.print(root.data + " ");
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

	// Prints an in-order traversal of this tree.
	public void printInOrder() {
		printInOrder(overallRoot);
		System.out.println();
	}

	// Prints an in-order traversal of the tree starting at the specified root
	public void printInOrder(IntTreeNode root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.print(root.data + " ");
			printInOrder(root.right);
		}
	}

	// Prints a post-order traversal of this tree.
	public void printPostOrder() {
		printPostOrder(overallRoot);
		System.out.println();
	}

	// Prints a post-order traversal of the tree starting at the specified root
	public void printPostOrder(IntTreeNode root) {
		if (root != null) {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	public int size()
	{
		return size(overallRoot);
	}
	private int size(IntTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			return 1+ size(root.left) + size(root.right);
		}
	}
	public int countLeaves()
	{
		return countLeaves(overallRoot);
	}
	private int countLeaves(IntTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else if(root.left == null && root.right== null)
		{
			return 1;
		}
		else
		{
			return countLeaves(root.left) + countLeaves(root.right);
		}
	}
	public int sum()
	{
		return sum(overallRoot);
	}
	private int sum(IntTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			return root.data + sum(root.left) + sum(root.right);
		}
	}
	public int countLeftNodes()
	{
		return countLeftNodes(overallRoot);
	}
	private int countLeftNodes(IntTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else if(root.left!= null)
		{
			return 1 + countLeftNodes(root.left) + countLeftNodes(root.right);
		}
		else
		{
			return countLeftNodes(root.left) + countLeftNodes(root.right);
		}
	}
	public int depthSum()
	{
		return depthSum(overallRoot, 1);
	}
	private int depthSum(IntTreeNode root, int d)
	{
		if(root == null)
		{
			return 0;
		}
		else 
		{
			return ( root.data * d + depthSum(root.left, d +1) + depthSum(root.right , d+1));
		}
	}
	public void doublePositives()
	{
		overallRoot = doublePositives(overallRoot);
	}
	private IntTreeNode doublePositives(IntTreeNode root)
	{
		if(root != null)
		{
			if(root.data>0)
			{
			root.data = 2*root.data;
			}
			doublePositives(root.left);
			doublePositives(root.right);
			
		}
		return root;
	}
	public int numEmpty()
	{
		return numEmpty(overallRoot);
	}
	private int numEmpty(IntTreeNode root)
	{
		if(root == null)
		{
			return 1;
		}
		else if(root.left != null && root.right != null)
		{
			return 0 + numEmpty(root.left) + numEmpty(root.right);
			
		}
		else if(root.right == null && root.left != null)
		{
			return 1 + numEmpty(root.left);
		}
		else if(root.left == null && root.right != null)
		{
			return 1 + numEmpty(root.right);
		}
		else
		{
			return 2;
		}
	}
	public int height()
	{
		return height(overallRoot);
	}
	private int height(IntTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else if(root.right == null && root.left == null) 
		{
			return 1;
		}
		else
		{
			return 1+ Math.max(height(root.left), height(root.right));
		}
	}
	public boolean isFull()
	{
		return isFull(overallRoot);
	}
	private boolean isFull(IntTreeNode root)
	{
		if(root == null)
		{
			return false;
		}
		else if(root.right == null && root.left == null)
		{
			return true;
		}
		else if( root.right != null && root.left != null)
		{
			isFull(root.left);
			isFull(root.right);
			if(isFull(root.left) == true && isFull(root.right) == true)
			{
			return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	public void printLevel()
	{
		printLevel(overallRoot, 3, 1);
	}
	private void printLevel(IntTreeNode root, int lev, int dep)
	{
		if(root ==null)
		{
			System.out.print("no node");
		}
		else if(lev == 1)
			{
				System.out.print(root.data);
			}
		else if(lev == dep)
		{
			System.out.println(root.data);
		}
		else
		{
			printLevel(root.left, lev, dep+1);
			printLevel(root.right, lev, dep+1);
		}
	}
	public String toString2()
	{
		return toString2(overallRoot);
	}
	private String toString2(IntTreeNode root)
	{
		if(root == null)
		{
			return "empty";
		}
		else if(root.left== null && root.right== null)
		{
			return ( " " + root.data) ;
		}
		else
		{
			return (" " + "(" + root.data + "," + toString2(root.left) + "," + toString2(root.right) + ")");
		}
	}
	public void printLeaves()
	{
		printLeaves(overallRoot);
	}
	private void printLeaves(IntTreeNode root)
	{
		if(root == null)
		{
			System.out.print("no leaves");
		}
		else if(root.right == null && root.right == null)
		{
			System.out.println("leaf root data: " + root.data);
		}
		else
		{
			printLeaves(root.right);
			printLeaves(root.left);
		}
	}
	public int evenBranches()
	{
		return evenBranches(overallRoot);
	}
	private int evenBranches(IntTreeNode root)
	{
		if( root == null || ( root.left == null && root.right == null))
		{
			return 0;
		}
		else
		{
			//int num = root.data % 2 ;
			//return num + evenBranches(root.right) + evenBranches(root.left);
			
			if(root.data%2 == 0)
			{
			return 1 + evenBranches(root.right) + evenBranches(root.left);
			}
			else
			{
				return 0+ evenBranches(root.right) + evenBranches(root.left);
			}
		}
		
	}
	public void writeTree()
	{
		writeTree(overallRoot);
	}
	public void writeTree(IntTreeNode root)
	{
		if(root == null)
		{
			System.out.print("nothing");
		}
		else if(root.right != null && root.left != null)
		{
			System.out.println(3 + " " + root.data);
			writeTree(root.left);
			writeTree(root.right);
		}
		else if(root.right != null && root.left == null)
		{
			System.out.println(2 + " " + root.data);
			writeTree(root.left);
			writeTree(root.right);
		}
		else if(root.right == null && root.left != null)
		{
			System.out.println(1 +  " " + root.data);
			writeTree(root.left);
			writeTree(root.right);
		}
		else if(root.right == null && root.left == null)
		{
			System.out.println(0 + " " +root.data);
		}
	}
	public void readTree() throws FileNotFoundException
	{
		Scanner input = new Scanner(new File("demotre.txt"));
		overallRoot = readTree(input);
	}
	private IntTreeNode readTree(Scanner input)
	{
		
		int num1;
		int num2;
		IntTreeNode ov = new IntTreeNode(0);
		
		    num1 = input.nextInt();
		    num2 = input.nextInt();
		    
		    if(num1 == 3)
		    {
		    ov	= new IntTreeNode(num2);
		   ov.left 	= readTree(input);
		   ov.right = readTree(input);
		    	                                                                                                                                     
		    }
		    else if(num1 == 1)
		    {
		    	ov = new IntTreeNode(num2);
		    	ov.left = readTree(input);
		    }
		    else if(num1 ==2)
		    {
		    	ov = new IntTreeNode(num2);
		    	ov.right = readTree(input);
		    }
		    else
		    {
		    	ov = new IntTreeNode(num2);
		    	
		    }
		
		return ov;
	}
	
	public int numberNodes()
	{
		return numberNodes(overallRoot, 1);
	}
	private int numberNodes(IntTreeNode root, int data)
	{
		int num = data-1;
		if(root == null)
		{
			return data-1;	
		}
		else if(root != null)
		{
	
			root.data = data;
			
	num = numberNodes(root.left, data+1);
		
		num = numberNodes(root.right, num+1);
			
		}
		return num;
	}
	
	public void removeLeaves()
	{
		overallRoot = removeLeaves(overallRoot);
	}
	private IntTreeNode removeLeaves(IntTreeNode root)
	{
		if(root != null)
		{
			if(root.left==null && root.right== null)
			{
				root= null;
			}
			else{
				root.left = removeLeaves(root.left);
				root.right = removeLeaves(root.right);
			}
			
		}
		
		return root;
	}

public void tighten()
{
	overallRoot = tighten(overallRoot);
}
private IntTreeNode tighten(IntTreeNode root)
{
	if(root != null)
	{
		if(root.left==null && root.right!= null)
		{
			root= root.right;
			root = tighten(root);
		}
		else if(root.left!=null && root.right== null)
		{
			root= root.left;
			root = tighten(root);
		}
		else{
			root.left = tighten(root.left);
			root.right = tighten(root.right);
		}
		
	}
	
	return root;
}

public void completeToLevel()
{
	overallRoot = completeToLevel(overallRoot,2,1);
}
private IntTreeNode completeToLevel(IntTreeNode root, int lev, int dep)
{
	if(root != null)
	{
		if(root.left==null && root.right!= null && dep< lev)
		{
			root.left = new IntTreeNode(-1);
			
			//completeToLevel(root);
		}
		else if(root.left!=null && root.right== null && dep< lev)
		{
			root.right = new IntTreeNode(-1);
			//root = completeToLevel(root);
		}
		else{
			root.left = completeToLevel(root.left, lev, dep+1);
			root.right = completeToLevel(root.right, lev, dep+1);
		}
		
	}
	
	return root;
}

public void construct()
{
	overallRoot = construct(0, 20-1);
}
private IntTreeNode construct(int min, int max)
{
	IntTreeNode root1 = new IntTreeNode(0);
	if(max - min>1)
	{
	root1.data = (min + max)/2;
	root1.left = construct(min, root1.data -1);
	root1.right = construct(root1.data + 1, max);
	}
	
	else if(max-min ==1)
	{
		root1.data= (min + max)/2;
		root1.right = new IntTreeNode(max);
	}
	else
	{
		root1.data = min;
		root1.left = null;
		root1.right = null;
	}
	return root1;
}

public boolean isBinarySearchTree()
{
	boolean flag = isBinarySearchTree(overallRoot);
	return flag;
}

private boolean isBinarySearchTree(IntTreeNode root)
{
	if( root == null)
		return true;
	//check the left subtree
	boolean leftIsBst = false;
	if(root.left != null)
	{
		if(root.left.data < root.data)
		{
			leftIsBst = isBinarySearchTree(root.left);
		}
	}
	else // root.left is null
	{
		leftIsBst = true;
	}
	if( leftIsBst == false)
		return false;
	
	//check the right subtree
	boolean rightIsBst = false;
	if(root.right !=  null)
	{
		if(root.right.data >= root.data)
		{
			rightIsBst = isBinarySearchTree(root.right);
		}
	}
	else // root.right is not null
	{
		rightIsBst = true;
	}
	return (rightIsBst);
}
public void printlevelwise()
{
	printlevelwise(overallRoot);
}
private void printlevelwise(IntTreeNode root)
{
	Queue<IntTreeNode> q = new LinkedList<IntTreeNode>();
	q.add(root);
	int currentn = 1;
	int nextl = 0;
   while(!q.isEmpty())
   {
	   IntTreeNode n = q.remove();
	   System.out.print(n.data + " ");
	   currentn--;
	   if(n.left != null)
	   {
	   q.add(n.left);
	   nextl = nextl+1;
	   }
	   if(n.right != null)
	   {
	   q.add(n.right);
	   nextl = nextl+1;
	   }
	   
	   if(currentn ==0)
	   {
		   currentn = nextl;
		   nextl = 0;
		   System.out.println("");
	   }
   }
}

public void printspiral()
{
	printspiral(overallRoot);
}
private void printspiral(IntTreeNode root)
{
	Stack<IntTreeNode> odd = new Stack<IntTreeNode>();
	Stack<IntTreeNode> even = new Stack<IntTreeNode>();
	odd.push(root);
	while(!odd.isEmpty()|| !even.isEmpty())
	{
		while(!odd.isEmpty())
		{
			IntTreeNode n = odd.pop();
			if(n.left != null)
			{
				even.push(n.left);
			}
			if(n.right != null)
			{
				even.push(n.right);
			}
			System.out.print(n.data + " ");
		}
		System.out.println("");
		while(!even.isEmpty())
		{
			IntTreeNode n1 = even.pop();
			if(n1.right != null)
			{
				odd.push(n1.right);
			}
			if(n1.left != null)
			{
				odd.push(n1.left);
			}
			
			System.out.print(n1.data + " ");
		}
		System.out.println("");
	}

}
/*public List<IntTreeNode> traverseTreeAndReturnListContainingAllNodes()
{
	List<IntTreeNode> n1 = new ArrayList<IntTreeNode>();
	List<IntTreeNode> n = traverseTreeAndReturnListContainingAllNodes(overallRoot, n1);
	return n;
}
private List<IntTreeNode> traverseTreeAndReturnListContainingAllNodes(IntTreeNode root, List<IntTreeNode> n1)
{
	
	if(root == null){
		return null;
	}
	else
	{
		n1.add(new IntTreeNode(root.data));
		traverseTreeAndReturnListContainingAllNodes(root.left, n1);
		traverseTreeAndReturnListContainingAllNodes(root.right, n1);
	}
	return n1;
}*/
public void replace()
{
	replace(overallRoot);
}
private void replace(IntTreeNode root)
{
	Queue<IntTreeNode> q = new LinkedList<IntTreeNode>();
	q.add(root);
	int initial = root.data;
	int currentn = 1;
	int nextl = 0;
   while(!q.isEmpty())
   {
	   IntTreeNode n = q.remove();
	   
	   currentn--;
	   if(n.left != null)
	   {
	   q.add(n.left);
	   nextl = nextl+1;
	   }
	   if(n.right != null)
	   {
	   q.add(n.right);
	   nextl = nextl+1;
	   }
	   if(currentn ==0 && nextl == 0)
	   {
		   root.data = n.data;
		   n.data = initial;
		   
	   }
	 
	   if(currentn ==0)
	   {
		   currentn = nextl;
		   nextl = 0;
	   }
   }
  
}
public void negpos()
{
	 negpos(overallRoot);
}
private int negpos(IntTreeNode root)
{
	if(root == null)
	{
		return 0;
	}
	else if(root.right != null && root.left != null)
	{
		root.data = root.left.data + root.right.data + negpos(root.left) + negpos(root.right);
		return root.data;
	}
	else if(root.left != null && root.right == null)
	{
		root.data = root.left.data + negpos(root.left);
		return root.data;
	}
	else if(root.right != null && root.left == null)
	{
		root.data = root.right.data + negpos(root.right);
		return root.data;
	}
	else
	{
		root.data = 0;
		return root.data;
	}
}
public boolean isBalance()
{
	boolean b = isBalance(overallRoot);
	return b;
}
private boolean isBalance(IntTreeNode root)
{
	if(root == null)
	{
		return true;
	}
	else
	{
	int leftheight = height(root.left);
	int rightheight = height(root.right);
	if(leftheight - rightheight <-1)
	{
		return false;
	}
	if(leftheight - rightheight > 1)
	{
		return true;
	}
	boolean bl = isBalance(root.left);
	boolean br = isBalance(root.right);
	return (bl &&br);
	}
}
public void limitPathSum ()
{
	overallRoot = limitPathSum(overallRoot, 50, 0); 
}
private IntTreeNode limitPathSum(IntTreeNode root, int max, int sum)
{
	if(root != null)
	{
		sum = sum+root.data;
		if(sum > max)
		{
			root = null;
		}
		else
		{
			root.left = limitPathSum(root.left, max, sum);
			root.right = limitPathSum(root.right, max, sum);
		}
	}
	return root;
}

public List<IntTreeNode> newprintInOrder() {
	List<IntTreeNode> l = new ArrayList<IntTreeNode>();
	List<IntTreeNode> l2 = newprintInOrder(overallRoot, l);
	return l2;
}

// Prints an in-order traversal of the tree starting at the specified root
private List<IntTreeNode> newprintInOrder(IntTreeNode root, List<IntTreeNode> l) {
	
	if (root != null) {
		printInOrder(root.left);
		l.add(root);
		printInOrder(root.right);
	}
	return l;
}

public IntTreeNode minHeightTree()
{
	List<IntTreeNode> l = new ArrayList<IntTreeNode>();
	//l=newprintInOrder();
	l.add(new IntTreeNode(5));
	
	
	 
	l.add(new IntTreeNode(11));
	
	l.add(new IntTreeNode(13));
	l.add(new IntTreeNode(15));
	l.add(new IntTreeNode(17));
	
	
	IntTreeNode n = minHeightTree(l);
	return n;
}
private IntTreeNode minHeightTree(List<IntTreeNode> l)
{
	if(l.size()<1)
	{
		return null;
	}
	else if(l.size()<2)
	{
		return l.get(0);
	}
	else
	{
		int middle = l.size()/2 ;

		//make l1_left
		List<IntTreeNode> l1_left = new ArrayList<IntTreeNode>();
		for ( int i=0; i< middle ; i++) {
			l1_left.add(l.get(i));
		}
		List<IntTreeNode> l1_right = new ArrayList<IntTreeNode>();
		for ( int i=middle+1; i< l.size() ; i++) {
			l1_right.add(l.get(i));
		}

		//make right 

		IntTreeNode left = minHeightTree( l1_left);
		IntTreeNode right = minHeightTree(l1_right);

		l.get(middle).left = left;
		l.get(middle).right = right;
		return l.get(middle);
	}

}

public IntTreeNode constructRandom()
{
	int n = 6;
	IntTreeNode node = constructRandom(n, -1000, 1000);
	return node;
	
}
private IntTreeNode constructRandom(int n, int min, int max)
{
	if(n<=0)
	{
		return null;
	}
	else
	{
	IntTreeNode node = new IntTreeNode(0);
	int mid = (min+max)/2;
	node = new IntTreeNode(mid);
	node.left = constructRandom(n/2, -1000, mid-1);
	node.right = constructRandom(n/2, mid+1, 1000);
	return node;
	}
	
}

public void AlternateMirror()
{
	AlternateMirror(overallRoot, 1);
}
private void AlternateMirror(IntTreeNode root, int level)
{
	if(root == null)
	{
		return;
	}
	else if(level%2 == 0)
	{
		IntTreeNode tmp = root.right;
		root.right = root.left;
		root.left = tmp;
	}
	level++;
	AlternateMirror(root.left, level);
	AlternateMirror(root.right, level);
}

public void newAlternateMirror()
{
	newAlternateMirror(overallRoot);
}
private void newAlternateMirror(IntTreeNode root)
{
Queue<IntTreeNode> q = new LinkedList<IntTreeNode>();
q.add(root);
int currentl = 1;
int currentn = 1;
int nextl = 0;
while(!q.isEmpty())
{
   IntTreeNode n = q.remove();
   currentn--;
   if(n.left != null)
   {
   q.add(n.left);
   nextl = nextl+1;
   }
   if(n.right != null)
   {
   q.add(n.right);
   nextl = nextl+1;
   }
   if(currentl %2 == 0 && (n.left != null || n.right != null))
   {
	   IntTreeNode tmp = n.right;
	   n.right = n.left;
	   n.left = tmp;
   }
   if(currentn ==0)
   {
	   currentn = nextl;
	   nextl = 0;
	   currentl++;
   }
}
}
}