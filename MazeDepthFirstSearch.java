/*
 * Sam Polyakov
 * MazeDepthFirstSearch.java
 * 04/23/2023
 * Project 7
 * CS231 B
 * 
 * Purpose: Solves maze using DFS
 */

public class MazeDepthFirstSearch extends AbstractMazeSearch{
    private Stack<Cell> stack;

    public MazeDepthFirstSearch(Maze maze) {
        super(maze);
        stack = new LinkedList<Cell>();
    }

    @Override
    public Cell findNextCell() {
        // returns the next cell in the stack
        return stack.pop();
    }

    @Override
    public void addCell(Cell next) {
        // pushes a new cell onto the stack
        stack.push(next);
    }

    @Override
    public int numRemainingCells() {
        // returns the size of the stack
        return stack.size();
    }
    
}
