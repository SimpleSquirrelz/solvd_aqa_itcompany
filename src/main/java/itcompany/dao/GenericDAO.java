package itcompany.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, V> {
    T create(T element);

    Optional<T> get(V id);

    List<T> getAll();

    T update(T element);

    boolean delete(V id);
}