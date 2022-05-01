package com.CSC161_AYoungren.MinHeap;

public class Entry implements Key<Entry, String> 
{
	private String key;
	private int weight;
	
	public Entry(String key, int weight) 
	{
		this.key = key;
		this.weight = weight;
	}

	@Override
	public String getKey()
	{
		return key;
	}

	@Override
	public int compareTo(Entry e) 
	{
		if(weight < e.weight)
		{
			return -1;
		}
		else if(weight> e.weight)
		{
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString()
	{
		return Integer.valueOf(weight).toString();
	}
}
