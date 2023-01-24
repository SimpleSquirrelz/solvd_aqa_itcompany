package itcompany.dao;

import itcompany.model.Employee;
import itcompany.model.User;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO extends GenericDAO<Employee, Long> {
    Optional<User> getUser(Long id);

    Optional<Employee> get(Long id);

    List<Employee> getAll();

    Employee update(Employee employee);

    boolean delete(Long id);
}
