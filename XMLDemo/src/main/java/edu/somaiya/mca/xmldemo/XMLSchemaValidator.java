/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.somaiya.mca.xmldemo;

/**
 *
 * @author amard
 */
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XMLSchemaValidator {
    public static void main(String[] args) {
        try {
            // Create a SchemaFactory and specify XML Schema language
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            // Load the XML Schema from file           
            Schema schema = factory.newSchema(new File("employee.xsd"));
            
            // Create a Validator object for the Schema
            Validator validator = schema.newValidator();
            
            // Validate the XML document against the Schema
            validator.validate(new StreamSource(new File("employees.xml")));
            
            System.out.println("Validation successful: XML document is valid.");
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
