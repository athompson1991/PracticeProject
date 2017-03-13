package com.preparation.datastructures.graphs;

import com.preparation.datastructures.trees.LinkedBinarySearchTree;

import java.util.*;

/**
 * Created by aleth on 3/8/2017.
 */
public class TraversalHandler {

    private AdjacencyList adjacencyList;
    private HashMap<UUID, HashMap<UUID, Integer>> rawList;
    private LinkedList<UUID> traversalList;


    public TraversalHandler(AdjacencyList adjacencyList) {
        this.adjacencyList = adjacencyList;
        rawList = adjacencyList.getList();
    }

    public void breadthFirstTraversal(UUID startingPoint) {
        LinkedList<UUID> initialVisited = new LinkedList<UUID>();
        LinkedList<UUID> initialTraversed = new LinkedList<UUID>();
        initialVisited.add(startingPoint);
        initialTraversed.add(startingPoint);
        this.traversalList = breadthFirstTraversal(startingPoint, initialVisited, initialTraversed);
    }

    public LinkedList<UUID> breadthFirstTraversal(UUID startingPoint, LinkedList<UUID> visited, LinkedList<UUID> traversed) {
        LinkedList<UUID> out = null;
        HashMap<UUID, Integer> connectionMapping = rawList.get(startingPoint);
        Set connections = connectionMapping.keySet();

        if (visited.containsAll(connections)) {
            out = traversed;
        } else {

        }
        return out;
    }

    public void printTraversal() {
        StringBuilder out = new StringBuilder();
        out.append("[ ");
        for (UUID id : traversalList) {
            out.append(adjacencyList.getNameDictionary().get(id));
            out.append(", ");
        }
        out.append(" ]");
        System.out.println(out);
    }
}
