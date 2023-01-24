package itcompany.dao;

import itcompany.model.Position;

import java.util.List;
import java.util.Optional;

public interface PositionDAO extends GenericDAO<Position, Long> {
    List<Position> getEmployeePositions(Long employeeId);

    Optional<Position> get(Long id);

    List<Position> getAll();

    Position update(Position position);

    boolean delete(Long id);
}
