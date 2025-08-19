package com.beriii.astaralgoproject.AStar;

import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Edge {
    public Node target;
    public double weight;
    public Line line;
    public Text textWeight;

    public Edge(Node target, double weight) {
        this.target = target;
        this.weight = weight;
    }
}
