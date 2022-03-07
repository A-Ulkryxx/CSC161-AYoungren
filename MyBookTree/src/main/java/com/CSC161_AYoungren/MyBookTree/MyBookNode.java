package com.CSC161_AYoungren.MyBookTree;

import java.util.ArrayList;

public class MyBookNode implements Comparable<MyBookNode> 
{
	private String title;
	private int chapterNum;
	private int sectionNum;
	private int subSectionNum;
	private ArrayList <MyBookNode> childNodes;

	public MyBookNode(String title, int chapterNum, int sectionNum, int subSectionNum) 
	{
		super();
		this.title = title;
		this.chapterNum = chapterNum;
		this.sectionNum = sectionNum;
		this.subSectionNum = subSectionNum;
		this.childNodes = new ArrayList<MyBookNode>();
		
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public int getChapterNum() 
	{
		return chapterNum;
	}

	public void setChapterNum(int chapterNum) 
	{
		this.chapterNum = chapterNum;
	}

	public int getSectionNum() 
	{
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) 
	{
		this.sectionNum = sectionNum;
	}

	public int getSubSectionNum()
	{
		return subSectionNum;
	}

	public void setSubSectionNum(int subSectionNum) 
	{
		this.subSectionNum = subSectionNum;
	}
	
	
	public ArrayList<MyBookNode> getChildNodes() 
	{
		return childNodes;
	}

	public void setChildNodes(ArrayList<MyBookNode> childNodes) {
		this.childNodes = childNodes;
	}

	@Override
	public String toString()
	{
		if(chapterNum == 0)
		{
			return title;
		}
		if(sectionNum == 0)
		{
			return ("\t" + chapterNum + " " + title);
		}
		if(subSectionNum == 0)
		{
			return ("\t\t" + chapterNum + "." + sectionNum + " " + title);
		}
		
		return ("\t\t" + chapterNum + "." + sectionNum + "." + subSectionNum + " " + title);
	}

	@Override
	public int compareTo(MyBookNode o) {
		if(this.chapterNum > o.chapterNum)
		{
			return 1;
		}
		else if(this.chapterNum < o.chapterNum)
		{
			return -1;
		}
		else
		{
			if(this.sectionNum > o.sectionNum)
			{
				return 1;
			}
			else if(this.sectionNum < o.sectionNum)
			{
				return -1;
			}
			else
			{
				if(this.subSectionNum > o.subSectionNum)
				{
					return 1;
				}
				else if(this.subSectionNum < o.subSectionNum)
				{
					return -1;
				}
			}
		}
		return 0;
	}
}
