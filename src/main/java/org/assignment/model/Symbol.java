package org.assignment.model;

public class Symbol {
        private String name;
        private double rewardMultiplier;



    private String type;
        private double extra;
        private String impact;

    public Symbol() {
    }
    public Symbol(String name) {
        this.name = name;
    }

    public Symbol(java.lang.String name, double rewardMultiplier, java.lang.String type, double extra, java.lang.String impact) {
        this.name = name;
        this.rewardMultiplier = rewardMultiplier;
        this.type = type;
        this.extra = extra;
        this.impact = impact;
    }

    public String getName() {
        return name;
    }

    public double getRewardMultiplier() {
        return rewardMultiplier;
    }
}

