package itcompany.xml;

import itcompany.model.Employee;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class EmployeeParserXML {
    public Employee parse(String path) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        EmployeeHandler handler = new EmployeeHandler();

        try {
            SAXParser parser = factory.newSAXParser();
            File file = new File(path);
            parser.parse(file, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        return handler.getEmployee();
    }
}
