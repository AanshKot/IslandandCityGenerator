package ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node;


import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public abstract class Node {
    //need polygon as we can get the centroid idx froom it, using the centroid idx we can create the segments of the starmao
   private Structs.Vertex centroid;
   private  int id;
   private int elevation;
   private String color;
   private String name;
   private String type;

    public Node(Structs.Vertex centroid,int id,int elevation,String color,String name,String type){
        this.id = id;
        this.centroid = centroid;
        this.elevation = elevation;
        this.color = color;
        this.name = name;
        this.type = type;
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


    public String getType(){
        return this.type;
    }

    public String getColor(){
        return this.color;
    }

    public String getName(){
        return this.name;
    }
}
