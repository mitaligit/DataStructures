//Helene Martin, CSE 143

import java.io.FileNotFoundException;
//Creates a tree of integer and prints its elements in different orders.
import java.util.List;

public class IntTreeClient {
	public static void main(String[] args) {
		// build a tree out of nodes (use the jGRASP debugger to see its
		// structure)
		IntTreeNode root = new IntTreeNode(17);
		root.left = new IntTreeNode(41);
		root.left.left = new IntTreeNode(29);
		root.left.right = new IntTreeNode(6);
		root.right = new IntTreeNode(9);
		root.right.right = new IntTreeNode(40);
		root.right.left = new IntTreeNode(81);

		// set the tree's overall root as the root of the tree we just built
		IntTree tree = new IntTree(root);

		// use the jGRASP debugger to see the different traversal orders
		tree.printPreOrder();
		tree.printInOrder();
		tree.printPostOrder();
		System.out.println("num of nodes in tree: " + tree.size());
		System.out.println("leaf nodes: " + tree.countLeaves());
		System.out.println("sum of data: " + tree.sum());
		System.out.println("left nodes in tree: " + tree.countLeftNodes());
		System.out.println("sum of values by depth: " + tree.depthSum());
		//tree.doublePositives();
		//tree.printPreOrder();
		System.out.println("num of empty branches in tree: " + tree.numEmpty());
		System.out.println("height of tree is: " + tree.height());
		System.out.println("tree is full or not: " + tree.isFull());
		tree.printLevel();
		System.out.println("print in string: " + tree.toString2());
		tree.printLeaves();
		System.out.println("even branches: " + tree.evenBranches());
		//tree.writeTree();
		//tree.removeLeaves();
		//tree.printPreOrder();
		//tree.tighten();
		System.out.println("complete to level");
		tree.printPreOrder();
		tree.completeToLevel();
		tree.printPreOrder();
		System.out.println("complete to level finished");
		/*try {
			tree.readTree();
		} catch (FileNotFoundException e ) {
			
		}
		tree.printPreOrder();
		tree.numberNodes();
		tree.printPreOrder();*/
		tree.construct();
		tree.printlevelwise();
		System.out.println(tree.isBinarySearchTree());
		//tree.limitPathSum();
		//tree.printPreOrder();
		tree.printlevelwise();
		//tree.printspiral();
		//tree.replace();
		//tree.printlevelwise();
		/*List<IntTreeNode> n1 = tree.traverseTreeAndReturnListContainingAllNodes();
		for(int n = 0; n<n1.size(); n++)
		{
			System.out.println(n1.get(n));
		}*/
		//tree.negpos();
		//tree.printlevelwise();
		//System.out.println(tree.isBalance());
		//IntTreeNode n = tree.minHeightTree();
		//tree.printInOrder(n);
		//tree.printPostOrder(n);
		//IntTreeNode n = tree.constructRandom();
		//tree.printInOrder(n);
		tree.AlternateMirror();
		tree.printlevelwise();
		tree.newAlternateMirror();
		tree.printlevelwise();
		
		
	}
}
