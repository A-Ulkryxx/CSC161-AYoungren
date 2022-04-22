package com.CSC161_AYoungren.Graph;

import java.util.List;
import java.util.Vector;

public class Graph<V>
{
	protected List<V> vertices = new Vector<>();
	protected List<List<Edge>> neighbors = new Vector<>();
	
	public class Edge implements Comparable<Edge>
	{
		public int s;
		public int d;
		public double weight;
		
		public Edge(int s, int d) //for non-weighted graphs
		{
			this.s = s;
			this.d = d;
		}
		
		public Edge(int s, int d, double weight) //for weighted graphs
		{
			this.s = s;
			this.d = d;
			this.weight = weight;
		}
		
		@SuppressWarnings("unchecked")
		public boolean equals(Object edge)
		{
			return (s == ((Edge) edge).s) && (d == ((Edge) edge).d);
		}


		@Override
		public int compareTo(Graph<V>.Edge other) {
			if(this.weight < other.weight)
			{
				return -1;
			}
			else if(this.weight > other.weight)
			{
				return 1;
			}
			return 0;
		}
		
		
	}
	
	public Graph(List<V> vertices, int[][] edges)
	{
		for(V vert: vertices)
		{
			addVertex(vert);
		}
		createAdjacencyLists(edges, vertices.size());
	}
	
	public boolean addVertex(V vert)
	{
		if(!vertices.contains(vert))
		{
			vertices.add(vert);
			neighbors.add(new Vector<Edge>());
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean addEdge(Edge edge)
	{
		if(!neighbors.get(edge.s).contains(edge))
		{
			neighbors.get(edge.s).add(edge);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private void createAdjacencyLists(int[][] edges, int numVertices)
	{
		for(int i = 0; i < edges.length;i++)
		{
			addEdge(new Edge(edges[i][0], edges[i][1]));
		}
	}
	
	public void printEdges()
	{
		for(int i = 0; i < neighbors.size();i++)
		{
			System.out.println("Vertex " + i + ":");
			for(Edge e: neighbors.get(i))
			{
				System.out.print("(" + e.s + ", " + e.d + ")");
			}
			System.out.println();
		}
	}
	
	public List<V> bfs()
	{
		//TODO Breadth First
		//use a queue
	}
	
	public List<V> dfs()
	{
		//TODO Depth First
		//include an input as starting point 
		//use a stack
		//no recursion
	}
}
