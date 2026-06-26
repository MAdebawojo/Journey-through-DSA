/**
 * Test runner class to build a sample undirected graph and display its matrix state.
 */
public class Main {
    public static void main(String args[]) {
        System.out.println("=== INITIALIZING UNDIRECTED GRAPH (4 VERTICES) ===");
        AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(4);

        System.out.println("Populating undirected edges...");
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0); // Note: This line is redundant since addEdge(0, 2) already linked them!
        g.addEdge(2, 3);

        System.out.println("\n=== ADJACENCY MATRIX REPRESENTATION ===");
        System.out.print(g.toString());
    }
}