package com.beriii.astaralgoproject;

import com.beriii.astaralgoproject.AStar.Edge;
import com.beriii.astaralgoproject.AStar.Node;

import java.util.*;

public class Model {
    public Map<String, Node> graph = new HashMap<>();

    public List<Node> aStarAlgo(Node Start, Node End){
        PriorityQueue<Node> sets = new PriorityQueue<>(Comparator.comparingDouble(value -> value.getX() + value.getY()));
        Map<Node, Node> from = new HashMap<>();
        Map<Node, Double> shortestPath = new HashMap<>();
        Map<Node, Double> estimate = new HashMap<>();

        List<Node> nodeList = new ArrayList<>(graph.values());
        for(int i = 0; i < nodeList.size(); i++){
            Node node = nodeList.get(i);
            shortestPath.put(node, Double.MAX_VALUE);
            estimate.put(node, Double.MAX_VALUE);
        }
        shortestPath.put(Start, 0.0);
        estimate.put(Start, euclideanDistance(Start, End));

        sets.offer(Start);

        while(!sets.isEmpty()){
            Node current = sets.poll();

            if(current == End){
                return organizePath(from, current);
            }

            for(int i = 0; i < current.edges.size(); i++){
                Edge edge = current.edges.get(i);
                Node neighbor = edge.target;
                double isLessthan = shortestPath.get(current) + edge.weight;

                if(isLessthan < shortestPath.get(neighbor)){
                    from.put(neighbor, current);
                    shortestPath.put(neighbor, isLessthan);
                    estimate.put(neighbor, isLessthan + euclideanDistance(neighbor, End));

                    if(!sets.contains(neighbor)){
                        sets.offer(neighbor);
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    public double euclideanDistance(Node a, Node b){
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public List<Node> organizePath(Map<Node, Node> from, Node current){
        List<Node> path = new ArrayList<>();
        while(from.containsKey(current)){
            path.add(current);
            current = from.get(current);
        }
        path.add(current);
        Collections.reverse(path);
        return path;
    }
}