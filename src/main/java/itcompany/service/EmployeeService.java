package itcompany.service;

import itcompany.model.Address;
import itcompany.model.User;

import java.util.List;
import java.util.Optional;

public interface EmployeeService extends GenericService<Address, Long> {
    Optional<User> getUser(Long id);
}
