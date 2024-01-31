package org.assignment.model;

import java.util.List;

public class WinCombination {
    private double rewardMultiplier;
    private int count;
    private String group;
    private String when;
    private List<List<String>> coveredAreas; // Optional, for patterns like horizontal, vertical, etc.

    public double getRewardMultiplier() {
        return rewardMultiplier;
    }

}

