package ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph;

import java.util.List;
import java.util.Map;

import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.Node;

public abstract class GraphADT {
    //abstract class should take in the number of cities and Graph should super(num_cities), if polygon is a land tile we will create a city there
    // int num_cities;

    // public GraphADT(int num_cities){
    //     this.num_cities = num_cities;
    // }
    public abstract List<Node> getNodes();
    public abstract List<Edge> getEdges();
    public abstract Map<Integer,Map<Integer,Integer>> getAdjacencyList();
    public abstract void addNode(Structs.Vertex centroid,int id,int elevation);
    public abstract void addEdge(Node node1,Node node2);

}
