package com.example.verisoft;

import com.example.verisoft.automationTests.W3SchoolTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

 @SpringBootApplication
public class VerisoftApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(VerisoftApplication.class, args);
		W3SchoolTest w3SchoolTest = new W3SchoolTest();
		boolean isValid = w3SchoolTest.checkHtmlTables();
		System.out.println("is valid " + isValid);
		w3SchoolTest.closeDriver();
	}

}
