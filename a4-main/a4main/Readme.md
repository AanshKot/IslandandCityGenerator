# Mesh Generator (Assignment #2 Walkthrough)

  - Author: Sébastien Mosser

## How to install?

```
mosser@azrael A2 % mvn install
```

It creates two jars:

  1. `generator/generator.jar` to generate meshes
  2. `visualizer/visualizer.jar` to visualize such meshes as SVG files

## Examples of execution

### Generating a mesh, grid or irregular

```
mosser@azrael A2 % java -jar generator/generator.jar -k grid -h 1080 -w 1920 -p 1000 -s 20 -o img/grid.mesh
mosser@azrael A2 % java -jar generator/generator.jar -k grid -h 1080 -w 1920 -p 1000 -s 20 -o img/irregular.mesh
mosser@azrael A2 % java -jar generator/generator.jar -k irregular -h 1080 -w 1920 -p 1000 -s 20 -o img/input.mesh

```

One can run the generator with `-help` as option to see the different command line arguments that are available

### Visualizing a mesh, (regular or debug mode)

```
mosser@azrael A2 % java -jar visualizer/visualizer.jar -i img/grid.mesh -o img/grid.svg          
mosser@azrael A2 % java -jar visualizer/visualizer.jar -i img/grid.mesh -o img/grid_debug.svg -x
mosser@azrael A2 % java -jar visualizer/visualizer.jar -i img/irregular.mesh -o img/irregular.svg   
mosser@azrael A2 % java -jar visualizer/visualizer.jar -i img/irregular.mesh -o img/irregular_debug.svg -x
```

### Generating an island

```
mosser@azrael A2 % java -jar island/island.jar -i img/input.mesh -o img/lagoon.mesh -shape square 

Utilizing Seed CLI:
Seed Structure: (#1.#2.#3.#4.#5.#6) where arguments are separated by periods. 

#1 : (SHAPE OF ISLAND) 0 - Square, 1 - Circle
#2 : (ELEVATION PROFILE) 0 - Volcano, 1 - Valley
#3 : (LAKES) Tile indexes are separated by commas. Only Land Tiles will be modified to generate a Lake Tile.
#4 : (Aqufiers) *SEE LAKES* NOTE: Aqufiers can re-rendered over a Lake Tile, meaning the Lake Tile will be overwritten to form an Aquifer Tile
#5 : (SOIL PROFILE) 0 - Wet, 1 - Dry
#6 : (BIOMES) 0 - MESA, 1 - ARCTIC

java -jar island/island.jar -i img/input.mesh -o img/lagoon.mesh -seed 0.0.123,111,40.123.0.1


```

### Running pathfinder subproject

```
To test correctness of shortest path function:
java -jar pathfinder/pathfinder.jar



```

One can run the generator with `-help` as option to see the different command line arguments that are available
Note: PDF versions of the SVG files were created with `rsvg-convert`.

### Product Backlog
| Id | Feature title | Who? | Start | End | Status |
|:--:|---------------|------|-------|-----|--------|
| F01 (GraphADT) | Create a GraphADT, model what attributes the nodes and edges should store | Aansh | April 2nd 2023| April 3rd 2023| D|
| F02 (Pathfinder) | Create the pathfinder interface | Aansh | April 4th 2023| April 4th 2023| D|
| F03 (Pathfinder) | Create the shortest path method, implementing the pathfinder interface | Aansh | April 4th 2023| April 4th 2023| D|




