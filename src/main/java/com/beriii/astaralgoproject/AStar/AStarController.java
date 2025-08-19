package com.beriii.astaralgoproject.AStar;

import com.beriii.astaralgoproject.Model;
import com.beriii.astaralgoproject.Settings.PopUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.*;

public class AStarController {
    @FXML
    Pane container;
    @FXML
    TextField nodeTxt, fromTxt, toTxt, weightTxt, startTxt, endTxt;

    private List<RedPathLine> redPathLines = new ArrayList<>();
    private Model model;



    public void initialize(){
        model = new Model();
    }


    public void addNode(ActionEvent event) {
        if(nodeTxt.getText().isEmpty() && nodeTxt.getText().isBlank()){
            new PopUp("Enter a node name");
            return;
        }
        if(!model.graph.containsKey(nodeTxt.getText())){
            double r = 30;
            double x = Math.random() * (550 - r * 2);
            double y = Math.random() * (475 - r * 2);
            Circle circle = new Circle(30, Color.BLUE);
            circle.setCenterX(x);
            circle.setCenterY(y);

            Text text = new Text(x, y, nodeTxt.getText());
            text.setFill(Color.RED);
            Node node = new Node(nodeTxt.getText(), x, y);

            model.graph.put(nodeTxt.getText(), node);

            circle.setOnMouseDragged(e -> {
                double newX = e.getX();
                double newY = e.getY();

                //update positions
                circle.setCenterX(newX);
                circle.setCenterY(newY);

                text.setX(newX);
                text.setY(newY);

                node.x = newX;
                node.y = newY;

                updateEdge(node);
            });

            container.getChildren().addAll(circle, text);
        }else{
            new PopUp("Node already exists!");
        }
        nodeTxt.setText("");
    }
    public void updateEdge(Node node){
        for(int i = 0; i < node.edges.size(); i++){
            Edge edge = node.edges.get(i);
            Line line = edge.line;

            if(line != null){
                Node target = edge.target;

                line.setStartX(node.x);
                line.setStartY(node.y);
                line.setEndX(target.x);
                line.setEndY(target.y);

                if(edge.textWeight != null){
                    edge.textWeight.setX((node.x + target.x) / 2);
                    edge.textWeight.setY((node.y + target.y) / 2);
                }
            }

        }
        // update red lines
        for (RedPathLine redPath : redPathLines) {
            if (redPath.startNode == node || redPath.endNode == node) {
                redPath.line.setStartX(redPath.startNode.x);
                redPath.line.setStartY(redPath.startNode.y);
                redPath.line.setEndX(redPath.endNode.x);
                redPath.line.setEndY(redPath.endNode.y);
            }
        }
    }

    public void addEdge(ActionEvent e){
        if (fromTxt.getText().isEmpty() && toTxt.getText().isEmpty()
                && fromTxt.getText().isBlank() && toTxt.getText().isBlank()
                && weightTxt.getText().isEmpty() && weightTxt.getText().isBlank()) {
            new PopUp("Invalid Input!");
            return;
        }

        double weight;
        try {
            weight = Double.parseDouble(weightTxt.getText());
        } catch (NumberFormatException ex) {
            new PopUp("Invalid weight! Please enter a number.");
            return;
        }
        String from = fromTxt.getText();
        String to = toTxt.getText();

        Node fromNode = model.graph.get(from);
        Node toNode = model.graph.get(to);

        if(fromNode != null && toNode != null){
            //checks if already exists
            for (Edge edge : fromNode.edges) {
                if (edge.target == toNode) {
                    new PopUp("An edge between " + from + " and " + to + " already exists!");
                    return;
                }
            }

            //adds edge
            fromNode.edges.add(new Edge(toNode, weight));
            toNode.edges.add(new Edge(fromNode, weight));

            //adds line between from node to target node
            Line line = new Line(fromNode.x, fromNode.y, toNode.x, toNode.y);
            line.setFill(Color.GRAY);

            //this adds weight text to the middle of the line
            Text weightText = new Text((fromNode.x + toNode.x) / 2, (fromNode.y + toNode.y) / 2, weightTxt.getText());

            //dynamic updates
            Edge edge = new Edge(toNode, weight);
            edge.line = line;
            edge.textWeight = weightText;

            fromNode.edges.add(edge);
            container.getChildren().addAll(line, weightText);

            Edge reverseEdge = new Edge(fromNode, weight);
            reverseEdge.line = line;
            reverseEdge.textWeight = weightText;
            toNode.edges.add(reverseEdge);
        }else{
            new PopUp("One or both nodes do not exist!");
        }
        weightTxt.setText("");
        fromTxt.setText("");
        toTxt.setText("");
    }

    public void findPath(ActionEvent event) {
        clearPreviousPath();
        if(startTxt.getText().isBlank() && startTxt.getText().isEmpty() && endTxt.getText().isBlank() && endTxt.getText().isBlank()){
            new PopUp("Invalid Input!");
            return;
        }
        Node startNode = model.graph.get(startTxt.getText());
        Node endNode = model.graph.get(endTxt.getText());

        if(startNode != null && endNode != null){
            List<Node> path = model.aStarAlgo(startNode, endNode);

            if(!path.isEmpty()){
                for(int i = 0; i < path.size() - 1; i++){
                    Node current = path.get(i);
                    Node next = path.get(i + 1);

                    Line line = new Line(current.x, current.y, next.x, next.y);
                    line.setStroke(Color.RED);
                    line.setStrokeWidth(2);
                    container.getChildren().add(line);
                    redPathLines.add(new RedPathLine(line, current, next));
                }
                new PopUp("Path found: " + path.stream().map(n -> n.name).toList());
            }else{
                new PopUp("No path found!");
            }
        }else{
            new PopUp("One or both nodes do not exist!");
        }
        startTxt.setText("");
        endTxt.setText("");
    }
    private void clearPreviousPath() {
        for (RedPathLine redLine : redPathLines) {
            container.getChildren().remove(redLine.line);
        }
        redPathLines.clear();
    }
    public void clearAllBtn(ActionEvent event) {
        container.getChildren().clear();
        model.graph.clear();
        redPathLines.clear();
        nodeTxt.setText("");
        fromTxt.setText("");
        toTxt.setText("");
        weightTxt.setText("");
        startTxt.setText("");
        endTxt.setText("");
    }
}
