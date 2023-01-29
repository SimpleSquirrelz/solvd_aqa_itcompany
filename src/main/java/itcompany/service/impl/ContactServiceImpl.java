package itcompany.service.impl;

import itcompany.dao.ContactDAO;
import itcompany.dao.jdbc.ContactDAOJDBC;
import itcompany.lib.Inject;
import itcompany.lib.Service;
import itcompany.model.Contact;
import itcompany.service.ContactService;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Inject
    private ContactDAO contactDAO = new ContactDAOJDBC();

    @Override
    public Contact create(Contact element) {
        return contactDAO.create(element);
    }

    @Override
    public Contact get(Long id) {
        return contactDAO.get(id).get();
    }

    @Override
    public List<Contact> getAll() {
        return contactDAO.getAll();
    }

    @Override
    public Contact update(Contact element) {
        return contactDAO.update(element);
    }

    @Override
    public boolean delete(Long id) {
        return contactDAO.delete(id);
    }
}
