package ca.mcmaster.cas.se2aa4.a2.pathfinder.pathfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Graph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.Node.Node;

public class shortestpath implements pathfinder{

    @Override
    public List<Node> findpath(Node start_node, Node end_node, Graph graph) {
        List<Node> nodes = graph.getNodes();
        Map<Integer, Map<Integer, Integer>> adj_list = graph.getAdjacencyList();
       
        List<Node> path = new ArrayList<>();

        int[] distance = new int[nodes.size()];
        boolean[] visited = new boolean[nodes.size()];
        
        Arrays.fill(distance,Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        distance[start_node.getNodeID()] = 0;
        // visited[start_node.getNodeID()] = true;

        Node[] predecessor = new Node[nodes.size()];
        Arrays.fill(predecessor,null);

        //lambda relation
        //compares two Node objects n1 and n2 based on their distance values. Specifically, it returns the difference between the distance values of n1 and n2
        //By comparing Node objects based on their distance values, the PriorityQueue ensures that the node with the smallest distance value is always at the front of the queue
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> distance[n1.getNodeID()] - distance[n2.getNodeID()]);
        pq.add(start_node);
    
        while (!pq.isEmpty()) {
            //selects the node with the smallest distance from the start node
            Node currNode = pq.poll();
            int currNodeId = currNode.getNodeID();
    
            if (visited[currNodeId]) {
                continue;
            }
    
            visited[currNodeId] = true;
    
            if (currNode.equals(end_node)) {
                // We have found the shortest path from start_node to end_node
                // Construct the path in reverse order by following the predecessor links
                int nodeId = currNodeId;
                while (nodeId != start_node.getNodeID()) {
                    Node node = nodes.get(nodeId);
                    path.add(node);
                    nodeId = predecessor[nodeId].getNodeID();
                }
                path.add(start_node);
                Collections.reverse(path);

                return path;
            }
            
            //if the current node has no neighbhours jump to the next iteration of the while loop
            Map<Integer, Integer> neighbors = adj_list.get(currNodeId);
            if (neighbors == null) {
                continue;
            }
            
            //iterate over neighbhours
            for (int neighborId : neighbors.keySet()) {
                int neighborDist = neighbors.get(neighborId);
                // apply relaxation
                int altDist = distance[currNodeId] + neighborDist;

                // if the distance[neighbhourID], meaning the distance of the node in the path is greater than the distance of the summation of edges from the start_node to the arbitrary node, we apply relaxation
                if (altDist < distance[neighborId]) {
                    distance[neighborId] = altDist;
                    predecessor[neighborId] = nodes.get(currNodeId);
                    Node neighborNode = nodes.get(neighborId);
                    pq.add(neighborNode);
                }
            }
        }
    
        // If we get here, we have not found a path from start_node to end_node
        // Return an empty path
        return path;
    }
    
}
