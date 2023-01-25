package itcompany.xml;


import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ParseXML {
    public static void main(String[] args) {
        boolean schemeIsValid = validateXMLSchema("hierarchy.xsd", "hierarchy.xml");
        System.out.println(schemeIsValid ? "Scheme is valid!" : "Something went wrong, check it once more");
    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath){
        String xmlDirectoryPath = "src/main/resources/xml/";

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xmlDirectoryPath+xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlDirectoryPath+xmlPath)));
            return true;
        } catch (IOException | SAXException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
