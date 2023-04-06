package ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.NodeTypes;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.Node;

public class Hamlet extends Node{

    public Hamlet(Vertex centroid, int id, int elevation, String name) {
        super(centroid, id, elevation, "255,24,24", name, "hamlet");
    }
    
}
