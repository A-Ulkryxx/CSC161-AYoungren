package com.CSC161_AYoungren.MyBookTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class MyBookTree implements Iterable<MyBookNode>{
	private MyBookNode root;
	
	public MyBookTree(String title)
	{
		root = new MyBookNode(title, 0, 0, 0);
	}
	
	public boolean addBookNode(String title, int chapterNum, int sectionNum, int subSectionNum)
	{
		MyBookNode node = new MyBookNode(title, chapterNum, sectionNum, subSectionNum);
		
		if (sectionNum == 0)
		{
			root.getChildNodes().add(node);
			Collections.sort(root.getChildNodes());
			return true;
		}
		
		if(subSectionNum == 0)
		{
			for(MyBookNode aNode: root.getChildNodes())
			{
				if(chapterNum == aNode.getChapterNum())
				{
					aNode.getChildNodes().add(node);
					return true;
				}
			}
		}
		
		MyBookNode chapterNode = null;
		for(MyBookNode chNode: root.getChildNodes())
		{
			if(chapterNum == chNode.getChapterNum())
			{
				chapterNode = chNode;
				break;
			}
		}
		
		for(MyBookNode sectNode: chapterNode.getChildNodes())
		{
			if(chapterNum == sectNode.getSectionNum())
			{
				sectNode.getChildNodes().add(node);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Iterator<MyBookNode> iterator()
	{
		return new BookNodeIterator(root);
	}
	
	private class BookNodeIterator implements Iterator<MyBookNode>
	{
		Deque<MyBookNode> stack;

		public BookNodeIterator(MyBookNode node) 
		{
			stack = new ArrayDeque<MyBookNode>();
			stack.push(root);
		}

		@Override
		public boolean hasNext()
		{
			return !stack.isEmpty();
		}
		
		@Override
		public MyBookNode next()
		{
			MyBookNode node = stack.pop();
			
			List<MyBookNode> nodes = new ArrayList<MyBookNode>(node.getChildNodes());
			Collections.reverse(nodes);
			for(MyBookNode child: nodes)
			{
				stack.push(child);
			}
			return node;
		}
	}
}
