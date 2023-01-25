package itcompany.service;

import itcompany.dao.TypeDAO;
import itcompany.model.*;

import java.util.List;
import java.util.Optional;

public interface TaskService extends GenericService<Address, Long> {
    List<Task> getSubtasks (Long id);

    Optional<Project> getProject(Long id);

    List<Task> getProjectTasks(Long projectId);

    Optional<Employee> getAssignee(Long id);

    List<Task> getAssigneeTasks(Long assigneeId);

    Optional<Status> getStatus(Long id);

    List<Task> getTasksWithStatus(Long statusId);

    Optional<TypeDAO> getType(Long id);

    List<Task> getTasksWithType(Long id);
}
