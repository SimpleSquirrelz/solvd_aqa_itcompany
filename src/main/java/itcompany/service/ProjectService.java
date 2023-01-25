package itcompany.service;

import itcompany.model.Address;
import itcompany.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ProjectService extends GenericService<Address, Long> {
    Optional<Customer> getCustomer(Long id);
}
