package IslandGenerator.model.MapTypes.MapTypes;



import IslandGenerator.model.MapTypes.Map;

import java.util.List;

import IslandGenerator.model.Island;
import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh.Builder;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.Node;


public class DefaultMap extends Map{

    @Override
    public Builder generate_mesh(Island island) {
        

        Structs.Mesh islandMesh = island.getMesh();
        Structs.Mesh.Builder mesh = Structs.Mesh.newBuilder();
        //need to come up with a way to edit each city's color 
        
        mesh.addAllVertices(islandMesh.getVerticesList());

        List<Structs.Vertex> island_vertices = islandMesh.getVerticesList();
        String city_color = "128,0,0";
        Structs.Property color_property = Structs.Property.newBuilder().setKey("rgb_color").setValue(city_color).build(); 
        for(Node city: island.getCities()){
            Structs.Vertex.Builder newVertex = Structs.Vertex.newBuilder(island_vertices.get(city.getCentroidIdx()));

            
            
            newVertex.addProperties(color_property);

            mesh.addVertices(city.getCentroidIdx(), newVertex);
        
        }

    

        


        //need to come up with a way to make roads red or something
        mesh.addAllSegments(islandMesh.getSegmentsList());

        List<Structs.Segment> island_segments = islandMesh.getSegmentsList();
        // String road_color = "128,0,0";
        
        for(List<Node> path : island.getRoads()){
            for(int i = 0; i < path.size()-1; i++){
                Structs.Segment.Builder newSegment = Structs.Segment.newBuilder();
                Node startNode = path.get(i);
                Node endNode = path.get(i + 1);

                int startIndex = startNode.getCentroidIdx();
                int endIndex = endNode.getCentroidIdx();

                newSegment.setV1Idx(startIndex).setV2Idx(endIndex).addProperties(color_property).build();
                mesh.addSegments(newSegment);
            }   

            
        }

        for (Tile tile: island.getTiles()){
            Structs.Polygon.Builder newPolygon = Structs.Polygon.newBuilder(tile.getPolygon());
            String color = tile.getColor();

            

            Structs.Property property = Structs.Property.newBuilder().setKey("rgb_color").setValue(color).build(); 
            newPolygon.addProperties(property);

            mesh.addPolygons(newPolygon);

        }
        return mesh;
    }
    
}
