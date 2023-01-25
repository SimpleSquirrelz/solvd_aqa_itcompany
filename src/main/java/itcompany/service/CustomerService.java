package itcompany.service;

import itcompany.model.Contact;
import itcompany.model.Customer;

import java.util.Optional;

public interface CustomerService extends GenericService<Customer, Long> {
    Optional<Contact> getUser(Long id);

}
