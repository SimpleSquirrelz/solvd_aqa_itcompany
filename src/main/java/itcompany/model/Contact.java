package itcompany.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@JsonRootName(value = "contact")
@JsonTypeName("contact")
@JsonSubTypes({
        @JsonSubTypes.Type(value = User.class, name = "user"),
})
public class Contact {
    private Long id;
    private String name;
    private String surname;
    private List<Phone> phones = new ArrayList<>();
    private List<Address> addresses = new ArrayList<>();

    public Contact() {
        this.name = "Name is missing";
        this.surname = "Surname is missing";
    }

    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Contact(String name, String surname, List<Phone> phones, List<Address> addresses) {
        this.name = name;
        this.surname = surname;
        this.phones.addAll(phones);
        this.addresses.addAll(addresses);
    }

    @XmlElement
    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    @JsonGetter("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    @JsonGetter("surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlElement
    @JsonGetter("phones")
    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @XmlElement
    @JsonGetter("addresses")
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + this.getId() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", surname='" + this.getSurname() + '\'' +
                ", phones=" + this.getPhones().toString() +
                ", addresses=" + this.getAddresses().toString() +
                '}';
    }
}
