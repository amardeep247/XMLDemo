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
public class GenXML {
    public static void main(String[] args) {
        
        //Create a document
        //Create a root element
        //Create a child element
        //Save the xml
        try{
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            
            Element rootElement = doc.createElement("students");
            doc.appendChild(rootElement);
            
          
            addChildElement(doc, rootElement,1,"ABC","A");
            addChildElement(doc, rootElement,2,"XYZ","B");
           
          
            
            TransformerFactory factory = TransformerFactory.newInstance();
            factory.newTransformer().transform(new DOMSource(doc), new StreamResult("students.xml"));
        }catch(Exception ex){
            System.out.println("Exception:"+ex.getMessage());
        }
    }
    
    public static void addChildElement(Document doc,Element rootElement,int id,String name,String grade){
        
          Element student = doc.createElement("student");
          
          Element childElement = doc.createElement("id");
          Text value = doc.createTextNode(String.valueOf(id));
          childElement.appendChild(value);
          student.appendChild(childElement);           
          
          childElement = doc.createElement("name");
          value = doc.createTextNode(name);
          childElement.appendChild(value);
          student.appendChild(childElement);           
          
          childElement = doc.createElement("grade");
          value = doc.createTextNode(grade);
          childElement.appendChild(value);  
          student.appendChild(childElement);           
                
                    
          
          rootElement.appendChild(student);
    }
    
}
