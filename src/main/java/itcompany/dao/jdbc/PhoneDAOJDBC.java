package itcompany.dao.jdbc;

import itcompany.dao.PhoneDAO;
import itcompany.model.Address;
import itcompany.model.Phone;
import itcompany.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PhoneDAOJDBC implements PhoneDAO {
    @Override
    public Phone create(Phone element) {
        String insertPhoneQuery = "INSERT INTO phone (contact_id, phone_number) VALUES (?, ?);";

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(insertPhoneQuery,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, element.getContactId());
            statement.setString(2, element.getPhoneNumber());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            element.setId(resultSet.getLong(1));
            statement.close();

            return element;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Phone> getContactPhones(Long contactId) {
        String selectAllAddressesQuery = "SELECT * FROM phone WHERE contact_id = ?;";
        List<Phone> phonesList = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectAllAddressesQuery)) {
            statement.setLong(1, contactId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Phone phone = getPhoneFromResultSet(resultSet);
                phonesList.add(phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return phonesList;
    }

    @Override
    public Optional<Phone> get(Long id) {
        String selectPhoneQuery = "SELECT * FROM phone WHERE id = ?;";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectPhoneQuery)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Phone phone = getPhoneFromResultSet(resultSet);
                statement.close();
                return Optional.of(phone);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Phone> getAll() {
        String selectAllAddressesQuery = "SELECT * FROM phone;";
        List<Phone> phonesList = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectAllAddressesQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Phone phone = getPhoneFromResultSet(resultSet);
                phonesList.add(phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return phonesList;
    }

    @Override
    public Phone update(Phone phone) {
        String updateAddressQuery = "UPDATE phone SET contact_id = ?, phone_number = ? WHERE id = ?;";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateAddressQuery)) {
            statement.setLong(1, phone.getContactId());
            statement.setString(2, phone.getPhoneNumber());
            statement.setLong(3, phone.getId());
            statement.executeUpdate();
            statement.close();

            return phone;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteAddressQuery = "DELETE FROM phone WHERE id = ?;";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteAddressQuery)) {
            statement.setLong(1, id);
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Phone getPhoneFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        Long contactId = resultSet.getLong("contact_id");
        String phoneNumber = resultSet.getString("phone_number");
        Phone phone = new Phone(contactId, phoneNumber);
        phone.setId(id);

        return phone;
    }
}
