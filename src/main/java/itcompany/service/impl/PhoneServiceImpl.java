package itcompany.service.impl;

import itcompany.dao.PhoneDAO;
import itcompany.dao.jdbc.PhoneDAOJDBC;
import itcompany.lib.Inject;
import itcompany.lib.Service;
import itcompany.model.Address;
import itcompany.model.Phone;
import itcompany.service.PhoneService;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Inject
    PhoneDAO phoneDAO = new PhoneDAOJDBC();

    @Override
    public Phone create(Phone element) {
        return phoneDAO.create(element);
    }

    @Override
    public Phone get(Long id) {
        return phoneDAO.get(id).get();
    }

    @Override
    public List<Phone> getAll() {
        return phoneDAO.getAll();
    }

    @Override
    public Phone update(Phone element) {
        return phoneDAO.update(element);
    }

    @Override
    public boolean delete(Long id) {
        return phoneDAO.delete(id);
    }

    @Override
    public List<Phone> getContactPhones(Long contactId) {
        return phoneDAO.getContactPhones(contactId);
    }
}
