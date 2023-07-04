/*
 * Sam Polyakov
 * WorstSolver.java
 * 04/23/2023
 * Project 7
 * CS231 B
 * 
 * Purpose: Solves maze using worst path
 */

import java.util.Comparator;

public class WorstSolver extends AbstractMazeSearch{
    private PriorityQueue<Cell> priorityQueue;
    private Comparator<Cell> comparator;

    public WorstSolver(Maze maze) {
        super(maze);
        this.comparator = new Comparator<Cell>() {
            public int compare(Cell cell1, Cell cell2){
                // compares cells
                Cell target = getTarget();
                int targetR = target.getRow();
                int targetC = target.getCol();
                int cell1distance = Math.abs(targetR - cell1.getRow()) + Math.abs((targetC - cell1.getCol())) + traceback(cell1).size();
                int cell2distance = Math.abs(targetR - cell2.getRow()) + Math.abs((targetC - cell2.getCol())) + traceback(cell2).size();

                if(cell1distance > cell2distance){
                    return -1;
                }
                else if(cell1distance < cell2distance){
                    return 1;
                }
                else{
                    return 0;
                }
            }    
        };
        

        priorityQueue = new Heap<Cell>(this.comparator);
    }

    @Override
    public Cell findNextCell() {
        System.out.println("-".repeat(30));
        System.out.println(priorityQueue);
        System.out.println("-".repeat(30));
        // returns the next cell in the queue
        return priorityQueue.poll();
    }

    @Override
    public void addCell(Cell next) {
        // adds a cell to the queue
        System.out.println("-".repeat(30));
        System.out.println(priorityQueue);
        System.out.println("-".repeat(30));
        priorityQueue.offer(next);
        System.out.println("-".repeat(30));
        System.out.println(priorityQueue);
        System.out.println("-".repeat(30));
    }

    @Override
    public int numRemainingCells() {
        // returns the number of cells remaining in the queue
        return priorityQueue.size();
    }
    
}
