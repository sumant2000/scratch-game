package org.assignment.model;

import java.util.List;

public class GameMatrix {
    public GameMatrix() {
    }

    public GameMatrix(List<List<MatrixCell>> matrix) {
        this.matrix = matrix;
    }

    public List<List<MatrixCell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<MatrixCell>> matrix) {
        this.matrix = matrix;
    }

    private List<List<MatrixCell>> matrix;

}
