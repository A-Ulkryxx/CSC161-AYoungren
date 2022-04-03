package com.CSC161_AYoungren.MyTreeMap.MyTreeMap;

import java.util.Map;

import com.CSC161_AYoungren.MyTreeMap.MyTreeMap.MyTreeMap.Node;

public class TreeMapTest {

	public static void main(String[] args) {
		MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
		
		map.put(8, 8);
		map.put(12, 12);
		map.put(4, 4);
		map.put(14, 14);
		map.put(10, 10);
		map.put(6, 6);
		map.put(2, 2);
		map.put(1, 1);
		map.put(3, 3);
		map.put(7, 7);
		map.put(5, 5);
		map.put(11, 11);
		map.put(9, 9);
		map.put(13, 13);
		map.put(15, 15);
		
		for(Node node: map)
		{
			System.out.println(node.key.toString() + " ");
		}
		
		map.remove(3);
		
		for(Node node: map)
		{
			System.out.println(node.key.toString() + " ");
		}
	}

}
