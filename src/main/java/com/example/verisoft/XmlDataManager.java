package com.example.verisoft;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlDataManager {

    public static String LOCAL_DIRECTORY_PATH = "src\\main\\resources\\values.xml";

    public String getDataFromXml(String keyName) {
        try {
            File configXmlFile = new File(LOCAL_DIRECTORY_PATH);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = null;
            assert dBuilder != null;
            doc = dBuilder.parse(configXmlFile);
            if (doc != null) {
                doc.getDocumentElement().normalize();
            }
            assert doc != null;
            return doc.getElementsByTagName(keyName).item(0).getTextContent();
        } catch (Exception e) {
            // TODO before all tests check that xml is valid
            throw new RuntimeException("The xml is not valid" + e.getMessage());
        }
    }
}
