package itcompany.xml;

import itcompany.model.Address;
import itcompany.model.Employee;
import itcompany.model.Phone;
import itcompany.model.Position;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class JAXBParseXML {
    public static void main(String[] args) {
        try {
            generateXML();
            parseXML();
        } catch (FileNotFoundException | JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void parseXML () throws JAXBException {
        File file = new File("./src/main/resources/xml/generatedEmployee.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Employee employee = (Employee) jaxbUnmarshaller.unmarshal(file);
        System.out.println(employee);
    }

    public static void generateXML() throws FileNotFoundException, JAXBException {
        JAXBContext contextObj = JAXBContext.newInstance(Employee.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        LinkedHashSet<Position> positions = new LinkedHashSet<>();

        var position = new Position(1L, "big boss");
        position.setId(1L);
        positions.add(position);

        position = new Position(2L, "QA");
        position.setId(2L);
        positions.add(position);

        List<Address> addressList = new ArrayList<>();

        var address = new Address(333L, "Estonia", "Tartu", "Raaya", "3");
        address.setId(444L);
        addressList.add(address);

        address = new Address(333L, "Norway", "Oslo", "Akersgata", "2");
        address.setId(444L);
        addressList.add(address);


        List<Phone> phoneList = new ArrayList<>();

        var phone = new Phone(333L, "+372123232");
        phone.setId(666L);
        phoneList.add(phone);

        phone = new Phone(333L, "+3801232323");
        phone.setId(777L);

        Employee emp1 = new Employee(addressList, phoneList, positions,
                "MyNameIs",
                "Eminem",
                "Username",
                "someemail@gmail.com",
                "password",
                2000);

        marshallerObj.marshal(emp1, new FileOutputStream("./src/main/resources/xml/generatedEmployee.xml"));
    }
}
