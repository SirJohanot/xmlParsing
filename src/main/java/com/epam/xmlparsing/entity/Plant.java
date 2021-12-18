package com.epam.xmlparsing.entity;

public class Plant {

    private final int id;
    private final String origin;
    private final String name;
    private final Soil soilType;
    private final int neededTemperature;
    private final boolean needsLight;
    private final int weeklyRequiredWater;

    public Plant(int id, String origin, String name, Soil soilType, int neededTemperature, boolean needsLight, int weeklyRequiredWater) {
        this.id = id;
        this.origin = origin;
        this.name = name;
        this.soilType = soilType;
        this.neededTemperature = neededTemperature;
        this.needsLight = needsLight;
        this.weeklyRequiredWater = weeklyRequiredWater;
    }

    public Plant(PlantBuilder builder) {
        this.id = builder.id;
        this.origin = builder.origin;
        this.name = builder.name;
        this.soilType = builder.soilType;
        this.neededTemperature = builder.neededTemperature;
        this.needsLight = builder.needsLight;
        this.weeklyRequiredWater = builder.weeklyRequiredWater;
    }

    public int getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getName() {
        return name;
    }

    public Soil getSoilType() {
        return soilType;
    }

    public int getNeededTemperature() {
        return neededTemperature;
    }

    public boolean isNeedsLight() {
        return needsLight;
    }

    public int getWeeklyRequiredWater() {
        return weeklyRequiredWater;
    }

    public static class PlantBuilder {
        private int id;
        private String origin;
        private String name;
        private Soil soilType;
        private int neededTemperature;
        private boolean needsLight;
        private int weeklyRequiredWater;

        public PlantBuilder() {
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSoilType(Soil soilType) {
            this.soilType = soilType;
        }

        public void setNeededTemperature(int neededTemperature) {
            this.neededTemperature = neededTemperature;
        }

        public void setNeedsLight(boolean needsLight) {
            this.needsLight = needsLight;
        }

        public void setWeeklyRequiredWater(int weeklyRequiredWater) {
            this.weeklyRequiredWater = weeklyRequiredWater;
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
        Plant plant = (Plant) o;
        return id == plant.id && neededTemperature == plant.neededTemperature && needsLight == plant.needsLight && weeklyRequiredWater == plant.weeklyRequiredWater && name.equals(plant.name) && soilType == plant.soilType;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        prime = 31 * prime + id;
        prime = 31 * prime + name.hashCode();
        prime = 31 * prime + soilType.hashCode();
        prime = 31 * prime + neededTemperature;
        prime = 31 * prime + (needsLight ? 1 : 0);
        prime = 31 * prime + weeklyRequiredWater;
        return prime;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", name='" + name + '\'' +
                ", soilType=" + soilType +
                ", neededTemperature=" + neededTemperature +
                ", needsLight=" + needsLight +
                ", weeklyRequiredWater=" + weeklyRequiredWater +
                '}';
    }
}
