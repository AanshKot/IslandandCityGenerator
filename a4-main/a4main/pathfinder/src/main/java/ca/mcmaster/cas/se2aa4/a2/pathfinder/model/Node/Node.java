package ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node;


import ca.mcmaster.cas.se2aa4.a2.io.Structs;

public class Node {
    //need polygon as we can get the centroid idx froom it, using the centroid idx we can create the segments of the starmao
   private Structs.Vertex centroid;
   private  int id;
   private int elevation;
   private String name;
   private int pop_density;
    private int tile_id;


    public Node(Structs.Vertex centroid,int id,int elevation,String name,int pop_density,int tile_id){
        this.id = id;
        this.centroid = centroid;
        this.elevation = elevation;
        this.name = name;
        this.pop_density = pop_density;
        this.tile_id = tile_id;

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

    public String getName(){
        return this.name;
    }

    public int getPopDensity(){
        return this.pop_density;
    }

    public int getTileId(){
        return this.tile_id;
    }
}
