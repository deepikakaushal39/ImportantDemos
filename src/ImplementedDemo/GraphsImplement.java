package ImplementedDemo;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphsImplement {
static class Graph{
	int V;
	LinkedList<Integer>[] lnklst;
	public Graph(int V){
		this.V=V;
		lnklst=new LinkedList[V];
		for(int i=0;i<V;i++){
			lnklst[i]=new LinkedList<>();
		}
	}
	public void AddLnkLst(Graph graph, int src, int dstn){
		lnklst[src].add(dstn);
	}
	public void PrintElements(Graph graph){
		for(int i=0;i<V; i++){
			System.out.println("Links to "+ i);
			Iterator<Integer> iterate= lnklst[i].iterator();
			while(iterate.hasNext()){
				System.out.println(iterate.next());
			}
		}
	}
	public void DFS(Graph graph, int node){
		System.out.println("DFS : " +node);
		boolean[] visited=new boolean[V];
		DFSearch(node, visited);
	}
	public void DFSearch(int node, boolean[] visited){
		System.out.println(node);
		visited[node]=true;
		Iterator<Integer> iterate= lnklst[node].iterator();
		while(iterate.hasNext()){
			int check=iterate.next();
			if(!visited[check]){
				DFSearch(check, visited);
			}
		}
	}
	public void BFS(Graph graph, int node){
		boolean[] visited=new boolean[V];
		Stack st=new Stack();
		visited[node]=true;
		System.out.println("BFS : " +node);
		st.push(node);
		while(!st.isEmpty()){
			int num=st.pop();
			Iterator<Integer> i=lnklst[num].iterator();
			while(i.hasNext()){
				int j=i.next();
				if(!visited[j]){
					st.push(j);
					System.out.println(j);
					visited[j]=true;
				}
				
			}
		}
	}
}
public static void main(String args[]){
	Graph graph=new Graph(5);
	graph.AddLnkLst(graph, 0, 1);
	graph.AddLnkLst(graph, 0, 3);
	graph.AddLnkLst(graph, 1, 2);
	graph.AddLnkLst(graph, 1, 4);
	graph.AddLnkLst(graph, 2, 3);
	graph.AddLnkLst(graph, 2, 0);
	graph.AddLnkLst(graph, 3, 4);
	graph.PrintElements(graph);
	graph.DFS(graph, 2);
	graph.DFS(graph, 1);
	graph.BFS(graph, 1);
	graph.BFS(graph, 2);
	graph.BFS(graph, 0);
}
}
