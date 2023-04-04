package ca.mcmaster.cas.se2aa4.a2.pathfinder.pathfinder;

import java.util.List;


import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Graph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Node.Node;

public interface pathfinder {
    public List<Node> findpath(Node start_node, Node end_node,Graph graph);
}
