package IslandGenerator.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;



import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.Graph.GraphADT;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.Node;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.pathfinder.shortestpath;

public class UrbanismGenerator {
    // private Node central_Node;
    private List<Node> cities;
    private List<List<Node>> roads;

        public List<Node> getCities(){
            return this.cities;
        }

        
        public List<List<Node>> getRoads(){
            return this.roads;
        }

    private static void generate_nodes(List<Tile> tiles,List<Structs.Vertex> vertices,GraphADT graph){
        //all land tiles will be a node in the graph
        
        int node_idx = 0;
        for(Tile tile : tiles){
            if(tile.getType().equals("land")){
                Structs.Vertex centroid = vertices.get(tile.getPolygon().getCentroidIdx());
                int elevation = tile.getElevation();
                
                graph.addNode(centroid, node_idx, elevation,tile.getId(),false,tile.getPolygon().getCentroidIdx());
                node_idx += 1;
            }
        }
    }

    private static List<Node> generate_cities(List<Tile> tiles,int num_cities,List<Structs.Vertex> vertices,GraphADT graph){
        generate_nodes(tiles, vertices, graph);
        List<Node> nodes = graph.getNodes();

        List<Tile> landTiles = new ArrayList<>();
        for (Tile tile : tiles) {
            if (tile.getType().equals("land")) {
                landTiles.add(tile);
            }
        }

        Collections.shuffle(landTiles); 

        int cityCount = 0;

        for (Tile tile : landTiles) {
            if (cityCount < num_cities) {
                
                int tile_id = tile.getId(); // Mark the node as a city
                
                for(Node node: nodes){
                    if(node.getTileId() == tile_id){
                        node.setCity(true);
                    }
                }

                cityCount++;
            } 
        }
        
        List<Node> city_list = new ArrayList<>();

        for(Node node: nodes){
            if(node.getisCity()){
                city_list.add(node);
            }
        }

        return city_list;
    }

    
    private static List<Node> find_neighbhour_cities(Node node,List<Tile> tiles,List<Node> nodes){
        List<Node> neighbhouring_cities = new ArrayList<>();
        
        Tile city_tile = tiles.get(node.getTileId());

        Structs.Polygon curr_poly = city_tile.getPolygon();

        //polygon maps to tile based on centroid idx

        List<Integer> neighbhours = curr_poly.getNeighborIdxsList();

        for (Node nd: nodes) {
            int node_tile_id = nd.getTileId();
            if (neighbhours.contains(node_tile_id) && tiles.get(node_tile_id).getType().equals("land")) {
                neighbhouring_cities.add(nd);
            }
        }

        

        return neighbhouring_cities;
    }

    private static Node central_hub(List<Node> nodes){
        Node center = null;
        double minDistance = Double.MAX_VALUE;
        
        int center_x = 1920/2;
        int center_y = 1080/2;
    
        // loop through all nodes to find the one closest to the center
        for (Node node : nodes) {
            // calculate distance from node centroid/vertex to center point

            if(node.getisCity()){
                double node_x = node.getNodeCentroid().getX(); // replace with actual x coordinate of centroid/vertex
                double node_y = node.getNodeCentroid().getY();  // replace with actual y coordinate of centroid/vertex
                double distance = Math.sqrt(Math.pow(center_x - node_x, 2) + Math.pow(center_y - node_y, 2));
                
                // if this node is closer to the center than previous nodes, update center and minDistance
                if (distance < minDistance) {
                    center = node;
                    minDistance = distance;
                }
            }
        }
    
        return center;
    }

   private static void generate_initial_roads(GraphADT graph,List<Tile> tiles){
        //going to use breadfirst search to make sure all nodes are connected to their direct neighbhours
        Node central_node = central_hub(graph.getNodes());


        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        visited.add(central_node);
        queue.add(central_node);

        while (!queue.isEmpty()) {
            Node curr_node = queue.poll();
            List<Node> neighbors = find_neighbhour_cities(curr_node, tiles, graph.getNodes());

            for (Node neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    graph.addEdge(curr_node, neighbor);
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

   } 

   //add method to relax edges
   public void generate_star_network(List<Tile> tiles,int num_cities,List<Structs.Vertex> vertices,GraphADT graph){
        
        this.cities = generate_cities(tiles, num_cities, vertices, graph); 
        generate_initial_roads(graph, tiles);

        List<List<Node>> roads = new ArrayList<>();

        //iterate over keyset storing those is this.cities
        //iterate over valueset storing them in this.roads
        Map<Integer,List<Node>> road_map = new HashMap<>();
        Node  central_node = central_hub(graph.getNodes());

        shortestpath shortest_road = new shortestpath();

        List<Node> nodes = graph.getNodes();

        for(Node node: nodes){
        
            if(node.getisCity()){
                
                
                road_map.put(node.getNodeID(),shortest_road.findpath(central_node, node, graph));


            }
        }

        for (List<Node> path : road_map.values()) {
            roads.add(path);
        }

        this.roads = roads;

   }



}
