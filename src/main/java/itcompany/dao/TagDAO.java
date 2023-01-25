package itcompany.dao;

import itcompany.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagDAO extends GenericDAO<Tag, Long>{
    List<Tag> getTaskTags(Long taskId);

    Optional<Tag> get(Long id);

    List<Tag> getAll();

    Tag update(Tag tag);

    boolean delete(Long id);
}
