//Alejandro Marcovich
//Data Structures
public class BST<T>
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
		Comparable data; 
		Node right;
		Node left;
		Node(Comparable i)
		{
			size=0;
			data=i;
			right=null;
			left=null;
		}
	}
	/*
	Function finds a node with the given value in the binary search tree.
	*/
	public boolean find(Comparable x)
	{
		return find( x, head);
	}
	public boolean find(Comparable x,Node root)
	{
		if (root==null)
			return false;
		if(root.data.compareTo(x)==0)
			return true;
		if(root.data.compareTo(x)<0)
			return find(x,root.right);
		else
			return find(x,root.left);
	}
	/*This function inserts a node at a given
	*position.
	*/
	public void insert(Comparable x)
	{
		head=insert(x, head);
	}
	public Node insert(Comparable x,Node root)
	{
		// Node n=root;
		if (root==null)
		{
			return new Node(x);
		}
		if(root.data.compareTo(x)<=0)
		{
			root.right=insert(x,root.right);
			return root;
		}
		else{
			root.left=insert(x,root.left);
			return root;
		}
		/*if(root.data.compareTo(x)<=0)
		{
			root.left=insert(x,root.left);
			return root;
		}
		else
		{
			root.right=insert(x,root.right);
			return root;
		}*/
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
	public void delete(Comparable x)
	{
		head=delete( x, head);
	}
	public Node delete(Comparable x,Node root)
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
	public Comparable removesmallest(Node node)
	{
		if(node.left.left==null)
		{
			Comparable smallest=node.left.data;
			node.left=node.left.right;
			return smallest;
		}
		else
		{
			return removesmallest(node.left);
		}
	}
}