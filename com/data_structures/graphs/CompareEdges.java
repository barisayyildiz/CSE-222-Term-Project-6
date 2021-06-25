package com.data_structures.graphs;

import java.util.Comparator;

/** A class for comparing 2 edges.
 *  @author Group 6
 */

public class CompareEdges
    implements Comparator < Edge > {
  public int compare(Edge e1, Edge e2) {
    return Double.compare(e1.getWeight(), e2.getWeight());
  }
}
