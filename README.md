#Urbanism

Authors for this project: Aansh Kotian
Authors for previous aspects of this project (mesh generator, island): Aansh Kotian, Omar Bakr, Gigi Liang
In collaboration, the authors created the mesh, the island, and its various configurations. Each member contributed equally, with each of us dedicating 33% of our efforts. The current task, Urbanism Pathfinder, builds on top of a mesh and island generator. Aansh Kotian takes sole responsibility in producing this city generator.
How to install?
user A4 % mvn install clean package
It creates a jar file for the generator, pathfinder, island, and visualizer subprojects:

generator/generator.jar to generate a mesh
pathfinder/pathfinder.jar to generate pathfinder library
island/island.jar to generate islands
visualizer/visualizer.jar to visualize the island

##Generate a sample mesh
user A4 % java -jar generator/generator.jar -k irregular -h 1080 -w 1920 -p 1000 -s 20 -o input.mesh 
Run the island generator with cities
user A4 % java -jar island/island.jar -i input.mesh -o island.mesh -s rectangle -b tropical -l 11 -a 5 -r 11 -soil wet -c 10
-c <arg> is the number of cities to be generated on the island.

Note: roads cross lakes via bridges.

##Visualize the island
user A4 % java -jar visualizer/visualizer.jar -i island.mesh -o output.svg
The central city is the capital or hub node. The bigger the city the bigger its corresponding vertex. The red segments represent roads between cities.

![External Image](https://i.imgur.com/MF34kKr.jpeg)

Note: whenever the island generator produces cities, they will be generated randomly. In order to reproduce the exact same mesh, utilize the given seed number to regenerate it.

##Pathfinder
The Pathfinder project is a sub-module within this repository, implementing a graph-based algorithm for determining the shortest path between two nodes. It also includes a general-purpose Graph ADT (Abstract Data Type) to represent nodes and edges, along with an interface for defining the contract of "finding a path between two nodes."

##Rationale
The primary goal of this project was to first develop a reusable Graph ADT, and then integrate it with a pathfinding algorithm to compute the shortest path from a central hub to all other cities in the Island subproject, forming a star network. This project can be expanded to support various pathfinding algorithms and applied in scenarios requiring pathfinding solutions.

##Implementation
The Graph ADT is implemented using an adjacency list representation. Each node has a unique identifier, and edges include the connected nodes along with a weight property. Additionally, nodes can hold attributes like elevation or city names.

The Pathfinder algorithm utilizes Dijkstra's algorithm, which efficiently computes the shortest path between two nodes. The algorithm maintains a priority queue to visit nodes in the order of shortest path distance, terminating when the destination node is reached or no more nodes remain to be visited.

The Island subproject applied this algorithm to find the shortest path based on edge weight, effectively selecting the path with the smallest segments, as weight corresponds to segment length.

##Extending the Library
The Pathfinder project can be expanded by adding more pathfinding algorithms, implemented as distinct classes that adhere to the same pathfinder interface.

Moreover, the Graph ADT can be extended with additional features like adding or removing nodes and edges, querying node and edge attributes, and more. This flexibility allows the library to be adapted for a wider range of applications beyond pathfinding.
