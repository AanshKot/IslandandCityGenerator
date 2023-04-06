package IslandGenerator.model;

import java.util.List;

import IslandGenerator.generator.IslandGenerator;

import IslandGenerator.model.Tiles.Tile;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Mesh;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.model.Node.Node;

public class Island {
    private List<Tile> tiles;
    private List<River> rivers;
    private Mesh islandMesh;
    private List<Node> cities;
    private List<Edge> roads;



    public Island(Mesh mesh) {
        this.islandMesh = mesh;
    }
    public Mesh getMesh(){
        return this.islandMesh;
    }

    public void setRivers(List<River> rivers){
        this.rivers = rivers;
    }
    public List<River> getRivers(){
        return this.rivers;
    }
    public void setTiles(List<Tile> tiles){
        this.tiles = tiles;
    }
    public List<Tile> getTiles(){
        return this.tiles;
    }

    public void setCities(List<Node> cities){
        this.cities = cities;
    }

    public List<Node> getCities(){
        return this.cities;
    }

    public void setRoads(List<Edge> roads){
        this.roads = roads;
    }

    public List<Edge> getRoads(){
        return this.roads;
    }


}
