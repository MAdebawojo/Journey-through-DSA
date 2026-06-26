public class AdjacencyMatrixGraph {
    private boolean adjMatrix[][];
    private int numVertices;

    public AdjacencyMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    void addEdge(int i, int j){
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    void removeEdge(int i, int j){
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    /**
     * Converts the internal 2D boolean adjacency matrix into a human-readable
     * binary grid string using 1s for edges and 0s for empty links.
     *
     * @return A formatted grid string representing the graph's structural connections.
     */
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        for(int i = 0; i < numVertices; i++){
            s.append(i + ": ");

            for(boolean j : adjMatrix[i]){
                s.append((j ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
