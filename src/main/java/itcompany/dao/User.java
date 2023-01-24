package itcompany.dao;

import itcompany.model.Contact;

import java.util.List;
import java.util.Optional;

public interface User extends GenericDAO<User, Long> {
    Optional<Contact> getContact(Long contactId);

    Optional<User> get(Long id);

    List<User> getAll();

    User update(User user);

    boolean delete(Long id);
}
