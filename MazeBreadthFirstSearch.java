/*
 * Sam Polyakov
 * MazeBreadthFirstSearch.java
 * 04/23/2023
 * Project 7
 * CS231 B
 * 
 * Purpose: Solves maze using BFS
 */

public class MazeBreadthFirstSearch extends AbstractMazeSearch{
    private Queue<Cell> queue;


    public MazeBreadthFirstSearch(Maze maze) {
        super(maze);
        queue = new LinkedList<Cell>();
    }

    @Override
    public Cell findNextCell() {
        // returns the next cell in the queue
        return queue.poll();
    }

    @Override
    public void addCell(Cell next) {
        // adds a new item to the queue
        queue.offer(next);
    }

    @Override
    public int numRemainingCells() {
        // returns the size of the queue
        return queue.size();
    }
    
}
