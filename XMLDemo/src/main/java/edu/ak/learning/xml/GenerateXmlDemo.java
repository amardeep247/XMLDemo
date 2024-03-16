/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ak.learning.xml;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 *
 * @author amard
 */
public class GenerateXmlDemo {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Create root element
            Element rootElement = doc.createElement("books");
            doc.appendChild(rootElement);

            // Add book elements
            addBook(doc, rootElement, "The complete reference JSP 2.0, Hanna", "Tata McGraw Hill");
            addBook(doc, rootElement, "Java Persistence With Hibernate", "Christian Bauer");
            addBook(doc, rootElement, "Spring In Action", "Craig Walls");

            // Write the content into XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("book.xml");
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void addBook(Document doc, Element rootElement, String title, String author) {
        Element book = doc.createElement("book");
        rootElement.appendChild(book);

        Element titleElement = doc.createElement("title");
        titleElement.appendChild(doc.createTextNode(title));
        book.appendChild(titleElement);

        Element authorElement = doc.createElement("author");
        authorElement.appendChild(doc.createTextNode(author));
        book.appendChild(authorElement);
    }
}
