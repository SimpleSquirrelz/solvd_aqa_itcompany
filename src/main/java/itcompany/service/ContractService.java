package itcompany.service;

import itcompany.model.Contract;
import itcompany.model.Customer;
import itcompany.model.Employee;
import itcompany.model.Project;

import java.util.List;
import java.util.Optional;

public interface ContractService extends GenericService<Contract, Long> {
    Optional<Customer> getCustomer(Long id);

    List<Contract> getCustomerContracts(Long customerId);

    Optional<Project> getProject(Long id);

    List<Contract> getProjectContracts(Long projectId);

    Optional<Employee> getEmployee(Long id);

    List<Contract> getEmployeeContracts(Long employeeId);
}
