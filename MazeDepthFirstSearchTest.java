/*
 * Sam Polyakov
 * MazeDepthFirstSearch.java
 * 04/23/2023
 * Project 7
 * CS231 B
 * 
 * Purpose: Tests DFS solver
 */

public class MazeDepthFirstSearchTest {
    public static void testDepthFirstSearch(MazeDepthFirstSearch dfs, Maze maze, Cell start, Cell end) throws InterruptedException {
        dfs.search(start, end, false, 0);
        if (end.getPrev() != null) {
            System.out.println("A path was found");
        } else {
            System.out.println("No path was found");
        }

        Cell current = end;
        int steps = 0;
        while (current != null && !current.equals(start)) {
            Cell prev = current.getPrev();
            if (prev != null) {
                int rowDiff = Math.abs(current.getRow() - prev.getRow());
                int colDiff = Math.abs(current.getCol() - prev.getCol());
                assert (rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1) : "testDepthFirstSearch failed";
            }
            current = prev;
            steps++;
        }

        System.out.println("Path length: " + steps);
    }

    public static void main(String[] args) throws InterruptedException {
        Maze maze = new Maze(5, 5, 0.2);
        Cell start = maze.get(0, 0);
        Cell end = maze.get(4, 4);

        MazeDepthFirstSearch dfs = new MazeDepthFirstSearch(maze);
        testDepthFirstSearch(dfs, maze, start, end);
    }
}
