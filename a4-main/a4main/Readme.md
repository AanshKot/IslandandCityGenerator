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

One can run the generator with `-help` as option to see the different command line arguments that are available
Note: PDF versions of the SVG files were created with `rsvg-convert`.

### Product Backlog
| Id | Feature title | Who? | Start | End | Status |
|:--:|---------------|------|-------|-----|--------|
| F01 (Shapes) | Specify shape of island in CLI, user should be able to choose, at minimum, two shape profiles | Aansh | March 5th 2023| March 8th 2023| D|
| F02 (Elevation) | From the CLI the user should be able to specify at least 2 elevation profiles, your project should provide a way to define altmetric profiles | Aansh | March 5th 2023|March 8th 2023 |D |
| F03 (Lakes) | Ability to generate lakes which are flat | Aansh | March 11th 2023 | March 14th 2023| D|
| F04 (Lakes) | From the CLI, the user specifies max number of lakes | Aansh | March 11th 2023 | March 14th 2023| D|
| F05 (Rivers) | Have the ability to generate rivers, these rivers should end at the lowest point (lakes, ocean) | Omar | | | |
| F06 (Rivers Flow) | Ensure when two rivers meet, their width will double, humidity increases | Omar | | | |
| F07 (Aquifers) | Ability to generate Aquifers, choose number of aquifers through CLI | Gigi | | | |
| F08 (Humidity) | Ensure that each tile has a given humidity value, humidity value dependant on lakes, rivers aquifers | Gigi | | | |
| F09 (Soil Absorption) | Be able to calculate the amount of water that was absorbed based on the distance from a water source | Aansh| March 14th 2023| March 17th 2023| D|
| F10 (Soil Absorption) | Allow the user from the CLI to choose from at least two soil absorption profiles | Aansh | March 17th 2023 |March 21st 2023 | D|
| F11 (Biomes) | Based on each tiles soil humidity and elevation, assign the tile a biome | Gigi | | | D|
| F12 (Biomes) | Assign different colors to different biomes | Gigi | | | D|
| F13 (Whittaker Diagrams) | From the CLI, allow the user to determine the biome distribution through the choice of which Whitaker diagram to use | Aansh | March 21st 2023| March 22nd 2023 | D|
| F14 (Seed) | With each generated mesh, generate alongside it a corresponding Seed | Aansh | March 22nd  2023| March 23rd 2023 |D|
| F15 (Seed) | Allow the ability to generate an island through passing in a seed value from the CLI | Aansh | March 23rd 2023 | March 25th 2023 | D|
| F16 (Bonus) | Allow the ability to visualize a heatmap/elevation/resource map of the island through the command line | Aansh | March 27th 2023 | March 29th 2023 | D|


