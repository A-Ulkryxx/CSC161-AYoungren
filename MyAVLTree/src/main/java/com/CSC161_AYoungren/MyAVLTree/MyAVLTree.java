


package com.CSC161_AYoungren.MyAVLTree;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Add the functionality (method)  to remove a node from a Binary Search Tree to the MyBST (TreeMap) implemented in class. 
//You will need to wait till we do the implementation in class

@SuppressWarnings("rawtypes")
public class MyAVLTree<K, V> implements Map<K, V>, 
	Iterable<com.CSC161_AYoungren.MyAVLTree.MyAVLTree.Node> 
{
	private int size = 0;
	private Node root = null;
	private ArrayList<Node> path;
	
	protected class Node{
		public K key;
		public V value;
		public Node left = null;
		public Node right = null;
		public int height;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	@Override
	public boolean containsKey(Object key) {
		if(get(key) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		Node current = root;
		@SuppressWarnings("unchecked")
		Comparable<? super V> v = (Comparable<? super V>) value;
		while(current != null)
		{
			if(v.compareTo(current.value) < 0)
			{
				current = current.left;
			}
			else if( v.compareTo(current.value) > 0)
			{
				current = current.right;
			}
			else
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public V get(Object key) {
		Node current = root;
		@SuppressWarnings("unchecked")
		Comparable<? super K> k = (Comparable<? super K>) key;
		
		while(current != null)
		{
			if(k.compareTo(current.key) < 0)
			{
				current = current.left;
			}
			else if( k.compareTo(current.key) > 0)
			{
				current = current.right;
			}
			else
			{
				return current.value;
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		
		if(root == null) {
			Node newNode = new Node(key, value);
			root = newNode;
			path = new ArrayList<>();
			path.add(root);
			size++;
			return value;
		}
		
		Node parent = null;
		Node current = root;
		
		@SuppressWarnings("unchecked")
		Comparable<? super K> k = (Comparable<? super K>) key;
		while(current != null)
		{
			if(k.compareTo(current.key) < 0)
			{
				parent = current;
				current = current.left;
			}
			else if(k.compareTo(current.key) > 0)
			{
				parent = current;
				current = current.right;
			}
			else {
				return null;
			}
			path.add(parent);
		}
		
		Node newNode = new Node(key, value);
		if(k.compareTo(parent.key) < 0)
		{
			parent.left = newNode;
		}
		else
		{
			parent.right = newNode;;
		}
		path.add(newNode);
		for(Node node: path)
		{
			updateHeight(node);
		}
		balancePath();
		size++;
		return value;
	}

	private void updateHeight(Node node)
	{
		if(node.left == null && node.right == null)
		{
			node.height = 0;
		}
		else if (node.left == null && node.right != null)
		{
			node.height = 1 + node.right.height;
		}
		else if (node.right == null && node.left != null)
		{
			node.height = 1 + node.left.height;
		}
		else {
			node.height = 1 + Math.max(node.left.height, node.right.height);
		}
	}
	
	private int balanceFactor(Node current)
	{
		int balanceFactor = 0;
		if(current.right == null)
		{
			balanceFactor = -current.height;
		}
		else if (current.left == null)
		{
			balanceFactor = current.height;
		}
		else
		{
			balanceFactor = current.right.height - current.left.height;
		}
		return balanceFactor;
	}
	
	@SuppressWarnings("unused")
	private void balancePath() {
		for(int i = path.size() - 1; i >= 0;i--)
		{
			Node current = path.get(i);
			Node parent = null;
			
			if(i != 0)
			{
				parent = path.get(i - 1);
			}
			switch (balanceFactor(current))
			{
			case -2:
				if(balanceFactor(current.left) <= 0)
				{
					balanceLL(current, parent);
				}
				else
				{
					balanceLR(current, parent);
				}
				break;
			case 2:
				if(balanceFactor(current.right) >= 0)
				{
					balanceRR(current, parent);
				}
				else
				{
					balanceRL(current, parent);
				}
				break;
			}
		}	
	}
	
	private void balanceLL(Node node, Node parent)
	{
		Node node1 = node.left;
		if(node == root) {
			root = node1;
		}
		else {
			if(parent.left == node)
			{
				parent.left = node1;
			}
			else
			{
				parent.right = node1;
			}
		}
		node.left = node1.right;
		node1.right = node;
		updateHeight(node1);
		updateHeight(node);
		updateHeight(parent);
		
	}
	
	private void balanceLR(Node node, Node parent)
	{
		Node node1 = node.left;
		Node node2 = node1.right;
		
		if(node == root)
		{
			root = node2;
		}
		else
		{
			if(parent.left == node)
			{
				parent.left = node2;
			}
			else
			{
				parent.right = node2;
			}
			node.left = node2.right;
			node1.right = node2.left;
			node2.left = node1;
			node2.right = node;
			
			updateHeight(node);
			updateHeight(node1);
			updateHeight(node2);
			updateHeight(parent);
		}
	}
	
	private void balanceRR(Node node, Node parent)
	{
		Node node1 = node.right;
		if(node == root) {
			root = node1;
		}
		else {
			if(parent.right == node)
			{
				parent.right = node1;
			}
			else
			{
				parent.left = node1;
			}
		}
		node.right = node1.left;
		node1.left = node;
		updateHeight(node);
		updateHeight(node1);
		updateHeight(parent);
	}
	
	private void balanceRL(Node node, Node parent)
	{
		Node node1 = node.right;
		Node node2 = node1.left;
		
		if(node == root)
		{
			root = node2;
		}
		else
		{
			if(parent.right == node)
			{
				parent.right = node2;
			}
			else
			{
				parent.left = node2;
			}
			node.right = node2.left;
			node1.left = node2.right;
			node2.right = node1;
			node2.left = node;
			
			updateHeight(node);
			updateHeight(node1);
			updateHeight(node2);
			updateHeight(parent);
		}
	}
	
	@Override
	public V remove(Object key) {
		if(root == null)
		{
			return null;
		}
		Node parent = null;
		Node current = root;
		@SuppressWarnings("unchecked")
		Comparable<? super K> k = (Comparable<? super K>) key;
		
		while(current != null)
		{
			if(k.compareTo(current.key) < 0)
			{
				parent = current;
				current = current.left;
			}
			else if( k.compareTo(current.key) > 0)
			{
				parent = current;
				current = current.right;
			}
			else
			{
				break;
			}
		}
		V value;
		if((current.left == null) && (current.right == null))
		{
			value = current.value;
			path.remove(current);
			current = null;
			size--;
			balancePath();
			return value;
		}
		if((current.left != null) || (current.right != null))
		{
			Node nonBeing = current;
			
			if(parent.right == nonBeing)
			{
				current = replacement(nonBeing);
				current.left = nonBeing.left;
				current.right = nonBeing.right;
				parent.right = current;
				value = nonBeing.value;
				path.remove(nonBeing);
				size--;
				balancePath();
				return value;
			}
			if(parent.left == nonBeing)
			{
				parent.right = current;
				current = replacement(nonBeing);
				current.left = nonBeing.left;
				current.right = nonBeing.right;
				value = nonBeing.value;
				path.remove(nonBeing);
				size--;
				balancePath();
				return value;
			}
			
		}
		return null;
	}
	/**
	 * A method that takes a node and iterates through its children to find best suitable replacement.
	 * If a left branch exists, it will find the highest valued node key in that path(priority path)
	 * @author Austin Youngren
	 * @param node - a node intended for removal: 
	 * @return replacer - returns a replacement node of closest key value of sent node
	 */
	private Node replacement(Node node)
	{
		Node replacer;
		Node parent = null;
		if(node.left != null)
		{
			node = node.left;
			while(node.right != null)
			{
				parent = node;
				node = node.right;
			}
			parent.right = null;
		}
		else if(node.right != null)
		{
			node = node.right;
			while(node.left != null)
			{
				parent = node;
				node = node.left;
			}
			parent.left = null;
		}
		replacer = node;
		size--;
		balancePath();
		return replacer;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator iterator() {
		return new InOrderIterator();
	}

	private class InOrderIterator implements Iterator<Node>
	{
		private ArrayList<Node> list = new ArrayList<>();
		private int currentIndex = 0;
		
		public InOrderIterator()
		{
			inOrder(root);
		}
		
		private void inOrder(Node node)
		{
			if(node == null)
			{
				return;
			}
			inOrder(node.left);
			list.add(node);
			inOrder(node.right);
		}
		
		@Override
		public boolean hasNext() {
			
			return (currentIndex < list.size());
		}

		@Override
		public Node next() {
			return list.get(currentIndex++);
		}
	}
}