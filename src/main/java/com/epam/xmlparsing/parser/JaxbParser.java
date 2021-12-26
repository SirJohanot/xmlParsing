package com.epam.xmlparsing.parser;

import com.epam.xmlparsing.entity.Plant;
import com.epam.xmlparsing.entity.PlantsWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class JaxbParser implements Parser {
    @Override
    public List<Plant> parse(String filePath) throws JAXBException, FileNotFoundException {
        JAXBContext jc = JAXBContext.newInstance(PlantsWrapper.class);
        Unmarshaller u = jc.createUnmarshaller();
        FileReader reader = new FileReader(filePath);
        PlantsWrapper plantsWrapper = (PlantsWrapper) u.unmarshal(reader);
        return plantsWrapper.getPlants();
    }
}
