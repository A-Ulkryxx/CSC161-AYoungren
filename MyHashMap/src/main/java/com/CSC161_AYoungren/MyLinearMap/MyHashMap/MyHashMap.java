package com.CSC161_AYoungren.MyLinearMap.MyHashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {
	
	private final int INITIAL_NUM_BUCKETS = 4;
	private int size = 0;
	private final double loadFactorThreshold = 0.5;
	private ArrayList<LinkedList<Entry<K, V>>> buckets;
	
	public static class Entry<K, V> implements Map.Entry<K, V>
	{
		K key;
		V value;
		
		public Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}

		public K getKey()
		{
			return key;
		}

		public V getValue() 
		{
			return value;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	public MyHashMap()
	{
		buckets = new ArrayList<LinkedList<MyHashMap.Entry<K,V>>>();
		for(int i = 0; i < INITIAL_NUM_BUCKETS; i++)
		{
			buckets.add(new LinkedList<Entry<K, V>>());
		}
	}
	
	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public boolean isEmpty() 
	{
		return (size == 0);
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
		for(LinkedList<Entry<K,V>> bucket: buckets)
		{
			if(bucket != null)
			{
				for(Entry<K,V> entry: bucket)
				{
					if(entry.getValue().equals(value))
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.size();
		LinkedList<Entry<K,V>> bucket = buckets.get(bucketIndex);
		for(Entry<K,V> entry : bucket)
		{
			if(entry.getKey().equals(key))
			{
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		if((size/buckets.size()) >= loadFactorThreshold)
		{
			reHash();
		}
		int bucketIndex = Math.abs(key.hashCode()) % buckets.size();
		LinkedList<Entry<K,V>> bucket = buckets.get(bucketIndex);
		// Check if load factor has been exceeded and take action
		
		if(bucket == null)
		{
			bucket = new LinkedList<Entry<K,V>>();
			buckets.add(bucketIndex, bucket);
		}
		
		for(Entry<K,V>entry: bucket)
		{
			if(entry.getKey().equals(key))
			{
				V oldValue = entry.getValue();
				entry.value = value;
				return oldValue;
			}
		}

		bucket.add(new Entry<K,V>(key,value));
		size++;
		
		return value;
	}

		//write new method called re-hash
	@SuppressWarnings("unchecked")
	private void reHash()
	{
		int newBuckets = (buckets.size() * 2);
		
		for(int i = 0; i < newBuckets; i++)
		{
			buckets.add(new LinkedList<Entry<K, V>>());
		}
			
	}
	
	@Override
	public V remove(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.size();
		LinkedList<Entry<K,V>> bucket = buckets.get(bucketIndex); //pointer, not a copy (handle)
		if(bucket != null)
		{
			for(Entry<K,V> entry: bucket)
			{
				if(entry.getKey().equals(key))
				{
					V oldValue = entry.getValue();
					bucket.remove(entry);
					size--;
					return oldValue;
				}
			}
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) 
	{
		Set<? extends Map.Entry<? extends K,? extends V>> entries = otherMap.entrySet();
		for(Map.Entry<? extends K,? extends V> entry: entries)
		{
			put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void clear() {
		size = 0;
		for(LinkedList<Entry<K,V>> bucket : buckets)
		{
			bucket = null;
		}
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set keySet() {
		Set<K> set = new HashSet<K>();
		for(int i =0; i < buckets.size(); i++)
		{
			if(buckets.get(i) != null)
			{
				LinkedList<Entry<K,V>> bucket = buckets.get(i);
				for(Entry<K,V> entry: bucket)
				{
					set.add(entry.getKey());
				}
			}
		}
		return set;
	}

	@Override
	public Collection values() {
		
		return null;
	}

	@Override
	public Set <Map.Entry<K,V>> entrySet() {
		Set<java.util.Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		for(int i =0; i < this.buckets.size(); i++)
		{
			if(this.buckets.get(i) != null)
			{
				LinkedList<Entry<K,V>> bucket = this.buckets.get(i);
				for(Entry<K,V> entry: bucket)
				{
					set.add(entry);
				}
			}
		}
		return set;
	}

	
}
