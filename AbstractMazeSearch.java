/*
 * Sam Polyakov
 * AbstractMazeSearch.java
 * 04/23/2023
 * Project 7
 * CS231 B
 * 
 * Purpose: Abstract class to be used by DFS, BFS, A*S, Worst solvers
 */

import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractMazeSearch {
    private Maze maze;
    private Cell start;
    private Cell target;
    private Cell cur;

    public AbstractMazeSearch(Maze maze){
        this.maze = maze;
        start = null;
        target = null;
        cur = null;
    }

    public abstract Cell findNextCell();
    //this method returns the next Cell to explore.a

    public abstract void addCell(Cell next);
    //this method adds the given Cell to whatever structure is storing the future Cells to explore

    public abstract int numRemainingCells();
    //this method returns the number of future Cells to explore

    public Maze getMaze(){
        // returns the maze
        return maze;
    }

    public void setTarget(Cell target){
        // sets the target
        this.target = target;
    }

    public Cell getTarget(){
        // returns the target
        return target;
    }

    public void setCur(Cell cell){
        // sets current cell
        cur = cell;
    }

    public Cell getCur(){
        // returns current cell
        return cur;
    }

    public void setStart(Cell start){
        // sets the start
        this.start = start;
        start.setPrev(start);
    }

    public Cell getStart(){
        // returns the start
        return start;
    }

    public void reset(){
        // sets cur, start, and target to null
        cur = null;
        start = null;
        target = null;
    }

    public LinkedList<Cell> traceback(Cell cell){
        //finds a path from the start to the specified cell by repeatedly following the prev path
        Cell curCell = cell;
        LinkedList<Cell> path = new LinkedList<>();
    
        while (curCell != null){
            path.push(curCell);
            if (curCell == start){
                return path; 
            }
            curCell = curCell.getPrev();
        } return null; 
    }

    public LinkedList<Cell> search(Cell start, Cell target, boolean display, int delay) throws InterruptedException{
        // returns the path to the target
        setStart(start);
        setTarget(target);
        setCur(start);
        addCell(start);
        MazeSearchDisplay msd = null;
        if(display){
            msd = new MazeSearchDisplay(this, 20);
        }
        while (numRemainingCells() > 0){
            if(display == true){
                Thread.sleep(delay);
                msd.repaint();
            }
            System.out.println(cur);
            cur = findNextCell();
    
            for (Cell neighbor : maze.getNeighbors(cur)) {
                if (neighbor.getPrev() == null){
                    neighbor.setPrev(cur);
                    addCell(neighbor);
                    if (neighbor == target){
                        return traceback(target); 
                    }
                }
            }
        }
        return null; 
    }

    public void draw(Graphics g, int scale) {
        // Draws the base version of the maze
        getMaze().draw(g, scale);
        // Draws the paths taken by the searcher
        getStart().drawAllPrevs(getMaze(), g, scale, Color.RED);
        // Draws the start cell
        getStart().draw(g, scale, Color.BLUE);
        // Draws the target cell
        getTarget().draw(g, scale, Color.RED);
        // Draws the current cell
        getCur().draw(g, scale, Color.MAGENTA);
    
        // If the target has been found, draws the path taken by the searcher to reach
        // the target sans backtracking.
        if (getTarget().getPrev() != null) {
            Cell traceBackCur = getTarget().getPrev();
            while (!traceBackCur.equals(getStart())) {
                traceBackCur.draw(g, scale, Color.GREEN);
                traceBackCur = traceBackCur.getPrev();
            }
            getTarget().drawPrevPath(g, scale, Color.BLUE);
        }
    }

}
