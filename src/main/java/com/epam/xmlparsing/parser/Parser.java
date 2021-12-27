package com.epam.xmlparsing.parser;

import com.epam.xmlparsing.entity.Plant;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Parser {

    List<Plant> parse(String filePath) throws ParserException;
}
