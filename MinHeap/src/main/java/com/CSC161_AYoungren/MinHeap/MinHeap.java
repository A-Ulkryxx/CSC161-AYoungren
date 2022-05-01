package com.CSC161_AYoungren.MinHeap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap <E extends Key<E, T>, T> 
{
	private List<E> heapArr;
	
	public MinHeap()
	{
		heapArr = new ArrayList<E>();
	}
	
	public boolean isEmpty()
	{
		return heapArr.size() == 0;
	}
	
	public int size()
	{
		return heapArr.size();
	}
	
	public List<E> getHeap()
	{
		return heapArr;
	}
	
	public int leftChild(int pos)
	{
		int child = (2 * pos) + 1;
		
			//if child is greater or equal to size, return -1, else return child
		return child >= heapArr.size() ? - 1 : child; 
	}
	
	public int rightChild(int pos)
	{
		int child = (2 * pos) + 2;
		
			//if child is greater or equal to size, return -1, else return child
		return child >= heapArr.size() ? - 1 : child; 
	}
	
	public int parent(int pos)
	{
		if(pos == 0)
		{
			return -1;
		}
		return (pos - 1)/2;
	}
	
	public boolean isLeafNode(int pos)
	{
		return (pos >= heapArr.size()/2) && (pos < heapArr.size());
	}
	
	public int add(E entry)
	{
		heapArr.add(entry);
		return swimUp((heapArr.size() - 1));
	}
	
	private int swimUp(int current)
	{
		int parent = parent(current);
		while((current != 0) && (heapArr.get(current).compareTo(heapArr.get(parent)) < 0))
		{
			swap(current, parent);
			current = parent;
			parent = parent(current);
		}
		return current;
	}
	
	private void swap (int pos1, int pos2)
	{
		E temp = heapArr.get(pos1);
		heapArr.set(pos1,  heapArr.get(pos2));
		heapArr.set(pos2, temp);
	}
	
	public E remove()
	{
		return remove(0);
	}
	public E remove(int pos)
	{
		swap(pos, heapArr.size() - 1);
		E removedEntry = heapArr.remove(heapArr.size() - 1);
		if(heapArr.size() > 0)
		{
			siftDown(pos);
		}
		return removedEntry;
	}
	
	private int siftDown(int current)
	{
		while(!isLeafNode(current))
		{
			int child = leftChild(current);
			int rChild = rightChild(current);
			
			E childEntry = heapArr.get(child);
			if(rChild > -1)
			{
				E rChildEntry = heapArr.get(rChild);
				if(rChildEntry.compareTo(childEntry) < 0)
				{
					childEntry = rChildEntry;
					child = rChild;
				}
			}
			
			if(heapArr.get(current).compareTo(childEntry) > 0)
			{
				swap(current, child);
				current = child;
			}
			else 
			{
				break;      
			}
		}
		return current;
	}
	
}
