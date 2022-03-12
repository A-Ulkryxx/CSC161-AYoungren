package com.CSC161_AYoungren.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;


public class FileTree implements Iterable <FileNode> {

	private FileNode root;
	
	
	public FileTree(String path) {
		root = new FileNode(path);
		buildTree(root);
	}

	/**
	 * Return a depth first post-order traversal iterator 
	 */
	@Override
	public Iterator<FileNode> iterator() {

		return new DepthFirstIterator();
	}
	
	/**
	 * 	TODO for Exam 2
	 *  Use recursion to build the tree from the directory structure.
	 *  For each of node starting from the root node use listFiles() from File to get 
	 *  the list of files in that directory/folder.
	 *  Create a node for each of the files and add it to a list of child nodes for the node
	 *  Do this recursively for all the nodes.  
	 * 
	 * @param fileNode
	 */
	private void buildTree(FileNode fileNode) 
	{
		FileNode node;
		ArrayList<FileNode> fileNodeCh = new ArrayList<FileNode>();
		for (File file : fileNode.getFile().listFiles()) 
		{
			node = new FileNode(file);
			if (node.getFile().isDirectory())
			{
				buildTree(node);
			}
			fileNodeCh.add(node);
		}
		fileNode.setChildNodes(fileNodeCh);
	}
	
	/**
	 * TODO for Exam 2
	 * Iterator that does a post order traversal of the tree.
	 * For post-order traversal use the 2 stack approach outlined here: 
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 * 
	 * @return 
	 */
	private class DepthFirstIterator implements Iterator<FileNode> 
	{
		private Deque<FileNode> s1;
		private Deque<FileNode> s2;
		
		public DepthFirstIterator() 
		{
			s1 = new ArrayDeque<FileNode>();
			s2 = new ArrayDeque<FileNode>();
			s1.push(root);
		}

		@Override
		public boolean hasNext() 
		{
			if(!s1.isEmpty())
			{
				return true;
			}
			if(!s2.isEmpty())
			{
				return true;
			}
			return false;
		}
		
		@Override
		public FileNode next() 
		{
			FileNode node;
			
			while(!s1.isEmpty())
			{ 
				node = s1.pop();
				s2.push(node);
				for(FileNode temp : node.getChildNodes())
				{
					s1.push(temp);
				}
			}
			node = s2.pop();
			return node;
		}
	}
	
	/**
	 *  Returns an iterator that does a breadth first traversal of the tree using a queue.
	 * 
	 * @return
	 */
	public Iterator<FileNode> breadthFirstIterator() {
		return new BreadthFirstIterator();
	}	
	
	/** 
	 * TODO for Exam 2
	 * Iterator that does a breadth first traversal of the tree using a queue.
	 * 
	 */
	private class BreadthFirstIterator implements Iterator<FileNode> 
	{
		Queue<FileNode> queue;
		
		public BreadthFirstIterator() 
		{
			queue = new ArrayDeque<FileNode>();
			queue.add(root);
		}
		
		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		@Override
		public FileNode next() {
			FileNode node;
			while(!queue.isEmpty())
			{
				node = queue.poll();
				for(FileNode temp: node.getChildNodes())
				{
					queue.add(temp);
				}
				return node;
			}
			return null;
		}
		
	}
}
