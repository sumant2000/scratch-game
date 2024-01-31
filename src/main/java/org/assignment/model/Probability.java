package org.assignment.model;

import java.util.Map;

public class Probability {

    private int column;
    private int row;
    private Map<String, Integer> symbols;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Map<String, Integer> getSymbols() {
        return symbols;
    }

}
