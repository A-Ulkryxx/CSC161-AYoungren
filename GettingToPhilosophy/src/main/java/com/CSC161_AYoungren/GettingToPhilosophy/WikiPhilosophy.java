package com.CSC161_AYoungren.GettingToPhilosophy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        testConjecture(destination, source, 10);
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    public static void testConjecture(String destination, String source, int limit) throws IOException 
    {
		String url = source;
			
		// download and parse the document
		Connection conn = Jsoup.connect(url);
		Document doc = conn.get();
					
		// select the content text and pull out the paragraphs.
		Element content = doc.getElementById("mw-content-text");
							
		// TODO: avoid selecting paragraphs from side-bars and box-outs		
		Elements paras = content.select("p");
		for( Element each: paras)
		{
			int netOpenP = 0;
			int netClosedP = 0;
			int parenthesis = -1;
				
			WikiNodeIterable iter = new WikiNodeIterable(each);
			for(Node node: iter)
			{
				if(node instanceof TextNode)
				{
					for(int i = 0; i < each.text().length() ;i++)
					{
						if(each.text().contains("("))
						{
							netOpenP++;
						}
						if(each.text().contains(")"))
						{
							netClosedP++;
						}
					}
					parenthesis = netOpenP - netClosedP;
				}
				
				
				String link = node.attr("href");
				
				
				if(link.equals(destination) || limit == 0)
				{
					return;
				}
				if(link != null && (!link.isEmpty()) && (parenthesis == 0))
				{
					System.out.println(link);
					link = "https://en.wikipedia.org" + link;
					testConjecture(destination, link, --limit);
				}
			}
		}
    }
}
