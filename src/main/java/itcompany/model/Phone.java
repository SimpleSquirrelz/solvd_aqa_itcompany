package itcompany.model;

public class Phone {
    private Long id;
    private Long contactId;
    private String phoneNumber;

    public Phone() {
        this.phoneNumber = "Phone number is missing";
    }

    public Phone(Long contactId, String phoneNumber) {
        this.contactId = contactId;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + this.getId() +
                ", contactId=" + this.getContactId() +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                '}';
    }
}
