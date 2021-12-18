package com.epam.xmlparsing.entity;

import java.util.Objects;

public class Tree extends Plant {

    private final double trunkDiameter;

    public Tree(int id, String origin, String name, Soil soilType, int neededTemperature, boolean needsLight, int weeklyRequiredWater, double trunkDiameter) {
        super(id, origin, name, soilType, neededTemperature, needsLight, weeklyRequiredWater);
        this.trunkDiameter = trunkDiameter;
    }

    public Tree(TreeBuilder builder) {
        super(builder);
        this.trunkDiameter = builder.trunkDiameter;
    }

    public double getTrunkDiameter() {
        return trunkDiameter;
    }

    public static class TreeBuilder extends PlantBuilder {
        private double trunkDiameter;

        public void setTrunkDiameter(double trunkDiameter) {
            this.trunkDiameter = trunkDiameter;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Tree tree = (Tree) o;
        return Double.compare(tree.trunkDiameter, trunkDiameter) == 0;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        prime = 31 * prime + super.hashCode();
        prime = 31 * (int) trunkDiameter;
        return prime;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "trunkDiameter=" + trunkDiameter +
                '}';
    }
}
