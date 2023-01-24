package itcompany.model;

import java.util.List;
import java.util.Set;

public class Task {
    private Long id;
    private String name;
    private String description;
    private Project project;
    private List<Task> subTasks;
    private Employee assignee;
    private Type type;
    private Status status;
    private Set<Tag> tags;

    public Task(String name, String description, Project project, List<Task> subTasks, Employee assignee, Type type, Status status, Set<Tag> tags) {
        this.name = name;
        this.description = description;
        this.project = project;
        this.subTasks = subTasks;
        this.assignee = assignee;
        this.type = type;
        this.status = status;
        this.tags = tags;
    }

    public Task(String name, String description, Project project, Employee assignee, Type type, Status status, Set<Tag> tags) {
        this.name = name;
        this.description = description;
        this.project = project;
        this.assignee = assignee;
        this.type = type;
        this.status = status;
        this.tags = tags;
    }

    public Task(String name, String description, Project project, Status status) {
        this.name = name;
        this.description = description;
        this.project = project;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public void setAssignee(Employee assignee) {
        this.assignee = assignee;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", project=" + project +
                ", subTasks=" + subTasks +
                ", assignee=" + assignee +
                ", type=" + type +
                ", status=" + status +
                ", tags=" + tags +
                '}';
    }
}
