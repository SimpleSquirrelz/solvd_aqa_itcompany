package itcompany.xml.custom;

import itcompany.model.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import java.util.*;

public class EmployeeHandler extends DefaultHandler {

    private static final String ID = "id";
    private static final String SALARY = "salary";
    private static final String NAME = "name";
    private static final String USER = "user";
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String CONTACT = "contact";
    private static final String SURNAME = "surname";
    private static final String ADDRESSES = "addresses";
    private static final String ADDRESS = "address";
    private static final String CONTACT_ID = "contact_id";
    private static final String COUNTRY = "country";
    private static final String CITY = "city";
    private static final String STREET = "street";
    private static final String BUILDING = "building";
    private static final String PHONES = "phones";
    private static final String PHONE = "phone";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String POSITIONS = "positions";
    private static final String POSITION = "position";
    private static final String EMPLOYEE_ID = "employee_id";

    private boolean isAddress = false;
    private boolean isPhone = false;
    private boolean isContact = false;
    private boolean isUser = false;
    private boolean isPosition = false;

    private Employee employee;
    private StringBuilder elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }


    @Override
    public void startDocument() throws SAXException {
        employee = new Employee();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case ID,
                SALARY,
                USERNAME,
                EMAIL,
                PASSWORD,
                NAME,
                SURNAME,
                CONTACT_ID,
                CITY,
                COUNTRY,
                STREET,
                BUILDING,
                PHONE_NUMBER,
                EMPLOYEE_ID
                    -> elementValue = new StringBuilder();
            case ADDRESSES -> employee.setAddresses(new ArrayList<>());
            case ADDRESS -> {
                isAddress = true;
                employee.getAddresses().add(new Address());
            }
            case USER -> isUser = true;
            case CONTACT -> isContact = true;
            case PHONES -> employee.setPhones(new ArrayList<>());
            case PHONE -> {
                isPhone = true;
                employee.getPhones().add(new Phone());
            }
            case POSITIONS -> employee.setPositions(new LinkedHashSet<>());
            case POSITION -> {
                isPosition = true;
                employee.getPositions().add(new Position());
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case ID -> {
                if(isAddress)
                    latestAddress().setId(Long.parseLong(elementValue.toString()));
                else if(isPhone)
                    latestPhone().setId(Long.parseLong(elementValue.toString()));
                else if (isPosition)
                    latestPosition().setId(Long.parseLong(elementValue.toString()));
                else if (!isContact && !isUser)
                    employee.setId(Long.parseLong(elementValue.toString()));
            }
            case SALARY -> employee.setSalary(Float.parseFloat(elementValue.toString()));
            case USER -> isUser = false;
            case CONTACT ->  isContact = false;
            case ADDRESS -> isAddress = false;
            case PHONE -> isPhone = false;
            case USERNAME -> employee.setUsername(elementValue.toString());
            case EMAIL -> employee.setEmail(elementValue.toString());
            case PASSWORD -> employee.setPassword(elementValue.toString());
            case NAME -> {
                if(isPosition)
                    latestPosition().setName(elementValue.toString());
                else
                    employee.setName(elementValue.toString());
            }
            case SURNAME -> employee.setSurname(elementValue.toString());
            case CONTACT_ID -> {
                if(isAddress)
                    latestAddress().setContactId(Long.parseLong(elementValue.toString()));
                else if(isPhone)
                    latestPhone().setContactId(Long.parseLong(elementValue.toString()));
            }
            case CITY -> latestAddress().setCity(elementValue.toString());
            case COUNTRY -> latestAddress().setCountry(elementValue.toString());
            case STREET -> latestAddress().setStreet(elementValue.toString());
            case BUILDING -> latestAddress().setBuilding(elementValue.toString());
            case PHONE_NUMBER -> latestPhone().setPhoneNumber(elementValue.toString());
            case POSITION -> isPosition = false;
            case EMPLOYEE_ID -> latestPosition().setEmployeeId(Long.parseLong(elementValue.toString()));
        }
    }

    private Phone latestPhone() {
        List<Phone> phoneList = employee.getPhones();
        int latestPhoneIndex = phoneList.size() - 1;
        return phoneList.get(latestPhoneIndex);
    }

    private Position latestPosition() {
        List<Position> phoneList = employee.getPositions().stream().toList();
        int latestPhoneIndex = phoneList.size() - 1;
        return phoneList.get(latestPhoneIndex);
    }

    private Address latestAddress() {
        List<Address> addressList = employee.getAddresses();
        int latestAddressIndex = addressList.size() - 1;
        return addressList.get(latestAddressIndex);
    }

    public Employee getEmployee() {
        return employee;
    }
}
