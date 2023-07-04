/*
 * Sam Polyakov
 * Heap.java
 * 04/23/2023
 * Project 7
 * CS231 B
 * 
 * Purpose: Runs DFS, BFS, A*S, or Worst solvers
 */

import java.util.Random;

public class Exploration {
    public static void main(String[] args) throws InterruptedException {
        Maze maze = new Maze(10, 10, 0);
        // AbstractMazeSearch search = new MazeDepthFirstSearch(maze);
        // AbstractMazeSearch search = new MazeBreadthFirstSearch(maze);
        // AbstractMazeSearch search = new MazeAStarSearch(maze);
        AbstractMazeSearch search = new WorstSolver(maze);

        Random rand = new Random();

        Cell start = maze.get(rand.nextInt(maze.getRows()), rand.nextInt(maze.getCols()));
        Cell target = maze.get(rand.nextInt(maze.getRows()), rand.nextInt(maze.getCols()));

        while(target.getType() == CellType.OBSTACLE){
            target = maze.get(rand.nextInt(maze.getRows()), rand.nextInt(maze.getCols()));
        }

        search.search(start, target, true, 20);
        
    }
}
