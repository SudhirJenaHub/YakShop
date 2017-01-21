package com.xebia.yakshop.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.xebia.yakshop.bean.LabYak;

public class XMLReader {
	
	/**
	 * Reads the supplied XML and extract data bean
	 * @param xmlFilePath
	 * @return List
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static List<LabYak> readXML(String xmlFilePath) throws ParserConfigurationException, SAXException, IOException {
		
		List<LabYak> labYakList = new ArrayList<LabYak>();
		
		// Get File Input Stream
		//InputStream xmlFile = XMLReader.class.getResourceAsStream(xmlFilePath);
		
		File xmlFile = new File(xmlFilePath);
		
		Document document = getXMLDocument(xmlFile);
		
		NodeList nl = document.getElementsByTagName("labyak");
		
		for(int i = 0; i < nl.getLength(); i++) {
			Node nd = nl.item(i);
			if(nd.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nd ;
				String name = element.getAttribute("name");
				float age =  Float.parseFloat(element.getAttribute("age"));
				String sex = element.getAttribute("sex");
				LabYak.Sex yakSex = (sex.equalsIgnoreCase("f")) ? LabYak.Sex.FEMALE : LabYak.Sex.MALE;
				
				LabYak yak = new LabYak(i, name,age,yakSex);
				
				labYakList.add(yak);
			}
		}
		
		
		return labYakList;
	}
	
	/**
	 * Get the input Stream and return the XML Document
	 * 
	 * @param xmlFile
	 * @return
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static Document getXMLDocument(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory dfd = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dfd.newDocumentBuilder();
		
		Document doc = db.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		return doc;
	}

}
