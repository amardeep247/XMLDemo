/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.somaiya.mca.xmldemo;

/**
 *
 * @author amard
 */
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SimpleSAXParser {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse("students.xml", new StudentHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class StudentHandler extends DefaultHandler {
    boolean isName = false;
    boolean isGrade = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("name")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("grade")) {
            isGrade = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isName) {
            System.out.println("Student Name: " + new String(ch, start, length));
            isName = false;
        } else if (isGrade) {
            System.out.println("Student Grade: " + new String(ch, start, length));
            isGrade = false;
        }
    }
}
