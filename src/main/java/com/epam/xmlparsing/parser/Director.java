package com.epam.xmlparsing.parser;

import com.epam.xmlparsing.entity.Plant;
import com.epam.xmlparsing.validation.XMLValidator;
import org.w3c.dom.Element;

import java.util.List;

public class Director {

    private final Parser parser;
    private final XMLValidator validator;

    public Director(Parser parser, XMLValidator xmlValidator){
        this.parser=parser;
        this.validator=xmlValidator;
    }

    List<Plant> parse(String filePath){
        return null;
    }
}
