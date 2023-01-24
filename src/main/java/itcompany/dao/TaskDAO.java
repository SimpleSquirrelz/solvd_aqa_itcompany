package itcompany.dao;

import itcompany.model.*;

import java.util.List;
import java.util.Optional;

public interface TaskDAO extends GenericDAO<Task, Long>{
    List<Task> getSubtasks (Long id);

    Optional<Project> getProject(Long id);

    List<Task> getProjectTasks(Long projectId);

    Optional<Employee> getAssignee(Long id);

    List<Task> getAssigneeTasks(Long assigneeId);

    Optional<Status> getStatus(Long id);

    List<Task> getTasksWithStatus(Long statusId);

    Optional<TypeDAO> getType(Long id);

    List<Task> getTasksWithType(Long id);

    Optional<Task> get(Long id);

    List<Task> getAll();

    Task update(Task task);

    boolean delete(Long id);
}
