package com.learning.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort<T> {
	
	public Stack<Vertex<T>> topSort(Graph<T> graph) {
		Stack<Vertex<T>> stk = new Stack<Vertex<T>>();
		Set<Vertex<T>> visited = new HashSet();
		
		for(Vertex<T> v1 : graph.getAllVertex()) {
			if(visited.contains(v1)){
				continue;
			}
			topSortUtil(v1, stk, visited);
			
		}
		
		return stk;
	}
	
	public void topSortUtil(Vertex<T> v,Stack<Vertex<T>> stk,Set<Vertex<T>> visited) {
		visited.add(v);
		for(Vertex<T> v1 : v.getAdjacentVertexes()) {
			if(visited.contains(v1)){
				continue;
			}
			topSortUtil(v1, stk, visited);			
		}
		stk.add(v);
	}
	
	public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        
        TopologicalSort<Integer> sort = new TopologicalSort<Integer>();
        Stack<Vertex<Integer>> result = sort.topSort(graph);
        while(!result.isEmpty()){
        	System.out.println(result.pop());
        }
 
	}
	

}
