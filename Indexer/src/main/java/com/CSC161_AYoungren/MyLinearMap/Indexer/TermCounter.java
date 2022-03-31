package com.CSC161_AYoungren.MyLinearMap.Indexer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class TermCounter {
	private Map<String, Integer> map;
	private String url;
	
	public TermCounter(String url)
	{
		this.url = url;
		this.map = new HashMap<String, Integer>();
	}
	
	public String getUrl()
	{
		return this.url;
	}
	
	public Map<String, Integer> getMap()
	{
		return this.map;
	}
	
	public void processElements(Elements paragraphs)
	{
		for(Node node: paragraphs)
		{
			processTree(node);
		}
	}
	
	public void processTree(Node root)
	{
		for(Node node: new WikiNodeIterable(root))
		{
			if(node instanceof TextNode)
			{
				processText(((TextNode) node).text());
			}
		}
	}
	
	public void processText(String text)
	{
		String[] array = text.replaceAll("\\pP", " ").toLowerCase().split("\\s+");
		for(int i = 0; i < array.length; i++)
		{
			String term = array[i];
			int count = 1;
			Integer currentCnt = map.get(term);
			if (currentCnt != null)
			{
				count = currentCnt.intValue() + 1;
			}
			map.put(term, count);
		}
	}
	
	public void printCounts()
	{
		for(String key: map.keySet())
		{
			Integer count = map.get(key);
			System.out.println(key + ": " + count);
		}
	}
	
	public static void main(String [] args) throws IOException
	{
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		
		WikiFetcher wf = new WikiFetcher();
		Elements paragraphs = wf.fetchWikipedia(url);
		
		TermCounter counter = new TermCounter(url);
		counter.processElements(paragraphs);
		counter.printCounts();
	}
}
