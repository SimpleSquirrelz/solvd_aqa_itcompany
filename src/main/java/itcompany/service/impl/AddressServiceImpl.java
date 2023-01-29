package itcompany.service.impl;

import itcompany.dao.AddressDAO;
import itcompany.lib.Inject;
import itcompany.lib.Service;
import itcompany.model.Address;
import itcompany.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Inject
    private AddressDAO addressDao;


    @Override
    public List<Address> getContactAddresses(Long id) {
        return addressDao.getContactAddresses(id);
    }

    @Override
    public Address create(Address element) {
        return addressDao.create(element);
    }

    @Override
    public Address get(Long id) {
        return addressDao.get(id).get();
    }

    @Override
    public List<Address> getAll() {
        return addressDao.getAll();
    }

    @Override
    public Address update(Address element) {
        return addressDao.update(element);
    }

    @Override
    public boolean delete(Long id) {
        return addressDao.delete(id);
    }
}
