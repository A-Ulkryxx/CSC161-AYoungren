package com.CSC161_AYoungren.MyTreeMap.MyTreeMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Add the functionality (method)  to remove a node from a Binary Search Tree to the MyBST (TreeMap) implemented in class. 
//You will need to wait till we do the implementation in class

@SuppressWarnings("rawtypes")
public class MyTreeMap<K, V> implements Map<K, V>, 
	Iterable<com.CSC161_AYoungren.MyTreeMap.MyTreeMap.MyTreeMap.Node> 
{
	private int size = 0;
	private Node root = null;
	
	protected class Node{
		public K key;
		public V value;
		public Node left = null;
		public Node right = null;
		
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
		}
		
		Node newNode = new Node(key, value);
		if(k.compareTo(parent.key) < 0)
		{
			parent.left = newNode;
		}
		else
		{
			parent.right = newNode;
		}
		size++;
		return value;
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
		
		while(current.key != null)
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
		
		V value = null;
		if (current != null)
		{
			value = current.value;
		}
		else
		{
			return value;
		}
		
		if((current.left == null) && (current.right == null))
		{
			if(parent.left == current)
			{
				parent.left = null;
			}
			if(parent.right == current)
			{
				parent.right = null;
			}
			return value;
		}
		
		if((current.left != null) || (current.right != null))
		{
			Node nonBeing = current;
			if(parent != null && parent.right == nonBeing)
			{
				
				current = replacement(nonBeing);
				parent.right = current;
				if(nonBeing.left != null && nonBeing.left != current)
				{
					current.left = nonBeing.left;
				}
				if(nonBeing.right != null && nonBeing.right != current)
				{
					current.right = nonBeing.right;
				}
				
			}
			
			if(parent != null && parent.left == nonBeing)
			{
				
				current = replacement(nonBeing);
				parent.left = current;
				if(nonBeing.left != null)
				{
					current.left = nonBeing.left;
				}
				if(nonBeing.right != null)
				{
					current.right = nonBeing.right;
				}
			}
			if(parent == null)
			{
				current = replacement(nonBeing);
				if(nonBeing.left != null)
				{
					current.left = nonBeing.left;
				}
				if(nonBeing.right != null)
				{
					current.right = nonBeing.right;
				}
				root = current;
			}
		}

		return value;
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
		Node nonBeing = node;
		Node replacer;
		Node parent = null;
		if(node.left != null)
		{
			parent = node;
			node = node.left;
			while(node.right != null)
			{
				parent = node;
				node = node.right;
			}
			if(parent == nonBeing)
			{
				nonBeing.left = node.left;
			}
			else
			{
				parent.right = null;
			}
			replacer = node;
		}
		else
		{
			parent = node;
			node = node.right;
			while(node.left != null)
			{
				parent = node;
				node = node.left;
			}
			if(parent == nonBeing)
			{
				nonBeing.right = node.right;
			}
			else
			{
				parent.left = null;
			}
			replacer = node;
		}
		
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
