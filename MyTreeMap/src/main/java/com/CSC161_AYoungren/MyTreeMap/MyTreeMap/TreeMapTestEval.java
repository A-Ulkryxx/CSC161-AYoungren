package com.CSC161_AYoungren.MyTreeMap.MyTreeMap;

import com.CSC161_AYoungren.MyTreeMap.MyTreeMap.MyTreeMap.Node;

public class TreeMapTestEval {

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

		printInOrder(map);
		
		map.remove(5);

		printInOrder(map);
		
		map.remove(6);

		printInOrder(map);
		
		map.remove(3);

		printInOrder(map);
		
		map.remove(4);

		printInOrder(map);
		
		map.remove(8);
		
		printInOrder(map);
		
	}

	private static void printInOrder(MyTreeMap<Integer, Integer> map) {
		for(Node node: map) {
			System.out.print(node.key.toString() + " ");
		}
		System.out.println();
	}
}
