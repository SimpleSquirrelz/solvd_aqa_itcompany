package itcompany.dao;

import itcompany.model.Status;

import java.util.List;
import java.util.Optional;

public interface StatusDAO extends GenericDAO<Status, Long>{
    Optional<Status> get(Long id);

    List<Status> getAll();

    Status update(Status status);

    boolean delete(Long id);
}
