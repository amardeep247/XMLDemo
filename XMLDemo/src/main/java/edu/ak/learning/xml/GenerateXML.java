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
public class GenerateXML {
    
    public static void main(String[] args) {
        
        // Step1 : create document
        // step2 : create root element
        // step3 : create child element
        // step4 : save the xml
        try{
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        
        Element rootElement = document.createElement("students");
        document.appendChild(rootElement);
        
        addStudent(document, rootElement,1);
        addStudent(document, rootElement,2);
        
        TransformerFactory factory = TransformerFactory.newInstance();
        factory.newTransformer().
                transform(new DOMSource(document), new StreamResult("new_students.xml"));        
        
        }catch(Exception ex){            
        }
    }
    
    public static void addStudent(Document document,Element rootElement,int id){
        Element student = document.createElement("student");
        
        Element idTag = document.createElement("id");
        student.appendChild(idTag);
        
        Text value = document.createTextNode(String.valueOf(id));
        idTag.appendChild(value);
        
        rootElement.appendChild(student);
        
        
    }
    
}
