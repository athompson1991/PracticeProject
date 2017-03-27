package com.preparation.datastructures.graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by Alex on 3/11/2017 at 8:16 PM.
 */
public class TraveralTest {

    private AdjacencyList adjacencyList;
    private TraversalHandler traversalHandler;
    private UUID startPoint;

    @Before
    public void setup() {
        adjacencyList = new AdjacencyList();
        adjacencyList.setSeed(13);
        adjacencyList.randomizeGraph(10, 3, true);
        traversalHandler = new TraversalHandler(adjacencyList);
        startPoint = (UUID) adjacencyList.getIds()[0];
    }

    @Test
    public void breadth() {
        System.out.println(adjacencyList.toString());
        System.out.println(adjacencyList.getNameDictionary().get(startPoint));
        traversalHandler.breadthFirstTraversal(startPoint);
        traversalHandler.printTraversal();
    }
}
