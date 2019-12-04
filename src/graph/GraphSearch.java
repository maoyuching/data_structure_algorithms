package graph;

public class GraphSearch {

    public static void main(String[] args) throws InterruptedException {
        MatrixUndirectedGraph graph = new MatrixUndirectedGraph(8);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(4,7);
        graph.addEdge(1,7);

        graph.DFS();

        System.out.println(" \n BFS: ");
        graph.BFS();

    }
}
