package itcompany.dao;

import itcompany.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDAO extends GenericDAO<Contact, Long> {
    Optional<Contact> get (Long id);

    List<Contact> getAll();

    Contact update(Contact contact);

    boolean delete(Long id);
}
