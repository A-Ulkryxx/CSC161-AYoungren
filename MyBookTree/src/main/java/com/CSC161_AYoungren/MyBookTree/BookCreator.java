package com.CSC161_AYoungren.MyBookTree;

import java.util.Iterator;

public class BookCreator {

	public static void main(String[] args) {
		
		MyBookTree myBook = new MyBookTree("Trees for Dummies");
		
		myBook.addBookNode("Chapter 1", 1, 0, 0);
		myBook.addBookNode("Chapter 1", 1, 1, 0);
		myBook.addBookNode("Chapter 1", 1, 1, 1);
		myBook.addBookNode("Chapter 1", 1, 1, 2);
		myBook.addBookNode("Chapter 1", 1, 3, 2);
		
		myBook.addBookNode("Chapter 2", 2, 0, 0);
		myBook.addBookNode("Chapter 2", 2, 1, 0);
		myBook.addBookNode("Chapter 2", 2, 1, 1);
		myBook.addBookNode("Chapter 2", 2, 1, 2);
		myBook.addBookNode("Chapter 2", 2, 4, 2);
		
		myBook.addBookNode("Chapter 3", 3, 0, 0);
		myBook.addBookNode("Chapter 3", 3, 1, 0);
		myBook.addBookNode("Chapter 3", 3, 1, 1);
		myBook.addBookNode("Chapter 3", 3, 1, 2);
		myBook.addBookNode("Chapter 3", 3, 5, 2);
		
		myBook.addBookNode("Chapter 4", 4, 0, 0);
		myBook.addBookNode("Chapter 4", 4, 1, 0);
		myBook.addBookNode("Chapter 4", 4, 1, 1);
		myBook.addBookNode("Chapter 4", 4, 1, 2);
		myBook.addBookNode("Chapter 4", 4, 6, 2);
		
		myBook.addBookNode("Chapter 5", 5, 0, 0);
		myBook.addBookNode("Chapter 5", 5, 1, 0);
		myBook.addBookNode("Chapter 5", 5, 1, 1);
		myBook.addBookNode("Chapter 5", 5, 1, 2);
		myBook.addBookNode("Chapter 5", 5, 7, 2);
		
		for (Object node : myBook)
		{
			System.out.println(node.toString());
		}
			//Same as the for loop above
		Iterator<MyBookNode> iterator = myBook.iterator();
		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}

}
