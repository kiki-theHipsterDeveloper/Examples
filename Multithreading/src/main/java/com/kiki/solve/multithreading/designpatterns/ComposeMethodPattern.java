package com.kiki.solve.multithreading.designpatterns;

public class ComposeMethodPattern {
    /* SLAP - SINGLE LEVEL OF ABSTRACTION PRINCIPLE
       Eg like cooking recipe instructions
     */
    /*int getLiveNeighbourCount(boolean[][] landscape, int row, int column) {

        if (row < 0 || row > landscape.length - 1 || column < 0 || column > landscape.length)
            throw new IndexOutOfBoundsException();

        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if ((i > -1 && j > -1 && i < landscape.length && j < landscape[0].length
                        && landscape[i][j])) {
                    count++;
                }
            }
        }
        return landscape[row][column] ? count - 1 : count;
    }*/

    int getLiveNeighbourCount(boolean[][] landscape, int row, int column) {

        isArrayInBounds(landscape, row, column);

        /*int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (isThereALiveCellAt(landscape, i, j)) {
                    count++;
                }
            }
        }*/

        int count = 0;
        if (isThereALiveCellAt(landscape, row -1, column))
            count++;
        if (isThereALiveCellAt(landscape,row + 1,column)) count++;
        if (isThereALiveCellAt(landscape,row ,column -1)) count++;
        if (isThereALiveCellAt(landscape,row ,column + 1)) count++;
        if (isThereALiveCellAt(landscape,row + 1,column - 1)) count++;
        if (isThereALiveCellAt(landscape,row + 1,column + 1)) count++;
        if (isThereALiveCellAt(landscape,row - 1,column - 1)) count++;
        if (isThereALiveCellAt(landscape,row - 1,column + 1)) count++;

        return  count;
    }

    private boolean isThereALiveCellAt(boolean[][] landscape, int i, int j) {
        return i > -1 && j > -1 && i < landscape.length && j < landscape[0].length
                && landscape[i][j];
    }

    private void isArrayInBounds(boolean[][] landscape, int row, int column) {
        if (row < 0 || row > landscape.length - 1 || column < 0 || column > landscape.length)
            throw new IndexOutOfBoundsException();
    }


}
