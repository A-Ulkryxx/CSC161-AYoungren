package com.CSC161_AYoungren.MyTreeMap.MyTreeMap;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		Node current = root;
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
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public Iterator iterator() {
		return new inOrderIterator();
	}

	private class inOrderIterator implements Iterator<Node>
	{
		private ArrayList<Node> list = new ArrayList<>();
		private int currentIndex = 0;
		
		public inOrderIterator()
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
