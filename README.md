# A* Algorithm Project

A JavaFX-based interactive visualization tool for the A* pathfinding algorithm. This application allows users to create graphs with nodes and weighted edges, then find the shortest path between any two nodes using the A* algorithm.

## Features

- **Interactive Graph Creation**: Add nodes by clicking and dragging them around the canvas
- **Edge Management**: Create weighted edges between nodes with custom weights
- **Visual Path Finding**: Visualize the shortest path found by the A* algorithm in red
- **Real-time Updates**: Drag nodes to see edges and paths update dynamically
- **Clear Interface**: Simple and intuitive user interface with input validation

## Technologies Used

- **Java 22**: Core programming language
- **JavaFX 22**: GUI framework for the interactive interface
- **Maven**: Build and dependency management
- **FXML**: UI layout definition

## Prerequisites

- Java 22 or higher
- Maven 3.6+
- JavaFX runtime (included as dependency)

## Installation & Setup

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd AStarAlgoProject
   ```

2. **Build the project**:
   ```bash
   mvn clean compile
   ```

3. **Run the application**:
   ```bash
   mvn javafx:run
   ```

## How to Use

### Creating a Graph

1. **Add Nodes**:
   - Enter a node name in the "Node" text field
   - Click "Add Node" to create a new node on the canvas
   - Nodes appear as blue circles with red text labels
   - Drag nodes around the canvas to reposition them

2. **Add Edges**:
   - Enter the "From" node name
   - Enter the "To" node name  
   - Enter the edge weight (must be a number)
   - Click "Add Edge" to create a weighted connection
   - Edges appear as gray lines with weight labels

### Finding Paths

1. **Set Start and End Points**:
   - Enter the starting node name in the "Start" field
   - Enter the destination node name in the "End" field
   - Click "Find Path" to run the A* algorithm

2. **View Results**:
   - The shortest path will be highlighted in red
   - A popup will show the path sequence
   - If no path exists, you'll be notified

### Additional Controls

- **Clear All**: Removes all nodes, edges, and paths from the canvas
- **Drag Nodes**: Click and drag any node to reposition it (edges update automatically)

## Algorithm Details

The A* algorithm implementation includes:

- **Heuristic Function**: Euclidean distance to the goal node
- **Cost Function**: Actual distance traveled from start node
- **Priority Queue**: Efficiently selects the most promising node to explore
- **Path Reconstruction**: Traces back the optimal path once found

### Key Components

- `Node.java`: Represents graph vertices with position and connections
- `Edge.java`: Represents weighted connections between nodes
- `Model.java`: Contains the A* algorithm implementation
- `AStarController.java`: Handles UI interactions and graph visualization

## Project Structure

```
src/
├── main/
│   ├── java/com/beriii/astaralgoproject/
│   │   ├── AStar/
│   │   │   ├── AStarController.java    # Main UI controller
│   │   │   ├── Node.java               # Node data structure
│   │   │   ├── Edge.java               # Edge data structure
│   │   │   └── RedPathLine.java        # Path visualization
│   │   ├── Settings/
│   │   │   └── PopUp.java              # Alert dialogs
│   │   ├── Controller.java             # Start screen controller
│   │   ├── Model.java                  # A* algorithm implementation
│   │   └── View.java                   # Main application class
│   └── resources/
│       └── com/beriii/astaralgoproject/
│           ├── mainScreen.fxml         # Start screen layout
│           └── AStarScreen.fxml        # Main application layout
```

## Dependencies

- JavaFX Controls, FXML, Web, Swing, Media
- ControlsFX (UI controls)
- FormsFX (Form handling)
- ValidatorFX (Input validation)
- Ikonli (Icons)
- BootstrapFX (Styling)
- TilesFX (Additional UI components)
- FXGL (Game library components)

## Building for Distribution

To create a distributable version:

```bash
mvn clean javafx:jlink
```

This creates a self-contained application in the `target/` directory.

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request


## Author

Created by beriii as an educational project demonstrating the A* pathfinding algorithm with interactive visualization.
