/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ak.learning.xml;

/**
 *
 * @author amard
 */
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class XMLValidatorDTD extends DefaultHandler {
    
    public static void main(String[] args) {
        String xmlFile = "students.xml"; 
        
        try {
            XMLValidatorDTD validator = new XMLValidatorDTD();
            validator.validate(xmlFile);
            System.out.println("Validation is sucessful!");
        } catch (Exception e) {
             System.out.println("Validation failed!");
            e.printStackTrace();
        }
    }

    public void validate(String xmlFile) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        SAXParser parser = factory.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        reader.setErrorHandler(this);

        reader.parse(new InputSource(xmlFile));
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
        throw new SAXException("Error encountered during validation");
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Fatal Error: " + e.getMessage());
        throw new SAXException("Fatal Error encountered during validation");
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }
}
