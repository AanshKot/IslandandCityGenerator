
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Graph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Node.Node;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.pathfinder.shortestpath;

public class Main {
    public static void main(String args[]) throws Exception{
    
        Graph graph = new Graph();
        Structs.Vertex vertex = Structs.Vertex.newBuilder().setX(0).setY(0).build();
        Structs.Vertex vertex1 = Structs.Vertex.newBuilder().setX(10).setY(5).build();
        Structs.Vertex vertex2 = Structs.Vertex.newBuilder().setX(10).setY(4).build();
        Structs.Vertex vertex3 = Structs.Vertex.newBuilder().setX(20).setY(0).build();
        
        graph.addNode(vertex,0, 0);
        graph.addNode(vertex1,1,0);
        graph.addNode(vertex2, 2, 0);
        graph.addNode(vertex3, 3, 0);

        List<Node> nodes = graph.getNodes();
        Node Node0 = nodes.get(0);
        Node Node1 = nodes.get(1);
        Node Node2 = nodes.get(2);
        Node Node3 = nodes.get(3);
 

        graph.addEdge(Node0,Node1);
        graph.addEdge(Node0,Node2);
        graph.addEdge(Node1,Node3);
        graph.addEdge(Node2,Node3);

        shortestpath short_calculator = new shortestpath();

        List<Node> path = short_calculator.findpath(Node0, Node3, graph);

       

        if (path.isEmpty()) {
            System.out.println("No path found!");
        } else {
            System.out.println("Shortest path:");
            for (Node node : path) {
                System.out.println( ("id: " + node.getNodeID() + ")"));
            }
        }  
    }
}
