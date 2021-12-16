package com.epam.xmlparsing.entity;

public class Plant {

    private int id;
    private String origin;
    private String name;
    private Soil soilType;
    private int neededTemperature;
    private boolean needsLight;
    private int weeklyRequiredWater;

    public Plant() {
    }

    public Plant(int id, String origin, String name, Soil soilType, int neededTemperature, boolean needsLight, int weeklyRequiredWater) {
        this.id = id;
        this.origin = origin;
        this.name = name;
        this.soilType = soilType;
        this.neededTemperature = neededTemperature;
        this.needsLight = needsLight;
        this.weeklyRequiredWater = weeklyRequiredWater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Soil getSoilType() {
        return soilType;
    }

    public void setSoilType(Soil soilType) {
        this.soilType = soilType;
    }

    public int getNeededTemperature() {
        return neededTemperature;
    }

    public void setNeededTemperature(int neededTemperature) {
        this.neededTemperature = neededTemperature;
    }

    public boolean isNeedsLight() {
        return needsLight;
    }

    public void setNeedsLight(boolean needsLight) {
        this.needsLight = needsLight;
    }

    public int getWeeklyRequiredWater() {
        return weeklyRequiredWater;
    }

    public void setWeeklyRequiredWater(int weeklyRequiredWater) {
        this.weeklyRequiredWater = weeklyRequiredWater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return id == plant.id && neededTemperature == plant.neededTemperature && needsLight == plant.needsLight && weeklyRequiredWater == plant.weeklyRequiredWater && name.equals(plant.name) && soilType == plant.soilType;
    }

    @Override
    public int hashCode() {
        int prime=17;
        prime=31*prime+id;
        prime=31*prime+name.hashCode();
        prime=31*prime+soilType.hashCode();
        prime=31*prime+neededTemperature;
        prime=31*prime+(needsLight?1:0);
        prime=31*prime+ weeklyRequiredWater;
        return prime;
    }
}
