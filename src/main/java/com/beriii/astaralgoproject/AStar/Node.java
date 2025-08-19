package com.beriii.astaralgoproject.AStar;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String name;
    double x,y;
    public List<Edge> edges = new ArrayList<>();

    public Node (String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public double getX(){return x;}
    public double getY(){return y;}
}
