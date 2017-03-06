package com.preparation.datastructures.graphs;

import java.util.*;

/**
 * Created by Alex on 3/5/2017 at 9:44 PM.
 */
public class AdjacencyList {

    private HashMap<UUID, HashMap<UUID, Integer>> adjacencyList = new HashMap<>();

    public void addVertex(){
        UUID newId = UUID.randomUUID();
        adjacencyList.put(newId, new HashMap<>());
    }

    public void connect(UUID from, UUID to, Integer weight){
        if(adjacencyList.keySet().contains(to))
            adjacencyList.get(from).put(to, weight);
        else
            throw new NoSuchElementException();
    }

    public UUID getRandomVertex() {
        UUID out = null;
        int n = adjacencyList.size();
        int randomIndex = 1 + (int) (Math.random() * (n));
        Iterator<UUID> getter = adjacencyList.keySet().iterator();
        for(int i = 0; i < randomIndex; i++) {
            out = getter.next();
        }
        return out;
    }

    public HashMap getList(){
        return adjacencyList;
    }

    @Override
    public String toString() {
        String out = "";
        for(UUID id : adjacencyList.keySet()) {
            String vertex = id.toString();
            String list = adjacencyList.get(id).toString();
            out = out + vertex + " : " + list + "\n";
        }
        return out;
    }

}
