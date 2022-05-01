package com.CSC161_AYoungren.MinHeap;

public interface Key<E, T> extends Comparable<E>
{
	T getKey();
	int compareTo(E e);
}
