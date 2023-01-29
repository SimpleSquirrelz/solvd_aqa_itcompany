package itcompany;

import itcompany.connection.ConnectionPool;
import itcompany.connection.MainConnectionPool;
import itcompany.model.Address;
import itcompany.model.Contact;
import itcompany.model.Phone;
import itcompany.service.impl.AddressServiceImpl;
import itcompany.service.impl.ContactServiceImpl;
import itcompany.service.impl.PhoneServiceImpl;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/db.connection.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ConnectionPool connectionPool = MainConnectionPool.create(prop.getProperty("db.url"), (String) prop.get("db.user"), prop.getProperty("db.password"));

//        validateAddressWorkflow();
//        validatePhoneWorkflow();

        validateContactWorkflow();
    }

    public static void validateContactWorkflow() {
        ContactServiceImpl contactService = new ContactServiceImpl();
        contactService.getAll().forEach(System.out::println);

        System.out.println("Creating new Contact with addresses and phones:");
        Contact contact = contactService.create(new Contact("Supername", "Supersurname",
                new ArrayList<Phone>() {
            {
                add(new Phone("+89123781293"));
                add(new Phone("+89123781294"));
                add(new Phone("+89123781296"));
            }
        }, new ArrayList<Address>() {
            {
                add(new Address());
                add(new Address());
            }
        }));

        System.out.println("\n\nCreated object:");
        System.out.println(contact);

        System.out.println("\n\nNew list of contacts .");
        contactService.getAll().forEach(System.out::println);

        contact.setSurname("Nuki");
        System.out.println("\n\nUpdated contact");
        System.out.println(contact);

        System.out.println("DELETE contact WITH ID: " + contact.getId());
        contactService.delete(contact.getId());
        System.out.println("\n\nNew list of phone after delete op.");
        contactService.getAll().forEach(System.out::println);
    }

    public static void validatePhoneWorkflow() {
        PhoneServiceImpl phoneService = new PhoneServiceImpl();
        phoneService.getAll().forEach(System.out::println);

        System.out.println("\n\nContact phones:");
        phoneService.getContactPhones(1L).forEach(System.out::println);

        Phone phone = phoneService.create(new Phone(1L, "+9949349392"));
        System.out.println("Created phones");
        System.out.println(phone);

        System.out.println("\n\nNew Contact phones:");
        phoneService.getContactPhones(1L).forEach(System.out::println);

        System.out.println("\n\nNew list of phones");
        phoneService.getAll().forEach(System.out::println);

        phone.setPhoneNumber("+380334546767");
        phoneService.update(phone);
        System.out.println(phoneService.get(phone.getId()));

        System.out.println("DELETE phone WITH ID: " + phone.getId());
        phoneService.getAll().forEach(System.out::println);
        phoneService.delete(phone.getId());
        System.out.println("\n\nNew list of phone after delete op.");
        phoneService.getAll().forEach(System.out::println);
    }

    public static void validateAddressWorkflow() {
        AddressServiceImpl addressService = new AddressServiceImpl();
        addressService.getAll().forEach(System.out::println);

        System.out.println("\n\nContact addresses:");
        addressService.getContactAddresses(1L).forEach(System.out::println);

        Address address = addressService.create(new Address(1L, "Country", "City", "Streeeeet", "Building"));
        System.out.println("Created address");
        System.out.println(address);

        System.out.println("\n\nNew Contact addresses:");
        addressService.getContactAddresses(1L).forEach(System.out::println);

        System.out.println("\n\nNew list of addresses");
        addressService.getAll().forEach(System.out::println);

        address.setCountry("SuperCOUNTRY");
        addressService.update(address);
        System.out.println(addressService.get(address.getId()));

        System.out.println("DELETE ADDRESS WITH ID: " + address.getId());
        addressService.getAll().forEach(System.out::println);
        addressService.delete(address.getId());
        System.out.println("\n\nNew list of addresses after delete op.");
        addressService.getAll().forEach(System.out::println);
    }
}
