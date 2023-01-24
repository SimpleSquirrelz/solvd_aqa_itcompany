package itcompany.dao;

import itcompany.model.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneDAO extends GenericDAO<Phone, Long>{
    List<Phone> getContactPhones(Long contactId);

    Optional<Phone> get(Long id);

    List<Phone> getAll();

    Phone update(Phone phone);

    boolean delete(Long id);
}
