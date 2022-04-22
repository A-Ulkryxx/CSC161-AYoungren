package com.CSC161_AYoungren.MyAVLTree;

import com.CSC161_AYoungren.MyAVLTree.MyAVLTree.Node;

//Another order of keys you may try is 25, 20, 5, 34, 50, 30, 10.

public class MyAVLTreeTester {

	public static void main(String[] args) {
		MyAVLTree<Integer, Integer> map = new MyAVLTree<>();
		
		map.put(25, 25);
		printInOrder(map);
		
		map.put(20, 20);
		printInOrder(map);
		
		map.put(5, 5);		// Needs LL rotation at node 25
		printInOrder(map);
		
		System.out.println("After LL rotation at node 25");
		printBalanceFactor(map);
		
		map.put(34, 34);
		printInOrder(map);
		
		map.put(50, 50);     // Needs RR rotation at node 25 
		printInOrder(map);
		
		System.out.println("After RR rotation at node 25");
		printBalanceFactor(map);
		
		map.put(30, 30);	// Needs RL rotation at node 20
		printInOrder(map);
		
		System.out.println("After RL rotation at node 25");
		printBalanceFactor(map);
		
		map.put(10, 10);     // Needs LR rotation at node 20.
		printInOrder(map);

		System.out.println("After LR rotation at node 25");
		printBalanceFactor(map);
	}

	private static void printInOrder(MyAVLTree<Integer, Integer> map) {
		for(Node node: map) {
			System.out.print(node.key.toString() + " ");
		}
		System.out.println();
	}
	
	private static void printBalanceFactor(MyAVLTree<Integer, Integer> map) {
		int minHeight = 1;
		for(Node node: map) {
			if (node.height == 0) {
				minHeight = 0;
				break;
			}
		}
		
		System.out.println("\nNode\tHeight\tBalance Factor\tLeftChild\tRightChild");
		for(Node node: map) {
			if (minHeight == 1) {
				System.out.println(node.key.toString() + "\t" + node.height + "\t"
					+ ((node.right != null ? node.right.height : 0) 
							- (node.left != null ? node.left.height : 0)) 
								+ "\t\t" + (node.left != null ? node.left.key.toString() : "null") 
										+ "\t\t" + (node.right != null ? node.right.key.toString() : "null"));
			}
			else {
				System.out.println(node.key.toString() + "\t" + node.height + "\t"
						+ ((node.right != null ? node.right.height + 1 : 0) 
								- (node.left != null ? node.left.height + 1 : 0))
								+ "\t\t" + (node.left != null ? node.left.key.toString() : "null") 
								+ "\t\t" + (node.right != null ? node.right.key.toString() : "null"));
			}
		}
		System.out.println();
	}

}
