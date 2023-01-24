package itcompany.dao;

import itcompany.model.Customer;
import itcompany.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectDAO extends GenericDAO<Project, Long>{
    Optional<Customer> getCustomer(Long id);

    Optional<Project> get(Long id);

    List<Project> getAll();

    Project update(Project project);

    boolean delete(Long id);
}
