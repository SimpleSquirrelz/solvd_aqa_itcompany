package itcompany.dao;

import itcompany.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressDAO extends GenericDAO<Address, Long> {
    List<Address> getContactAddresses(Long contactId);

    Optional<Address> get(Long id);

    List<Address> getAll();

    Address update(Address address);

    boolean delete(Long id);
}
