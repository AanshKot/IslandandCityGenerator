package ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.NodeTypes;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.Node;

public class City extends Node{
    //for now cities are black vertices
    public City(Vertex centroid, int id, int elevation, String name) {
        super(centroid, id, elevation, "16,16,16", name, "city");
    }

    
}
