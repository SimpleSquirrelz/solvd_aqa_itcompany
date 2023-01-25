package itcompany.service;

import itcompany.model.Address;
import itcompany.model.Contact;

import java.util.Optional;

public interface UserService extends GenericService<Address, Long> {
    Optional<Contact> getContact(Long contactId);
}
