package com.epam.xmlparsing.entity;

import java.util.Objects;

public class Flower extends Plant {

    private int petalNumber;

    public Flower() {
    }

    public Flower(int id, String origin, String name, Soil soilType, int neededTemperature, boolean needsLight, int weeklyRequiredWater, int petalNumber) {
        super(id, origin, name, soilType, neededTemperature, needsLight, weeklyRequiredWater);
        this.petalNumber = petalNumber;
    }

    public int getPetalNumber() {
        return petalNumber;
    }

    public void setPetalNumber(int petalNumber) {
        this.petalNumber = petalNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Flower flower = (Flower) o;
        return petalNumber == flower.petalNumber;
    }

    @Override
    public int hashCode() {
        int prime=17;
        prime=31*prime+super.hashCode();
        prime=31*prime+petalNumber;
        return prime;
    }
}
