package ca.mcmaster.cas.se2aa4.a2.pathfinder.calculators;

import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.Node;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.NodeTypes.City;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.NodeTypes.Hamlet;

public class NodeTypeCalculator {
    public static Node calculatetype(Structs.Vertex centroid, int nodeID, int elevation){
        //for now if elevation > some hardcoded value we will set the Node type to be a city, and if its under a certain value we will set the node type to a hamlet
        Node node_type;

        if(elevation > 100 ){
            node_type = new City(centroid, nodeID, elevation, "city");
        }
        else{
            node_type = new Hamlet(centroid, nodeID, elevation,"hamlet");
        }
        

        return node_type;
    }
}
