/*
 * Sam Polyakov
 * MazeTest.java
 * 04/23/2023
 * Project 7
 * CS231 B
 * 
 * Purpose: Tests maze
 */


public class MazeTest {
    public static void testGetRows(Maze maze) {
        assert maze.getRows() == 5 : "testGetRows failed";
        System.out.println("testGetRows passed");
    }

    public static void testGetCols(Maze maze) {
        assert maze.getCols() == 5 : "testGetCols failed";
        System.out.println("testGetCols passed");
    }

    public static void testGet(Maze maze) {
        Cell cell = maze.get(0, 0);
        assert cell.getRow() == 0 : "testGet failed";
        assert cell.getCol() == 0 : "testGet failed";
        System.out.println("testGet passed");
    }

    public static void testGetNeighbors(Maze maze) {
        Cell cell = maze.get(1, 1);
        LinkedList<Cell> neighbors = maze.getNeighbors(cell);
        for (Cell neighbor : neighbors) {
            int rowDiff = Math.abs(neighbor.getRow() - cell.getRow());
            int colDiff = Math.abs(neighbor.getCol() - cell.getCol());
            assert (rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1) : "testGetNeighbors failed";
        }
        System.out.println("testGetNeighbors passed");
    }

    public static void main(String[] args) {
        Maze maze = new Maze(5, 5, 0.2);
        testGetRows(maze);
        testGetCols(maze);
        testGet(maze);
        testGetNeighbors(maze);
    }
}
