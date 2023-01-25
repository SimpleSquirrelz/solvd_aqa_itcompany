package itcompany.service;

import itcompany.model.Address;
import itcompany.model.Phone;

import java.util.List;

public interface PhoneService extends GenericService<Address, Long> {
    List<Phone> getContactPhones(Long contactId);
}
