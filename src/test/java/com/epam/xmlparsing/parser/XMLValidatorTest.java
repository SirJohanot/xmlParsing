package com.epam.xmlparsing.parser;

import com.epam.xmlparsing.validation.XMLValidator;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

public class XMLValidatorTest {

    private static final XMLValidator VALIDATOR = new XMLValidator();
    private static final String FIRST_VALID_XML_FILE = "src/test/resources/plants.xml";
    private static final String FIRST_INVALID_XML_FILE = "src/test/resources/plants.xml";
    private static final String FIRST_XSD_FILE = "src/test/resources/plants.xsd";

    @Test
    public void testValidateShouldReturnTrueForAValidXmlXsdPair() throws IOException, SAXException {
        //given
        //when
        boolean actualIsValid = VALIDATOR.validate(FIRST_VALID_XML_FILE, FIRST_XSD_FILE);
        //then
        Assert.assertTrue(actualIsValid);
    }

    @Test
    public void testValidateShouldReturnFalseForAnInvalidXmlXsdPair() throws IOException, SAXException {
        //given
        //when
        boolean actualIsValid = VALIDATOR.validate(FIRST_INVALID_XML_FILE, FIRST_XSD_FILE);
        //then
        Assert.assertFalse(actualIsValid);
    }
}
