package tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Trees are DS used to store data in Non linear (hirarichal order)

// 1. Genric Tress : Data and any no of childeren 
public class GenericTres {

	private class Node{
		int data;
		ArrayList<Node> childNode = new ArrayList<>();
		
		public Node(int data) {
			this.data = data;
		}
	
	}
	
	// Euler tree addition method (Using STACK)
	public Node eulerAddition(int[] arr) {
		if(arr.length==0)
			return null;
		else {
			Node root = new Node(arr[0]);
			Stack<Node> st = new Stack<>();
			st.add(root);
			
			for(int i=1;i<arr.length;i++) {
				if(arr[i]!=-1) { 
					Node n = new Node(arr[i]);
					Node parent = st.peek();
					parent.childNode.add(n);
					st.push(n);
				}else st.pop();
			}
		return root;
		}
	}

	
	// Level Order tree Traversal (Using ONE QUEUE)
	public void levelTreeTraversal(Node root) {
		Queue<Node> nq = new LinkedList<GenericTres.Node>();
		nq.add(root);
		while(nq.size()!=0) {
			System.out.print(nq.peek().data+" --> ");
			for(Node n : nq.peek().childNode)
				System.out.print(n.data+ "  ");
			System.out.println();
			nq.addAll(nq.peek().childNode);
			nq.remove();
		}
	}
	
	// Level Order linewise Generic Tree traversla (using TWO QUEUE)
	public void levelLineTreeTraversal(Node root) {
			
			Queue<Node> mq = new LinkedList<GenericTres.Node>();
			mq.add(root);
			Queue<Node> cq = new LinkedList<GenericTres.Node>();
			while(mq.size()!=0) {
				Node n = mq.remove();
				System.out.print(n.data+" ");
				
				for(Node cn: n.childNode)
					cq.add(cn);
				
				if(mq.size()==0) {
					mq = cq;
					cq = new LinkedList<GenericTres.Node>();
					System.out.println();
				}
			}
		}
			
	// Level Order Zig-Zag Tree Traversal (Using TWO STACK)
	public void levelZigZagTraversal(Node root) {
		Stack<Node> mstack = new Stack<GenericTres.Node>();
		mstack.push(root);
		Stack<Node> cstack = new Stack<GenericTres.Node>();
		int flag = 1;
		while(mstack.size()>0) {
			Node n  = mstack.pop();
			System.out.print(n.data+"  ");
			
			if(flag%2!=0) {  //flag odd add in normal way
				for(Node cn : n.childNode) 
					cstack.push(cn);
			}
			else {    // flag even add rever order
				for(int i=n.childNode.size()-1; i>=0; i--) {
					cstack.push(n.childNode.get(i));
				}	
			}
			
			if(mstack.size()==0) {
				mstack = cstack;
				cstack = new Stack<GenericTres.Node>();
				flag++;
				System.out.println();
			}
		}
	}
	
	
	
	// Using RECURSION printing Generic Trees
	public void recursiveTreeDisplay(Node root) {
		//Base Condition
		if(root==null) return;
		//Induction
		System.out.print(root.data + " --> ");
		for(Node n : root.childNode)
			System.out.print(n.data + ", ");
		System.out.println();
		//Hypothesis
		for(Node n : root.childNode)
			recursiveTreeDisplay(n);
	}
	
	// Finding No of nodes of tree
	public int sizeGenericTree(Node root) {
		if(root==null) return 0;
		
		int size = 1;		
		for(Node n : root.childNode)
			size = size +  sizeGenericTree(n);
		return size;
	}
	
	// Maximum Node in generic tree
	public int maximumNo(Node root) {
		int max = Integer.MIN_VALUE;
		
		for(Node n : root.childNode) {
			max = Math.max(max, maximumNo(n));
		}
		
		return Math.max(max, root.data);
	}
	
	//Height of tree
	public int heightTree(Node root) {
		if(root==null) return 0;
		
		int h = 0;
		for(Node n: root.childNode) {
			h = Math.max(h, heightTree(n));
		}
		h+=1;
		return h;
	}
	
	/*   Pre-Post Traversal in generic tree : 
	  
	  1. Pre-Order :    In eulers path Node's left side
	  					Before going deep in recursion
	  					Node > Child, root is visited first
	  					Node's pre area (before recursion code)
	 
	  2. Post-Order :   In eulers path Node's right side
	   					After coming out of recursion recursion
	  	 				Node < Child, root is visited last	
	  	 				Node' post area (after recursion code) 
	 */
	public void treeTraversal(Node root) {
		if (root==null) return;
		
		System.out.println("Node Pre : "+root.data);
		for(Node n: root.childNode) {
			System.out.println("Edge Pre : "+root.data+" ---- "+n.data);
			treeTraversal(n);
			System.out.println("Edge Post : "+root.data+" ---- "+n.data);}
		System.out.println("Node Post : "+root.data);
	}
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,77,-1,-1,-1};
		GenericTres gt = new GenericTres();
		Node root = gt.eulerAddition(arr);
//		gt.recursiveTreeDisplay(gt.eulerAddition(arr));
//		System.out.println(gt.sizeGenericTree(gt.eulerAddition(arr)));
//		System.out.println(gt.heightTree(gt.eulerAddition(arr)));
//		gt.treeTraversal(gt.eulerAddition(arr));
//		gt.levelLineTreeTraversal(root);
//		gt.levelZigZagTraversal(root);
//		gt.levelTreeTraversal(root);
		gt.levelLineTreeTraversal(root);
		
		

	}
	
}



