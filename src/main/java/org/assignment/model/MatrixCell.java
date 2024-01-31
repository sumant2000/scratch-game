package org.assignment.model;

public class MatrixCell {
    public MatrixCell() {
    }

    public MatrixCell(int row, int column, Symbol symbol) {
        this.row = row;
        this.column = column;
        this.symbol = symbol;
    }

    public MatrixCell(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    private int row;
    private int column;
    private Symbol symbol;
}
