package com.beriii.astaralgoproject.AStar;

import javafx.scene.shape.Line;

public class RedPathLine {
    public Line line;
    public Node startNode;
    public Node endNode;

    public RedPathLine(Line line, Node startNode, Node endNode) {
        this.line = line;
        this.startNode = startNode;
        this.endNode = endNode;
    }
}
