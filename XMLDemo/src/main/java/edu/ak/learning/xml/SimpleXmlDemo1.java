/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ak.learning.xml;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
/**
 *
 * @author amard
 */
public class SimpleXmlDemo1 {
    public static void main(String[] args) throws Exception {
    // Create document
    Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

    // Create root element with attribute
    Element student = document.createElement("student");
    student.setAttribute("id", "1");
    document.appendChild(student);

    // Create child elements with nested text nodes
    Element title = document.createElement("course");
    Text titleText = document.createTextNode("MCA");
    title.appendChild(titleText);
    student.appendChild(title);   

    // Add comments
    student.appendChild(document.createComment("We are learning about XMLs"));

    // Write to XML file
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    transformerFactory.newTransformer().transform(new DOMSource(document), new StreamResult("students.xml"));

    System.out.println("XML file created successfully!");
  }
}
