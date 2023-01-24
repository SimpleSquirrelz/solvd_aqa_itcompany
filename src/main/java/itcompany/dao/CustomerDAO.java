package itcompany.dao;

import itcompany.model.Contact;
import itcompany.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO extends GenericDAO<Customer, Long> {
    Optional<Contact> getUser(Long id);

    Optional<Customer> get(Long id);

    List<Customer> getAll();

    Customer update (Customer customer);

    boolean delete(Long id);
}
