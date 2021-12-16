package com.epam.xmlparsing.parser;

import com.epam.xmlparsing.entity.Flower;
import com.epam.xmlparsing.entity.Plant;
import com.epam.xmlparsing.entity.Soil;
import com.epam.xmlparsing.entity.Tree;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PlantHandler extends DefaultHandler {

    private static final String PLANTS="plants";
    private static final String TREE="tree";
    private static final String FLOWER="flower";
    private static final String ID="id";
    private static final String ORIGIN="origin";
    private static final String NAME="name";
    private static final String SOIL_TYPE="soilType";
    private static final String GROWING_TIPS="growingTips";
    private static final String NEEDED_TEMPERATURE="neededTemperature";
    private static final String NEEDS_LIGHT="needsLight";
    private static final String WEEKLY_REQUIRED_WATER="weeklyRequiredWater";
    private static final String PETAL_NUMBER="petalNumber";
    private static final String TRUNK_DIAMETER="trunkDiameter";

    List<Plant> plants;
    StringBuilder bufferedString;
    Tree bufferedTree;
    Flower bufferedFlower;
    Plant currentPlant;

    public PlantHandler(){
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case PLANTS:
                plants=new ArrayList<>();
                break;
            case TREE:
                bufferedTree=new Tree();
                parseAttributes(bufferedTree, attributes);
                currentPlant=bufferedTree;
                break;
            case FLOWER:
                bufferedFlower=new Flower();
                parseAttributes(bufferedFlower, attributes);
                currentPlant=bufferedFlower;
                break;
            case NAME:
            case SOIL_TYPE:
            case NEEDED_TEMPERATURE:
            case NEEDS_LIGHT:
            case WEEKLY_REQUIRED_WATER:
            case PETAL_NUMBER:
            case TRUNK_DIAMETER:
                bufferedString=new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case TREE:
               plants.add(bufferedTree);
                break;
            case FLOWER:
                plants.add(bufferedFlower);
                break;
            case NAME:
                String name=bufferedString.toString();
                currentPlant.setName(name);
                break;
            case SOIL_TYPE:
                String soilTypeLine=bufferedString.toString();
                Soil soilType=Soil.valueOf(soilTypeLine);
                currentPlant.setSoilType(soilType);
                break;
            case NEEDED_TEMPERATURE:
                String neededTemperatureLine=bufferedString.toString();
                int neededTemperature=Integer.parseInt(neededTemperatureLine);
                currentPlant.setNeededTemperature(neededTemperature);
                break;
            case NEEDS_LIGHT:
                String needsLightLine=bufferedString.toString();
                boolean needsLight=Boolean.parseBoolean(needsLightLine);
                currentPlant.setNeedsLight(needsLight);
                break;
            case WEEKLY_REQUIRED_WATER:
                String weeklyRequiredWaterLine=bufferedString.toString();
                int weeklyRequiredWater=Integer.parseInt(weeklyRequiredWaterLine);
                currentPlant.setWeeklyRequiredWater(weeklyRequiredWater);
                break;
            case PETAL_NUMBER:
                String petalNumberLine=bufferedString.toString();
                int petalNumber=Integer.parseInt(petalNumberLine);
                bufferedFlower.setPetalNumber(petalNumber);
                break;
            case TRUNK_DIAMETER:
                String trunkDiameterLine=bufferedString.toString();
                double trunkDiameter=Double.parseDouble(trunkDiameterLine);
                bufferedTree.setTrunkDiameter(trunkDiameter);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bufferedString==null){
            bufferedString=new StringBuilder();
        } else{
            bufferedString.append(ch, start, length);
        }
    }

    private void parseAttributes(Plant destination, Attributes attributes){
        for (int i=0;i<attributes.getLength();i++) {
            switch (attributes.getLocalName(i)) {
                case ID:
                    String idLine=attributes.getValue(i);
                    int id = Integer.parseInt(idLine);
                    destination.setId(id);
                    break;
                case ORIGIN:
                    String origin = attributes.getValue(i);
                    destination.setOrigin(origin);
                    break;
            }
        }
    }

    List<Plant> getPlants(){
        return plants;
    }
}
