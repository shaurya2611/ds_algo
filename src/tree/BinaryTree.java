package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	class Node{
		int data;
		Node rightNode;
		Node leftNode;
		
		Node(int data, Node rightNode , Node leftNode){
			this.data = data;
			this.rightNode = rightNode;
			this.leftNode = leftNode;
		}
	}
	
	public static class Pair{
		Node node;
		int count;
		
		Pair(Node node, int count){
			this.node = node;
			this.count = count;
		}
	}
	
	// ** Forming BInary Tree by eulers method (Using STACK and PAIR class)
	public Node eulaerTreeFormation(Integer[] arr) {
		if (arr.length==0) return null;
		
		Stack<Pair> s  =new Stack<Pair>();
		Node root = new Node(arr[0],null,null);
		s.push(new Pair(root,1));
		
		int idx = 0;
		while(s.size()>0) {
			Pair top = s.peek();
			
			if(top.count==1) { //left side can be added
				idx++;
				if(arr[idx]!=null) {
					Node n = new Node(arr[idx],null,null);
					top.node.leftNode = n;
					s.push(new Pair(n,1));
					}
				top.count+=1;
			}
			else if(top.count==2) { //right side can be added
				idx++;
				if(arr[idx]!=null) {
					Node n = new Node(arr[idx],null,null);
					top.node.rightNode = n;
					s.push(new Pair(n,1));
					}
				top.count+=1;
			}
			else if(top.count==3) { //Righ-Left filled , Nothing can be added
				s.pop();
			}	
		}
		return root;
	}
	
	
	// Display binary tree in term of left-node-right format (using RECURSION)
	public void displayTree(Node root) {
		if(root==null) return;
		
		if(root.leftNode==null) System.out.print("."+" --  ");
		else System.out.print(root.leftNode.data+" --  ");
		System.out.print(root.data +" --  ");
		if(root.rightNode==null) System.out.print(".");
		else System.out.print(root.rightNode.data);
		System.out.println();
		displayTree(root.leftNode);
		displayTree(root.rightNode);
	}
	
	
	// SUM binary tree --> sum of all nodes (using RECURSION)
	public int sumTree(Node root) {
		if (root==null) return 0;
		
		int sumLeft = sumTree(root.leftNode);
		int sumRight = sumTree(root.rightNode);
		int sumCurrent = root.data;
		
		return sumCurrent+sumLeft+sumRight;
		}
	
	
	// Height of binary Tree --> max edge distance from root (using RECURSION)
	public int heightTree(Node root) {
		if(root==null) return 0;
		
		int heightLeft = heightTree(root.leftNode);
		int heightRight = heightTree(root.rightNode);
		
		return 1 + Math.max(heightLeft, heightRight);
	}
	
	
	// Count no of nodes (using RECURSION)
	public int nodeInTree(Node root) {
		if(root==null) return 0;
		
		int nodesLeft = nodeInTree(root.leftNode);
		int nodesRight = nodeInTree(root.rightNode);
		
		return 1 + nodesLeft+ nodesRight;
	}
	
	
	// PRE-ORDER traversal --> 1st time visit node in euler or going in recursion
	public void preorderTraversal(Node root) {
		if (root==null) return;
		
		System.out.print(root.data + "  ");
		preorderTraversal(root.leftNode);
		preorderTraversal(root.rightNode);
	}
	
	
	// POST-ORDER traversal --> 3rd time visit node in euler or coming out from recursion
	public void postorderTraversal(Node root) {
		if (root==null) return;
		
		postorderTraversal(root.leftNode);
		postorderTraversal(root.rightNode);
		System.out.print(root.data + "  ");
	}
	
	
	// IN-ORDER traversal --> 2nd time visit node in euler or in between recursion
	public void inorderTraversal(Node root) {
		if (root==null) return;
			
		inorderTraversal(root.leftNode);
		System.out.print(root.data + "  ");
		inorderTraversal(root.rightNode);
	}	
	
	
	// ** Level Order Traversal height wise (Using two Queue)
	public void levelOrderTraversal(Node root) {
		if(root==null) return;
		
		Queue<Node> mainQ = new LinkedList<BinaryTree.Node>();
		mainQ.add(root);
		Queue<Node> childQ = new LinkedList<BinaryTree.Node>();
		
		while(mainQ.size() > 0) {
			Node n = mainQ.remove();
			System.out.print(n.data+"  ");
			
			if (n.leftNode!=null) childQ.add(n.leftNode);
			if (n.rightNode!=null) childQ.add(n.rightNode);
			
			if(mainQ.size()==0) {
				mainQ = childQ;
				childQ = new LinkedList<BinaryTree.Node>();
				System.out.println();
			}
		}
	}
	
	
	// ** PRE-POST-IN Traversal at a time (using ITERATION, STACK and PAIR)
	public void preInPostIterative(Node root) {
		/*
		 Pre order - element visited 1st time (If count=1,add in Post str, count++, add left in stack)
		 In order  - element visited 2nd time (If count=3,add in In str,count++, add right in stack)
		 Post order - element visited 3rd time (If count=3,add in Post str, pop current from stack)
		*/
		if(root==null) return;
		
		String pre = "";
		String in = "";
		String post = "";
		
		Stack<Pair> stack = new Stack<Pair>();
		stack.push(new Pair(root, 1));
				
		while(stack.size() > 0) {
			
			Pair current = stack.peek();
			
			if(current.count==1) {
				pre = pre + current.node.data +"  ";
				current.count++;
				if(current.node.leftNode!=null) stack.push(new Pair(current.node.leftNode,1));
				
			}else if(current.count==2) {
				in = in + current.node.data +"  ";
				current.count++;
				if(current.node.rightNode!=null) stack.push(new Pair(current.node.rightNode,1));
				
			}else {
				post = post + current.node.data +"  "; 
				stack.pop();
			}
		}
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}
	
	
	// Find Node (Using Recursion)
	public boolean findNode(Node root, int no) {
		if (root==null) return false;

		if (root.data==no) return true;// check in current node
		if (findNode(root.leftNode, no)==true) return true; // else check in left tree
		if(findNode(root.rightNode, no)==true) return true; // else check in right tree
		return false; // if still not found returm false
	}
	
	
	// ** NODE to ROOT path (Same as finding node in tree)
	static ArrayList<Node> pathNodes ;
	public boolean nodeToRootPath(Node root, int no) {
		/* It same as finding the node,just while return the true add/print the node data*/
		if (root==null) return false;

		if (root.data==no) {
			pathNodes.add(root);
			System.out.print(root.data+" ");
			return true;// check in current node
		}
		if (nodeToRootPath(root.leftNode, no)==true) {
			pathNodes.add(root);
			System.out.print(root.data+" ");
			return true; // else check in left tree
		}
		if (nodeToRootPath(root.rightNode, no)==true) {
			pathNodes.add(root);
			System.out.print(root.data+" ");
			return true; // else check in right tree
		}
		return false; // if still not found returm false
	}
	
	
	// ** Print K-LVELE DOWN (tree traversal in pre-order)
	public void printKLevelDown(Node root, int k) {
		// root node at level 0
		if(root==null || k<0) return;
		
		if(k==0) System.out.print(root.data+"  ");
		
		printKLevelDown(root.leftNode, k-1);
		printKLevelDown(root.rightNode, k-1);
	}
	
	
	
	
	// ** Print K-NODES FAR (NODE to ROOT PATH + logic of K-LEVEL DOWN)
	public void kNodeFar(Node root, int data, int k) {
		/* Find the (data)node to root path. -- it will give all the elements from data to root tree.
		   Starting from DATA find K-Level Down Elements	
		    		from Data-1 elements find K-1 level Down Elements
		    		... till the desired no k elements level req. */
		boolean flag = nodeToRootPath(root, data);
		if (flag==false) return;
		for(int i=0; i>0 && k>0; i++) {
			Node n = pathNodes.get(i);
			KLevelDownWithBlocker(n, k=k-i, i==0?null:pathNodes.get(i-1));
		}
	}
	public void KLevelDownWithBlocker(Node root, int k, Node blocker) {
		// root node at level 0
		if(root==null || k<0 || root==blocker) return;
		
		if(k==0) System.out.print(root.data+"  ");
		
		KLevelDownWithBlocker(root.leftNode, k-1,blocker);
		KLevelDownWithBlocker(root.rightNode, k-1,blocker);
	}
	
	
	
	// ** All Path from LEAF to ROOT (all paths from root to leaves applicable)
	public void leafToRootAllPath(Node root, String path){
		/*
		  exit code on base conditon
		  check current leave for leave node
		 */
		if(root==null) return;
		
		if(root.leftNode==null && root.rightNode==null) {// to find leave node
			System.out.println(path+root.data);
			return;
		}
		leafToRootAllPath(root.leftNode, path+root.data+"->");
		leafToRootAllPath(root.rightNode, path+ root.data+"->");
	}
	
	
	// Path to LEAF from ROOT with SUM
	public void leafToRootSum(Node root, String path,int sum, int low, int high){
		if(root==null) return;
		
		if(root.leftNode==null && root.rightNode==null) {// to find leave node
			sum+=root.data;
			if(sum>=low && sum<=high) System.out.println(path+root.data);
			return;
		}
		leafToRootSum(root.leftNode, path+root.data+"->",sum+root.data,low, high);
		leafToRootSum(root.rightNode, path+ root.data+"->",sum+root.data,low,high);
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,80,null,null,};
		BinaryTree bt = new BinaryTree();
		Node root = bt.eulaerTreeFormation(arr);
//		bt.displayTree(root);
//		System.out.println(bt.sumTree(root));
//		System.out.println(bt.heightTree(root));
//		System.out.println(bt.nodeInTree(root));
//		bt.preorderTraversal(root);
//		System.out.println();
//		bt.postorderTraversal(root);
//		System.out.println();
//		bt.inorderTraversal(root);
//		bt.levelOrderTraversal(root);
//		bt.preInPostIterative(root);
//		System.out.println(bt.findNode(root,880));
//		pathNodes = new ArrayList<>();
//		System.out.println(bt.nodeToRootPath(root, 70));
//		bt.printKLevelDown(root, 2);
//		bt.kNodeFar(root, 70, 2);
		bt.leafToRootAllPath(root, "");
}
	
	
	
}
