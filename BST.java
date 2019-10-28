//Alejandro Marcovich
//Data Structures
public class BST
{
	public int size;
	public Node head;
	public BST()
	{
		size=0;
		head=null;
	}
	public class Node
	{
		int data; 
		Node right;
		Node left;
		Node(int i)
		{
			size=0;
			head=null;
			data=i;
			right=null;
			left=null;
		}
	}
	/*
	Function finds a node with the given value in the binary search tree.
	*/
	public boolean find(int x)
	{
		return find( x, head);
	}
	public boolean find(int x,Node root)
	{
		if (root==null)
			return false;
		if(root.data==x)
			return true;
		if(root.data<x)
			return find(x,root.right);
		else
			return find(x,root.left);
	}
	/*This function inserts a node at a given
	*position.
	*/
	public void insert(int x)
	{
		head=insert(x, head);
	}
	public Node insert(int x,Node root)
	{
		// Node n=root;
		if (root==null)
		{
			return new Node(x);
		}
		if(x==root.data || root.data>x)
		{
			root.left=insert(x,root.left);
			return root;
		}
		else
		{
			root.right=insert(x,root.right);
			return root;
		}
	}
	/*This function prints out all the values in the node
	*going from least to greatest value.
	*/
	public void print()
	{
		print(head);
	}
	public void print(Node root)
	{
		if (root!=null)
		{
			print(root.left);
			System.out.println(root.data);
			print(root.right);
		}
	}
	/* Deletes the node at a given position.
	*/
	public void delete(int x)
	{
		head=delete( x, head);
	}
	public Node delete(int x,Node root)
	{
		if (root == null)
			return null;
		if(root.data==x)
		{
			if(root.left==null)
				return root.right;
			else if (root.right==null)
				return root.left;
			else
			{
				if (root.right.left==null)
				{
					root.data=root.right.data;
					root.right = root.right.right;
					return root;
				}
				else
				{
					root.data=removesmallest(root.right);
					return root;
				}
			}
		}
		else if(x!=root.data)
		{
			root.left=delete(x,root.left);
			return root;
		}
		else
		{
			root.right=delete(x,root.right);
			return root;
		}
	}
	/*Function finds the smallest value 
	*between two children.
	*/
	public int removesmallest(Node node)
	{
		if(node.left.left==null)
		{
			int smallest=node.left.data;
			node.left=node.left.right;
			return smallest;
		}
		else
		{
			return removesmallest(node.left);
		}
	}
}