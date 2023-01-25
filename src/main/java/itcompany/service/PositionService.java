package itcompany.service;

import itcompany.model.Address;
import itcompany.model.Phone;
import itcompany.model.Position;

import java.util.List;

public interface PositionService extends GenericService<Address, Long> {
    List<Position> getEmployeePositions(Long employeeId);
}
