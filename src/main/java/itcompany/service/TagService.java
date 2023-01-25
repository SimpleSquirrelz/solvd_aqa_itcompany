package itcompany.service;

import itcompany.model.Address;
import itcompany.model.Tag;

import java.util.List;

public interface TagService extends GenericService<Address, Long> {
    List<Tag> getTaskTags(Long taskId);
}
