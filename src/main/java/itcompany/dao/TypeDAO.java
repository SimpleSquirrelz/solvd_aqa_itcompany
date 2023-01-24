package itcompany.dao;

import itcompany.model.Type;

import java.util.List;
import java.util.Optional;

public interface TypeDAO extends GenericDAO<Type, Long> {
    Optional<Type> get(Long id);

    List<Type> getAll();

    Type update(Type type);

    boolean delete(Long id);
}
