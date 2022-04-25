package com.CSC161_AYoungren.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class Graph<V>
{
	    protected List<V> vertices = new ArrayList<>();
	    protected List<List<Edge>> neighbors = new ArrayList<>();

	    public class Edge implements Comparable<Edge> 
	    {
	        public int s; // source vertices
	        public int d; // destination vertices
	        public double weight; // miles, time to travel, etc...

	        public Edge(int s, int d)
	        {
	            this.s = s;
	            this.d = d;
	        }

	        public Edge(int s, int d, double weight)
	        {
	            this.s = s;
	            this.d = d;
	            this.weight = weight;
	        }

	        public boolean equals(Object edge) 
	        {
	            return s == ((Edge) edge).s && d == ((Edge) edge).d;
	        }

	        @Override
	        public int compareTo(Edge other) 
	        {
	            if (this.weight < other.weight) 
	            {
	                return -1;
	            }
	            else if (this.weight > other.weight)
	            {
	                return 1;
	            }
	            return 0;
	        }
	    }

	    public void MyGraph(List<V> vertices, int[][] edges) 
	    {
	        for (V vertex : vertices) 
	        {
	            addVertex(vertex);
	        }
	        createdAdjacencyLists(edges, vertices.size());
	    }

	    public void createdAdjacencyLists(int[][] edges, int numberOfVertices) 
	    {
	        for (int i = 0; i < edges.length; i++) 
	        {
	            addEdge(new Edge(edges[i][0], edges[i][1]));
	        }
	    }

	    public boolean addVertex(V vertex) {
	        if (!vertices.contains(vertex))
	        {
	            vertices.add(vertex);
	            neighbors.add(new ArrayList<Edge>());
	            return true;
	        }
	        else
	        {
	            return false;
	        }
	    }

	    public boolean addEdge(Edge edge) 
	    {
	        if (!neighbors.get(edge.s).contains(edge)) 
	        {
	            neighbors.get(edge.s).add(edge);
	            return true;
	        }
	        else
	        {
	            return false;
	        }
	    }

	    public void printEdges() {
	        for (int i = 0; i < neighbors.size(); i++) 
	        {
	            System.out.print("Vertex: " + i + ":");
	            for (Edge edge : neighbors.get(i))
	            {
	                System.out.print("(" + edge.s + ", " + edge.d + ")");
	            }
	            System.out.println();
	        }
	    }

	  		//use a queue
	public List<V> bfs(Integer vert)
	{
		Queue<Integer> queue = new ArrayDeque<>();
		List<Integer> print = new ArrayList<>();
		ArrayList<Boolean> visited = new ArrayList<Boolean>();
		for(int i = 0; i < vertices.size(); i++)
		{
			visited.add(false);
		}
		
		//visited.set(vert, true);
		queue.add(vert);
		visited.set(vert, true);
		
		while(!queue.isEmpty())
		{
			vert = queue.peek();
			print.add(queue.poll());
			//List<Graph<V>.Edge> neighList = neighbors.get(vert);
			for(Edge e: neighbors.get(vert))
			{
				if(visited.get(e.d) == false)
				{
					visited.set(e.d, true);
					queue.add(e.d);
				}
			}
		}
		
		return (List<V>) print;
	}
	
			//include an input as starting point 
			//use a stack
			//no recursion
	public List<V> dfs(Integer vert)
	{
		Deque<Integer> stack = new ArrayDeque<>();
		List<Integer> print = new ArrayList<>();
		ArrayList<Boolean> visited = new ArrayList<Boolean>();
		for(int i = 0; i < vertices.size(); i++)
		{
			visited.add(false);
		}
		stack.push(vert);
		
		while(!stack.isEmpty())
		{
			vert = stack.peek();
			
			if(visited.get(vert) == false)
			{
				print.add(stack.pop());
				visited.set(vert, true);
			}
			else
			{
				stack.pop();
			}
			
			List<Graph<V>.Edge> neighList = neighbors.get(vert);
			for(int i = neighList.size() - 1; i >= 0; i--)
			{
				int v = neighList.get(i).d;
				if(!visited.get(v))
				{
					stack.push(v);
				}
			}
		}
		return (List<V>) print;
	}
}
