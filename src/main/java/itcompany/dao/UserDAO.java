package itcompany.dao;

import itcompany.model.Contact;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends GenericDAO<UserDAO, Long> {
    Optional<Contact> getContact(Long contactId);

    Optional<UserDAO> get(Long id);

    List<UserDAO> getAll();

    UserDAO update(UserDAO user);

    boolean delete(Long id);
}
