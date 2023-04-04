package ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Edge;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Node.Node;

public class Edge {
    private int weight;
    private Node node1;
    private Node node2;
    //make edge take in a color

    public Edge(Node node1, Node node2){
        this.node1 = node1;
        this.node2 = node2;
        //set the weight of every edge to 1 for now change later
        this.weight = 1;
    }
    
    public int getEdgeWeight(){
        return this.weight;
    }

    public Node getNode1(){
        return this.node1;
    }

    public Node getNode2(){
        return this.node2;
    }

    public void calcWeight(){
        int dx = (int) (this.node1.getNodeCentroid().getX() - this.node2.getNodeCentroid().getX());

        int dy = (int) (this.node1.getNodeCentroid().getY() - this.node2.getNodeCentroid().getY());



        this.weight = (int) (Math.sqrt(dx * dx + dy * dy));
    }
}
