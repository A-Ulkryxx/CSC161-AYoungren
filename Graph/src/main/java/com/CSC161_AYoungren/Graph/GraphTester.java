package com.CSC161_AYoungren.Graph;

import java.util.List;
import java.util.Vector;

public class GraphTester {

	public static void main(String[] args) {
		List<Vertex> vertices = new Vector<>();
		for(int i = 0; i < 5; i++)
		{
			vertices.add(new Vertex(i));
		}

		int[][]edges = { {0,1}, {1,3}, {1,4}, {0,3} };
		
		Graph<Vertex> graph1 = new Graph<Vertex>(vertices, edges);
		
		graph1.printEdges();
		
		graph1.dfs(0);
	}

}
