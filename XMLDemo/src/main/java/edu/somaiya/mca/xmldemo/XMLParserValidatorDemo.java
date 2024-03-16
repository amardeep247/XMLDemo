package edu.somaiya.mca.xmldemo;


import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class XMLParserValidatorDemo {

    public static void main(String[] args) {
        String xmlFilePath = "students.xml";

        // Step 1: Parse and Validate XML
        parseAndValidateXML(xmlFilePath);

        // Step 2: Perform further processing if needed
    }

    private static void parseAndValidateXML(String xmlFilePath) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            // Create a DocumentBuilder with a custom ErrorHandler for validation errors
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new CustomErrorHandler());

            // Parse the XML file
            builder.parse(new File(xmlFilePath));
            System.out.println("XML parsing and validation successful.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Custom ErrorHandler to handle validation errors
    private static class CustomErrorHandler extends DefaultHandler {
        @Override
        public void error(SAXParseException e) throws SAXException {
            System.err.println("Validation Error: " + e.getMessage());
            throw e; // Stop parsing on validation error
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            System.err.println("Fatal Validation Error: " + e.getMessage());
            throw e; // Stop parsing on fatal validation error
        }
    }
}
