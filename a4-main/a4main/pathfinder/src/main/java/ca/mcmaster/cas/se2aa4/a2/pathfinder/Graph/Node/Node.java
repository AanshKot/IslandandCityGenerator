package ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Node;


import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public class Node {
    //need polygon as we can get the centroid idx froom it, using the centroid idx we can create the segments of the starmao
   private Structs.Vertex centroid;
   private  int id;
   private int elevation;
   

    public Node(Structs.Vertex centroid,int id,int elevation){
        this.id = id;
        this.centroid = centroid;
        this.elevation = elevation;
    }


    public int getNodeID(){
        return this.id;
    }

  
    public Structs.Vertex getNodeCentroid(){
        return this.centroid;
    }

    public int getNodeElevation(){
        return this.elevation;
    }

}
