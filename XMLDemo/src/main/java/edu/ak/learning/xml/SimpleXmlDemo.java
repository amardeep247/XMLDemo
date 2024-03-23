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
public class SimpleXmlDemo {
    public static void main(String[] args) throws Exception {
        
    // Create document
    Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

    // Create root element with attribute
     Element students = document.createElement("students");
     document.appendChild(students);
    
    addStudentNode(document, students,1,"ABC","A");
    addStudentNode(document, students,2,"XYZ","B");
    
    // Write to XML file
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    transformerFactory.newTransformer().transform(new DOMSource(document), new StreamResult("students.xml"));

    System.out.println("XML file created successfully!");
  }
    
    public static void addStudentNode(Document document,Element rootElement,int id,String name,String grade){
        
         Element student = document.createElement("student");         
         
         Element childNode = document.createElement("id");
         Text value = document.createTextNode(String.valueOf(id));
         childNode.appendChild(value);
         student.appendChild(childNode);
         
         childNode = document.createElement("name");
         value = document.createTextNode(name);
         childNode.appendChild(value);
         student.appendChild(childNode);
         
         childNode = document.createElement("grade");
         value = document.createTextNode(grade);
         childNode.appendChild(value);
         student.appendChild(childNode);
         
        rootElement.appendChild(student);
    }
}
