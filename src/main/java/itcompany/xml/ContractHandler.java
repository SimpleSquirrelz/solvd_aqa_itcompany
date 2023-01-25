package itcompany.xml;

import itcompany.model.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ContractHandler extends DefaultHandler {

    private static final String ID = "id";
    private static final String PROJECT = "project";
    private static final String NAME = "name";
    private static final String CUSTOMER = "customer";
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

    private Contract contract;
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
        contract = new Contract();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case ID:
            case NAME:
            case USERNAME:
            case EMAIL:
            case PASSWORD:
            case SURNAME:
            case CONTACT_ID:
            case COUNTRY:
            case CITY:
            case STREET:
            case BUILDING:
            case PHONE_NUMBER:
                elementValue = new StringBuilder();
                break;
            case PROJECT:
                contract.setProject(new Project());
                break;
            case CUSTOMER:
                contract.setCustomer(new Customer());
                break;
            case USER:
                contract.getCustomer().setUser(new User());
                break;
            case CONTACT:
                contract.getCustomer();
            case ADDRESSES:
                contract.getCustomer().setAddresses(new ArrayList<>());
            case ADDRESS:
                contract.getCustomer().getAddresses().add(new Address());
            case PHONES:
                contract.getCustomer().setPhones(new ArrayList<>());
            case PHONE:
                contract.getCustomer().getPhones().add(new Phone());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case COUNTRY:
                latestAddress().setCountry(elementValue.toString());
                break;
            case CITY:
                latestAddress().setCity(elementValue.toString());
                break;
            case STREET:
                latestAddress().setStreet(elementValue.toString());
                break;
            case BUILDING:
                latestAddress().setBuilding(elementValue.toString());
                break;
        }
    }

    private Phone latestPhone() {
        List<Phone> phoneList = contract.getCustomer().getPhones();
        int latestPhoneIndex = phoneList.size() - 1;
        return phoneList.get(latestPhoneIndex);
    }

    private Address latestAddress() {
        List<Address> addressList = contract.getCustomer().getAddresses();
        int latestAddressIndex = addressList.size() - 1;
        return addressList.get(latestAddressIndex);
    }

    public Contract getContract() {
        return contract;
    }
}
