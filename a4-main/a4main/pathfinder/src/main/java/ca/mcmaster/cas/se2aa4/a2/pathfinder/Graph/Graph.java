package ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph;

import java.util.*;

import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.calculators.NodeTypeCalculator;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.Node;



public class Graph extends GraphADT {
   
   
    // public Graph(int num_cities) {
    //     super(num_cities);
        
    // }

    //node with id 7 --> {{1,2,4} --> {Edge1,Edge2,Edge4}}
    private List<Node> Nodes = new ArrayList<>();
    private List<Edge> Edges = new ArrayList<>();
    private Map<Integer,Map<Integer,Integer>> adjacency_list = new HashMap<>();
    //graph will be represented as an adjacency list
    //tile will store 

    @Override
    public List<Node> getNodes(){
        return Nodes;
    }

    @Override
    public List<Edge> getEdges(){
        return Edges;
    }

    @Override
    public Map<Integer, Map<Integer, Integer>> getAdjacencyList() {
        return adjacency_list;
    }
    
    
    @Override
    public void addNode(Structs.Vertex centroid,int id,int elevation){
    
        Node node = NodeTypeCalculator.calculatetype(centroid, id, elevation);
        Nodes.add(node);
        Map<Integer, Integer> direct_neigh = new HashMap<>();
        adjacency_list.put(node.getNodeID(),direct_neigh);
    }

    @Override
    public void addEdge(Node node1,Node node2){
        
        if(adjacency_list.containsKey(node1.getNodeID()) && adjacency_list.containsKey(node2.getNodeID())){
            if(adjacency_list.get(node1.getNodeID()).containsKey(node2.getNodeID())){
                System.out.println("edge already exists between inputted nodes");
            }
            else{ 
                Edge edge = new Edge(node1,node2);
                edge.calcWeight();
                Edges.add(edge);
                
                Map<Integer, Integer> neighbors = adjacency_list.getOrDefault(node1.getNodeID(), new HashMap<>());
                neighbors.put(node2.getNodeID(),edge.getEdgeWeight());
                

                Map<Integer, Integer> neighbors2 = adjacency_list.getOrDefault(node2.getNodeID(), new HashMap<>());
                neighbors2.put(node1.getNodeID(),edge.getEdgeWeight());

                adjacency_list.put(node2.getNodeID(), neighbors2);


                adjacency_list.put(node1.getNodeID(), neighbors);

            }
        }

        else if(!(adjacency_list.containsKey(node1.getNodeID()) && adjacency_list.containsKey(node2.getNodeID()))){
            System.out.println("inputted Node(s) doesn't exist");
            
        }

    }

   






}
