package com.preparation.projecteuler;

/**
 * Created by Alex on 1/28/2017.
 */
public class Solution15 extends AbstractSolution {
    private int gridSize;
    private long[][] grid;

    public void setGridSize(int in) {
        this.gridSize = in;
    }

    public Solution15() {
        setGridSize(20);
        this.solutionNumber = 15;
    }

    public void solve() {
        grid = new long[gridSize + 1][gridSize + 1];

        for (int i = 0; i < gridSize; i++) {
            grid[i][gridSize] = 1;
            grid[gridSize][i] = 1;
        }

        for (int i = gridSize - 1; i >= 0; i--) {
            for (int j = gridSize - 1; j >= 0; j--) {
                grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
            }
        }

        this.solution = grid[0][0];
    }
}
