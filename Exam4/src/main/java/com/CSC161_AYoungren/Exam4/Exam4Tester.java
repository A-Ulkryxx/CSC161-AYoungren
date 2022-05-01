package com.CSC161_AYoungren.Exam4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

public class Exam4Tester {

	public static void main(String[] args) {
		List<Vertex> vertices = new ArrayList<Vertex>();
		
		for(int i = 0; i < 10; i++)
		{
			vertices.add(new Vertex(i));
		}

	//	int[][]edges = { {0,1}, {0,4}, {1,3}, {1,4}, {1,2}, {2,3},   {1,0}, {4,0}, {3,1}, {4,1}, {2,1}, {3,2}};
		
		int[][]edges = { {7,2},{7,1},{2,1},{2,5},{1,4},{1,5},{5,4},{5, 8},{4,8},   {2,7},{1,7},{1,2},{5,2},{4,1},{5,1},{4,5},{8,5},{8,4}};
		
		Graph<Vertex> graph1 = new Graph<Vertex>();
		
		graph1.MyGraph(vertices, edges);
		
		graph1.printEdges();
		System.out.println("*****************Spanning Tree***********************");
		
		Map<Vertex,List<Vertex>> spanningTree = graph1.findMinimumSpanningTree();
		
		Iterator iter = spanningTree.entrySet().iterator();
		while(iter.hasNext())
		{
			Map.Entry<Vertex, List<Vertex>> vertex = (Entry<Vertex, List<Vertex>>) iter.next();
			System.out.println("Vertex: " + vertex.getKey().id);
			System.out.print("Path: ");
			for(Vertex e : vertex.getValue())
			{
				System.out.print(e.id + ", ");
			}
			System.out.println("\n");
		}

	}

}
