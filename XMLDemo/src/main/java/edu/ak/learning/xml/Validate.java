/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ak.learning.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author amard
 */
public class Validate extends DefaultHandler {
 
    public static void main(String[] args) {
        
        Validate val = new Validate();
        val.validate();
      
    }
    
    public void validate(){
        try{
         String xmlFile = "students1.xml"; 
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        SAXParser parser = factory.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        reader.setErrorHandler(this);

        reader.parse(new InputSource(xmlFile));
        }catch(Exception ex){
            System.out.println("validateion falied");
            ex.printStackTrace();
        }
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
         System.out.println("Error: " + e.getMessage());
        throw new SAXException("Error encountered during validation");
    }

  
    
    
}
