package itcompany.service;

import itcompany.model.Address;

import java.util.List;

public interface AddressService extends GenericService<Address, Long> {
    List<Address> getContactAddresses(Long id);
}
