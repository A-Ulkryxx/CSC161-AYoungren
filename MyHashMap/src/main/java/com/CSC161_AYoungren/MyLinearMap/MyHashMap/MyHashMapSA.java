package com.CSC161_AYoungren.MyLinearMap.MyHashMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyHashMapSA<K, V> implements Map<K, V> {
	
	private static int INITIAL_NUM_BUCKETS = 4;
	private int size = 0;
	private final double loadFactorThreshold = 0.5;
	private LinkedList<Map.Entry<K, V>>[] buckets;
	
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
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
	}

	
	@SuppressWarnings("unchecked")
	public MyHashMapSA()
	{
		this.buckets = new LinkedList[INITIAL_NUM_BUCKETS];
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
		for(int i = 0; i < this.buckets.length; i++)
		{
			if(this.buckets[i] != null)
			{
				LinkedList<Map.Entry<K, V>> bucket = this.buckets[i];
				for(Map.Entry<K, V> entry: bucket)
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
		int bucketIndex = Math.abs(key.hashCode()) % this.buckets.length;
		LinkedList<Map.Entry<K, V>> bucket = this.buckets[bucketIndex];
		for(Map.Entry<K, V> entry : bucket)
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
		// Check if load factor has been exceeded and take action
		if(((double)(size/this.buckets.length)) >= loadFactorThreshold)
		{
			reHash();
		}
		
		int bucketIndex = Math.abs(key.hashCode()) % this.buckets.length;
		
		
		if(this.buckets[bucketIndex] == null)
		{
			this.buckets[bucketIndex] = new LinkedList<Map.Entry<K, V>>();
			this.buckets[bucketIndex].add(new Entry<K,V>(key,value));
		}
			
		for(Map.Entry<K, V> entry: buckets[bucketIndex])
		{
			if(entry.getKey().equals(key))
			{
				return entry.setValue(value);
			}
			
		}
		this.buckets[bucketIndex].add(new Entry<K,V>(key,value));
		size++;
		
		return value;
	}

		//write new method called re-hash
	@SuppressWarnings("unchecked")
	private void reHash()
	{
			//double buckets(new array then copy)-do not copy into same bucket 
		LinkedList<Map.Entry<K, V>>[] oldBuckets = this.buckets;
		this.buckets = new LinkedList[oldBuckets.length * 2];
			//call put function for new hash code
		for(int i = 0; i < oldBuckets.length; i++)
		{
			if (oldBuckets[i] != null) {
				for(Map.Entry<K, V> entry: oldBuckets[i])
				{
					put(entry.getKey(), entry.getValue());
				}
			}
		}
			//free up old array after this action
		oldBuckets = null;
	}
	
	@Override
	public V remove(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % this.buckets.length;
		LinkedList<Map.Entry<K,V>> bucket = this.buckets[bucketIndex]; //pointer, not a copy (handle)
		if(bucket != null)
		{
			for(Map.Entry<K, V> entry: bucket)
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
		for(@SuppressWarnings("unused") LinkedList<Map.Entry<K,V>> bucket : this.buckets)
		{
			bucket = null;
		}
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set keySet() {
		Set<K> set = new HashSet<K>();
		for(int i =0; i < this.buckets.length; i++)
		{
			if(this.buckets[i] != null)
			{
				LinkedList<Map.Entry<K, V>> bucket = this.buckets[i];
				for(Map.Entry<K,V> entry: bucket)
				{
					set.add(entry.getKey());
				}
			}
		}
		return set;
	}

	@Override
	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set <Map.Entry<K,V>>entrySet() {
		Set<java.util.Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		for(int i =0; i < this.buckets.length; i++)
		{
			if(this.buckets[i] != null)
			{
				LinkedList<Map.Entry<K,V>> bucket = this.buckets[i];
				for(Map.Entry<K,V> entry: bucket)
				{
					set.add(entry);
				}
			}
		}
		return set;
	}

	
}