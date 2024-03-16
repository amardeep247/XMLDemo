/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ak.learning.xml;

/**
 *
 * @author amard
 */
import java.io.File;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DOMCreateExample {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element rootElement = document.createElement("students");
            document.appendChild(rootElement);

            Element studentElement = document.createElement("student");
            rootElement.appendChild(studentElement);

            Element idElement = document.createElement("id");
            idElement.appendChild(document.createTextNode("1"));
            studentElement.appendChild(idElement);

            Element nameElement = document.createElement("name");
            nameElement.appendChild(document.createTextNode("ABC"));
            studentElement.appendChild(nameElement);

            Element gradeElement = document.createElement("grade");
            gradeElement.appendChild(document.createTextNode("A"));
            studentElement.appendChild(gradeElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("new_students.xml"));
            transformer.transform(source, result);
            System.out.println("XML file created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

