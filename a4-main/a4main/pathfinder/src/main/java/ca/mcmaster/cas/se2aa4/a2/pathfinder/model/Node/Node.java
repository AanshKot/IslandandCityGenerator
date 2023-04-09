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
    boolean is_city;
    private int centroid_idx;


    public Node(Structs.Vertex centroid,int id,int elevation,String name,int pop_density,int tile_id,boolean is_city,int centroid_idx){
        this.id = id;
        this.centroid = centroid;
        this.elevation = elevation;
        this.name = name;
        this.pop_density = pop_density;
        this.tile_id = tile_id;
        this.is_city = is_city;
        this.centroid_idx = centroid_idx;

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

    public int getCentroidIdx(){
        return this.centroid_idx;
    }

    public boolean getisCity(){
        return this.is_city;
    }

    public void setCity(boolean isCity){
        this.is_city = isCity;
    }
}   
