package com.data_structures.graphs;

import java.io.*;

/** This program outputs the topological sort of a directed graph
*   that contains no cycles.
*   @author Group 6
*/

public class TopologicalSort {

  /** The main method that performs the topological sort.
      pre: arg[0] contains the name of the file
           that contains the graph. It has no cycles.
      @param args The command line arguments
   */
  public static void main(String[] args) {
    Graph theGraph = null;
    int numVertices = 0;
    try {
      // Construct BufferedReader for input file.
      BufferedReader bR =
          new BufferedReader(new FileReader(args[0]));
      // Load the graph data from a file.
      theGraph = AbstractGraph.createGraph(bR, true, "List");
      numVertices = theGraph.getNumV();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      System.exit(1); // Error exit.
    }
    // Perform the depth-first search.
    DepthFirstSearch dfs = new DepthFirstSearch(theGraph);
    // Obtain the finish order.
    int[] finishOrder = dfs.getFinishOrder();
    // Print the vertices in reverse finish order.
    System.out.println("The Topological Sort is");
    for (int i = numVertices - 1; i >= 0; i--) {
      System.out.println(finishOrder[i]);
    }
  }
}
