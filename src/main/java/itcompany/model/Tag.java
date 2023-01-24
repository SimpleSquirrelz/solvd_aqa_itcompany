package itcompany.model;

public class Tag {
    private Long id;
    private Long taskId;
    private String name;

    public Tag(Long taskId, String name) {
        this.taskId = taskId;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + this.getId() +
                ", taskId=" + this.getTaskId() +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
