package com.preparation.datastructures.graphs;

import com.preparation.helpers.NameHandler;

import java.util.*;

/**
 * Created by Alex on 3/5/2017 at 9:44 PM.
 */
public class AdjacencyList {

    private NameHandler nameHandler;
    private HashMap<UUID, HashMap<UUID, Integer>> adjacencyList;
    private HashMap<UUID, String> nameDictionary;
    private Random random;

    public HashMap<UUID, String> getNameDictionary() {
        return nameDictionary;
    }

    public AdjacencyList() {
        this.adjacencyList = new HashMap<>();
        this.nameDictionary = new HashMap<>();
        this.random = new Random();
        this.nameHandler = new NameHandler();
        this.nameHandler.readNames();
    }

    public void setSeed(long seed) {
        random.setSeed(seed);
        this.nameHandler.setRandom(random);
    }

    public void addVertex() {
        UUID newId = UUID.randomUUID();
        adjacencyList.put(newId, new HashMap<>());
    }

    public void addVertex(HashMap<UUID, Integer> connections) {
        UUID newId = UUID.randomUUID();
        adjacencyList.put(newId, connections);
    }

    private void populateNames() {
        Iterator<UUID> iterator = adjacencyList.keySet().iterator();
        while (iterator.hasNext()) {
            nameDictionary.put(iterator.next(), nameHandler.getRandomName());
        }
    }

    public void connect(UUID from, UUID to, Integer weight) {
        if (adjacencyList.keySet().contains(to))
            adjacencyList.get(from).put(to, weight);
        else
            throw new NoSuchElementException();
    }

    public void randomizeGraph(int n, int averageConnections, boolean noLoops) {
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            addVertex();
        }
        for (int i = 0; i < (n * averageConnections); i++) {
            UUID randomVertex1 = getRandomVertex();
            UUID randomVertex2 = randomVertex1;
            if (noLoops) {
                while (randomVertex2 == randomVertex1) randomVertex2 = getRandomVertex();
            } else {
                randomVertex2 = getRandomVertex();
            }
            int weight = random.nextInt(100);
            connect(randomVertex1, randomVertex2, weight);
            populateNames();
        }
    }

    public UUID getRandomVertex() {
        UUID out = null;
        int n = adjacencyList.size();
        int randomIndex = random.nextInt(n) + 1;
        Iterator<UUID> getter = adjacencyList.keySet().iterator();
        for (int i = 0; i < randomIndex; i++) {
            out = getter.next();
        }
        return out;
    }


    public HashMap getList() {
        return adjacencyList;
    }

    @Override
    public String toString() {
        String out = "";
        for (UUID id : adjacencyList.keySet()) {
            String vertex = nameDictionary.get(id).toString();
            HashMap<UUID, Integer> list = adjacencyList.get(id);
            String constructed = "[ ";
            for (UUID tempId : list.keySet()) {
                String tempName = nameDictionary.get(tempId);
                String tempWeight = list.get(tempId).toString();
                constructed = constructed + tempName + "=" + tempWeight + ", ";
            }
            if (constructed.length() > 2)
                constructed = constructed.substring(0, constructed.length() - 2);
            constructed = constructed + " ]";
            out = out + vertex + " : " + constructed + "\n";
        }
        return out;
    }


}
