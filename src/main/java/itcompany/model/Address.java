package itcompany.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Address {
    private Long id;
    private Long contactId;
    private String country;
    private String city;
    private String street;
    private String building;

    public Address() {
        this.contactId = 0L;
        this.country = "Country is missing";
        this.city = "City is missing";
        this.street = "Street is missing";
        this.building = "Building is missing";
    }

    public Address(Long contactId, String country, String city, String street, String building) {
        this.contactId = contactId;
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    public Address(String country, String city, String street, String building) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    @JsonGetter("contact_id")
    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    @JsonGetter("country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonGetter("city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @JsonGetter("street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @JsonGetter("building")
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + this.getId() + '\'' +
                ", contact id='" + this.getContactId() + '\'' +
                ", country='" + this.getCountry() + '\'' +
                ", city='" + this.getCity() + '\'' +
                ", street='" + this.getStreet() + '\'' +
                ", building='" + this.getBuilding() + '\'' +
                '}';
    }
}
