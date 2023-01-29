package itcompany.dao.jdbc;

import itcompany.dao.ContactDAO;
import itcompany.model.Address;
import itcompany.model.Contact;
import itcompany.model.Phone;
import itcompany.service.impl.AddressServiceImpl;
import itcompany.service.impl.PhoneServiceImpl;
import itcompany.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactDAOJDBC implements ContactDAO {
    @Override
    public Contact create(Contact element) {
        String insertAddressQuery = "INSERT INTO contact (name, surname) VALUES (?, ?);";

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(insertAddressQuery,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, element.getName());
            statement.setString(2, element.getSurname());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            element.setId(resultSet.getLong(1));
            statement.close();

            element.getAddresses().forEach(address -> {
                address.setContactId(element.getId());
                new AddressServiceImpl().create(address);
            });
            element.getPhones().forEach(phone -> {
                phone.setContactId(element.getId());
                new PhoneServiceImpl().create(phone);
            });

            return element;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Contact> get(Long id) {
        String selectContactQuery = "SELECT * FROM contact WHERE id = ?;";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectContactQuery)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Contact contact = getContactFromResultSet(resultSet);
                statement.close();
                return Optional.of(contact);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Contact> getAll() {
        String selectAllAddressesQuery = "SELECT * FROM contact;";
        List<Contact> contactList = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectAllAddressesQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Contact contact = getContactFromResultSet(resultSet);
                contactList.add(contact);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contactList;
    }

    @Override
    public Contact update(Contact contact) {
        String updateContactQuery = "UPDATE contact SET name = ?, surname = ? WHERE id = ?;";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateContactQuery)) {
            statement.setString(1, contact.getName());
            statement.setString(2, contact.getSurname());
            statement.executeUpdate();
            statement.close();

            contact.getAddresses().forEach(address -> new AddressServiceImpl().update(address));
            contact.getPhones().forEach(phone -> new PhoneServiceImpl().update(phone));

            return contact;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteAddressQuery = "DELETE FROM contact WHERE id = ? ;";

        AddressServiceImpl addressService = new AddressServiceImpl();
        addressService.getContactAddresses(id).forEach(address -> addressService.delete(address.getId()));

        PhoneServiceImpl phoneService = new PhoneServiceImpl();
        phoneService.getContactPhones(id).forEach(phone -> phoneService.delete(phone.getId()));

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteAddressQuery)) {
            statement.setLong(1, id);
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Contact getContactFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");

        List<Address> addresses = new AddressServiceImpl().getContactAddresses(id);
        List<Phone> phones = new PhoneServiceImpl().getContactPhones(id);


        Contact contact = new Contact(name, surname, phones, addresses);
        contact.setId(id);

        return contact;
    }
}
