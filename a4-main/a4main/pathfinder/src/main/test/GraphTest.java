
import org.junit.jupiter.api.Test;


import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Graph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.calculators.NodeTypeCalculator;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.Node;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.NodeTypes.City;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.pathfinder.shortestpath;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class GraphTest {
    @Test 
    void testNodeTypeCalc(){
        Structs.Vertex vertex = Structs.Vertex.newBuilder().setX(0).setY(0).build();
        Node node = NodeTypeCalculator.calculatetype(vertex, 0, 120);

        boolean equals = false;

        if(node instanceof City){
            equals = true;
        }

        else{
            equals = false;
        }

        assertTrue(equals);

    }
    
    @Test 
    void testAddNode(){
        Graph g = new Graph();
        Structs.Vertex vertex = Structs.Vertex.newBuilder().setX(0).setY(0).build();
        g.addNode(vertex, 0, 0);
        List<Node> nodes = g.getNodes();
        Node node = nodes.get(0);
        Structs.Vertex vertex1 = node.getNodeCentroid();

        assertEquals(vertex1,vertex);
        
    }

    @Test
    void addEdge(){
        Graph graph = new Graph();
        Structs.Vertex vertex = Structs.Vertex.newBuilder().setX(0).setY(0).build();
        Structs.Vertex vertex1 = Structs.Vertex.newBuilder().setX(10).setY(5).build();
        Structs.Vertex vertex2 = Structs.Vertex.newBuilder().setX(10).setY(4).build();
        Structs.Vertex vertex3 = Structs.Vertex.newBuilder().setX(20).setY(0).build();
        
        graph.addNode(vertex,0, 0);
        graph.addNode(vertex1,1,101);
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

        Map<Integer,Map<Integer,Integer>> adj_list = graph.getAdjacencyList();

        Map<Integer, Map<Integer, Integer>> adjacency_list = new HashMap<Integer, Map<Integer, Integer>>() {{
            put(0, new HashMap<Integer, Integer>() {{
                put(1, 11);
                put(2, 10);
            }});
            put(1, new HashMap<Integer, Integer>() {{
                put(0, 11);
                put(3, 11);
            }});
            put(2, new HashMap<Integer, Integer>() {{
                put(0, 10);
                put(3, 10);
            }});
            put(3, new HashMap<Integer, Integer>() {{
                put(1, 11);
                put(2, 10);
            }});
        }};

        assertEquals(adj_list,adjacency_list);
    }

    @Test 
    void testShortestPath(){
        Graph graph = new Graph();
        Structs.Vertex vertex = Structs.Vertex.newBuilder().setX(0).setY(0).build();
        Structs.Vertex vertex1 = Structs.Vertex.newBuilder().setX(10).setY(5).build();
        Structs.Vertex vertex2 = Structs.Vertex.newBuilder().setX(10).setY(4).build();
        Structs.Vertex vertex3 = Structs.Vertex.newBuilder().setX(20).setY(0).build();
        
        graph.addNode(vertex,0, 0);
        graph.addNode(vertex1,1,101);
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

        List<Node> path1 = new ArrayList<>();

        path1.add(Node0);
        path1.add(Node2);
        path1.add(Node3);

        assertEquals(path,path1);
    }

    @Test 
    void testEdgeCaseShortestPath(){

        Graph graph = new Graph();
        Structs.Vertex vertex = Structs.Vertex.newBuilder().setX(0).setY(0).build();
        Structs.Vertex vertex1 = Structs.Vertex.newBuilder().setX(10).setY(5).build();
        Structs.Vertex vertex2 = Structs.Vertex.newBuilder().setX(10).setY(4).build();
        Structs.Vertex vertex3 = Structs.Vertex.newBuilder().setX(20).setY(0).build();


        graph.addNode(vertex,0, 0);
        graph.addNode(vertex1,1,101);
        graph.addNode(vertex2, 2, 0);
        graph.addNode(vertex3, 3, 0);


        List<Node> nodes = graph.getNodes();
        Node Node0 = nodes.get(0);
        Node Node1 = nodes.get(1);
        Node Node2 = nodes.get(2);
        Node Node3 = nodes.get(3);

        graph.addEdge(Node0,Node1);
        graph.addEdge(Node0,Node2);
        graph.addEdge(Node1,Node2);

        shortestpath short_calculator = new shortestpath();

        List<Node> path = short_calculator.findpath(Node0, Node3, graph);

        List<Node> path1 = new ArrayList<>();


        assertEquals(path,path1);
    }
}
