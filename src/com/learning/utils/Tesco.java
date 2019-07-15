package com.learning.utils;
import com.learning.utils.Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;;

public class Tesco {
	//Set<Vertex<Integer>> visited = new HashSet();
	
	int count=0;
	
	public static void main(String args[] )
	{
		int input3[][] = new int[][]{
			  { 1,2,2 },
			  { 2,3,1 },
			  { 3,4,1 },
			  { 3,5,1 },
			  {4,2,1 },
			  {4,1,4},
			  {3,1,3},
			  {1,1,3},
			  {4,6,4},
			  {6,4,5},
			};
		
		Tesco t = new Tesco();
		t.build(5, 6, input3);
		
		
	}
	
	public int build(int input1, int input2, int[][] input3) {
		
		
		//marked = new boolean[input1];
		Graph<Integer> graph = new Graph<Integer>();
		if(input3[0].length < 3)
			return 0;
		for(int i = 0; i < input3.length; ++i) {
			
			  graph.addEdge(input3[i][0] , input3[i][1],input3[i][2]);
			
		}
		Set<Vertex> visited = new HashSet<Vertex>();
		Set<Vertex> recStack = new HashSet<Vertex>();
		for(Vertex<Integer> s: graph.getAllVertex()){
			if(! visited.contains(s) && !recStack.contains(s))
				backtrack(s,visited,recStack);
		}
		System.out.println(count);
		
		return count;
			
			
	}
	
	public Vertex<Integer> backtrack(Vertex<Integer> k, Set<Vertex> visited, Set<Vertex> recStack) {
		
		List<Vertex<Integer>> vertList = k.getAdjacentVertexes();
		if(!visited.contains(k)) {
			visited.add(k);
			recStack.add(k);
			for(Vertex<Integer> v : vertList) {
				if(visited.contains(v) && recStack.contains(v)) {
					count++;
				}
				else {
					backtrack(v,visited,recStack);
				}
			}
			
		}
		recStack.remove(k);
	return null;
		
	}
	
	public class Graph<T>{

	    private List<Edge<T>> allEdges;
	    private Map<Long,Vertex<T>> allVertex;
	    boolean isDirected = false;
	    
	    public Graph(){
	        allEdges = new ArrayList<Edge<T>>();
	        allVertex = new HashMap<Long,Vertex<T>>();
	        
	    }
	    
	    public void addEdge(long id1, long id2){
	        addEdge(id1,id2,0);
	    }
	    
	    
	    public void addVertex(Vertex<T> vertex){
	        if(allVertex.containsKey(vertex.getId())){
	            return;
	        }
	        allVertex.put(vertex.getId(), vertex);
	        for(Edge<T> edge : vertex.getEdges()){
	            allEdges.add(edge);
	        }
	    }
	    
	    public Vertex<T> getVertex(long id){
	        return allVertex.get(id);
	    }
	    
	    public void addEdge(long id1,long id2, int weight){
	        Vertex<T> vertex1 = null;
	        if(allVertex.containsKey(id1)){
	            vertex1 = allVertex.get(id1);
	        }else{
	            vertex1 = new Vertex<T>(id1);
	            allVertex.put(id1, vertex1);
	        }
	        Vertex<T> vertex2 = null;
	        if(allVertex.containsKey(id2)){
	            vertex2 = allVertex.get(id2);
	        }else{
	            vertex2 = new Vertex<T>(id2);
	            allVertex.put(id2, vertex2);
	        }

	        Edge<T> edge = new Edge<T>(vertex1,vertex2,weight);
	        allEdges.add(edge);
	        vertex1.addAdjacentVertex(edge, vertex2);

	    }
	    
	    public List<Edge<T>> getAllEdges(){
	        return allEdges;
	    }
	    
	    public Collection<Vertex<T>> getAllVertex(){
	        return allVertex.values();
	    }

	}


	class Vertex<T> {
	    long id;
	    private List<Edge<T>> edges = new ArrayList<>();
	    private List<Vertex<T>> adjacentVertex = new ArrayList<>();
	    
	    Vertex(long id){
	        this.id = id;
	    }
	    
	    public long getId(){
	        return id;
	    }
	    
	    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
	        edges.add(e);
	        adjacentVertex.add(v);
	    }
	    
	    public String toString(){
	        return String.valueOf(id);
	    }
	    
	    public List<Vertex<T>> getAdjacentVertexes(){
	        return adjacentVertex;
	    }
	    
	    public List<Edge<T>> getEdges(){
	        return edges;
	    }
	    
	    public int getDegree(){
	        return edges.size();
	    }
	    
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + (int) (id ^ (id >>> 32));
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Vertex other = (Vertex) obj;
	        if (id != other.id)
	            return false;
	        return true;
	    }
	}

	class Edge<T>{
	    private Vertex<T> vertex1;
	    private Vertex<T> vertex2;
	    private int weight;
	    
	    Edge(Vertex<T> vertex1, Vertex<T> vertex2){
	        this.vertex1 = vertex1;
	        this.vertex2 = vertex2;
	    }

	    Edge(Vertex<T> vertex1, Vertex<T> vertex2,int weight){
	        this.vertex1 = vertex1;
	        this.vertex2 = vertex2;
	        this.weight = weight;
	    }
	    
	    Vertex<T> getVertex1(){
	        return vertex1;
	    }
	    
	    Vertex<T> getVertex2(){
	        return vertex2;
	    }
	    
	    int getWeight(){
	        return weight;
	    }
	    

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
	        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Edge other = (Edge) obj;
	        if (vertex1 == null) {
	            if (other.vertex1 != null)
	                return false;
	        } else if (!vertex1.equals(other.vertex1))
	            return false;
	        if (vertex2 == null) {
	            if (other.vertex2 != null)
	                return false;
	        } else if (!vertex2.equals(other.vertex2))
	            return false;
	        return true;
	    }

	   }

}
