package com.CSC161_AYoungren.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GraphTester {

	public static void main(String[] args) {
		List<Vertex> vertices = new ArrayList<Vertex>();
		for(int i = 0; i < 5; i++)
		{
			vertices.add(new Vertex(i));
		}

		int[][]edges = { {0,1}, {0,4}, {1,3}, {1,4}, {1,2},{2,1}, {2,3}, {3,2}, {3,1}, {3,4}, {4,3}, {4,1}, {4,0} };
		
		Graph<Vertex> graph1 = new Graph<Vertex>();
		
		graph1.MyGraph(vertices, edges);
		
		graph1.printEdges();
		System.out.println("DFS - 0:");
		System.out.println(graph1.dfs(0).toString());
		System.out.println("BFS - 0:");
		System.out.println(graph1.bfs(0).toString());
		System.out.println("DFS - 1:");
		System.out.println(graph1.dfs(1).toString());
		System.out.println("BFS - 1:");
		System.out.println(graph1.bfs(1).toString());
		System.out.println("DFS - 2:");
		System.out.println(graph1.dfs(2).toString());
		System.out.println("BFS - 2:");
		System.out.println(graph1.bfs(2).toString());
		System.out.println("DFS - 3:");
		System.out.println(graph1.dfs(3).toString());
		System.out.println("BFS - 3:");
		System.out.println(graph1.bfs(3).toString());
		System.out.println("DFS - 4:");
		System.out.println(graph1.dfs(4).toString());
		System.out.println("BFS - 4:");
		System.out.println(graph1.bfs(4).toString());
	}

}
