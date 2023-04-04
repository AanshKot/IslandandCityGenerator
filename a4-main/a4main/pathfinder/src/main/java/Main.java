import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Graph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Node.Node;

public class Main {
    public static void main(String args[]) throws Exception{
    
        Graph graph = new Graph();
        Structs.Vertex vertex = Structs.Vertex.newBuilder().setX(0).setY(0).build();
        Structs.Vertex vertex1 = Structs.Vertex.newBuilder().setX(20).setY(0).build();
        graph.addNode(vertex,0, 0);
        graph.addNode(vertex1,1,0);

        List<Node> nodes = graph.getNodes();
        Node Node1 = nodes.get(0);
        Node Node2 = nodes.get(1);

        graph.addEdge(Node1,Node2);
    }
}
