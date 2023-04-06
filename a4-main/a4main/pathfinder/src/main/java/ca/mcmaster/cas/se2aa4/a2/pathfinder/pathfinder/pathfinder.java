package ca.mcmaster.cas.se2aa4.a2.pathfinder.pathfinder;

import java.util.List;



import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.GraphADT;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.Node;

public interface pathfinder {
    public List<Node> findpath(Node start_node, Node end_node,GraphADT graph);
}
