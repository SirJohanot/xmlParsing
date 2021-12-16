package com.epam.xmlparsing.parser;

import com.epam.xmlparsing.entity.Flower;
import com.epam.xmlparsing.entity.Plant;
import com.epam.xmlparsing.entity.Soil;
import com.epam.xmlparsing.entity.Tree;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SAXParsingTest {

    private static final SAXParsing PARSER=new SAXParsing();
    private static final String FILE_WITH_TWO_FLOWERS_AND_TWO_TREES="src/test/resources/plants.xml";

    @Test
    public void testShouldReturnListOfPlantsWhenThereAreBothTreesAndFlowersInFile() throws ParserException {
        //given
        Flower flower1=new Flower(1, null, "Rose", Soil.CLAY, 20, true, 1500, 40);
        Flower flower2=new Flower(2, "Persia", "Dandelion", Soil.SILT, 15, true, 750, 50);
        Tree tree1=new Tree(3, null, "Oak", Soil.CLAY, 5, false, 560, 30.0);
        Tree tree2=new Tree(4, "North America", "Paper Birch", Soil.SAND, 5, true, 430, 40.0);
        List<Plant> expectedList= Arrays.asList(flower1, flower2, tree1, tree2);
        //when
        List<Plant> actualList= PARSER.parse(FILE_WITH_TWO_FLOWERS_AND_TWO_TREES);
        //then
        Assert.assertEquals(expectedList, actualList);
    }
}
