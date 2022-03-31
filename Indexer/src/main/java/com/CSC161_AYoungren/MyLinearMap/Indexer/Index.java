package com.CSC161_AYoungren.MyLinearMap.Indexer;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jsoup.select.Elements;

public class Index {
	
	private Map<String, Set<TermCounter>> index;
	
	public Index() 
	{
		index = new HashMap<String, Set<TermCounter>>();
	}
	
	public void add(String term, TermCounter tc)
	{
		Set<TermCounter> set = index.get(term);
		
		if(set == null)
		{
			set = new HashSet<TermCounter>();
			index.put(term,  set);
		}
		
		set.add(tc);
	}
	
	public void indexPage(String url, Elements paragraphs)
	{
		TermCounter counter = new TermCounter(url);
		counter.processElements(paragraphs);
		
		for(String key: counter.getMap().keySet())
		{
			add(key, counter);
		}
	}
	
	public void printIndex()
	{
		for( String term: index.keySet())
		{
			System.out.println(term);
			
			Set<TermCounter> set = index.get(term);
			for(TermCounter tc: set)
			{
				Integer count = tc.getMap().get(term);
				System.out.println("\t" + tc.getUrl() + " " + count);
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		
		Index indexer = new Index();
		
		WikiFetcher wf = new WikiFetcher();
		Elements paragraphs = wf.fetchWikipedia(url);
		indexer.indexPage(url, paragraphs);
		indexer.printIndex();
		
		url = "https://en.wikipedia.org/wiki/Programming_language";
		paragraphs = wf.fetchWikipedia(url);
		indexer.indexPage(url, paragraphs);
		
		indexer.printIndex();
		
	}

}
