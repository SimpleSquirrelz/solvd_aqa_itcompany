package itcompany.dao;

import itcompany.model.*;

import java.util.List;
import java.util.Optional;

public interface ContractDAO extends GenericDAO<Contract, Long> {
    Optional<Customer> getCustomer(Long id);

    List<Contract> getCustomerContracts(Long customerId);

    Optional<Project> getProject(Long id);

    List<Contract> getProjectContracts(Long projectId);

    Optional<Employee> getEmployee(Long id);

    List<Contract> getEmployeeContracts(Long employeeId);

    Optional<Contract> get(Long id);

    List<Contract> getAll();

    Contract update(Contract contract);

    boolean delete(Long id);
}
