package itcompany.dao.jdbc;

import itcompany.dao.AddressDAO;
import itcompany.model.Address;
import itcompany.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressDAOJDBC implements AddressDAO {
    @Override
    public Address create(Address element) {
        String insertAddressQuery = "INSERT INTO address (contact_id, country, city, street, building) VALUES (?, ?, ?, ?, ?);";

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(insertAddressQuery,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, element.getContactId());
            statement.setString(2, element.getCountry());
            statement.setString(3, element.getCity());
            statement.setString(4, element.getStreet());
            statement.setString(5, element.getBuilding());
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
    public List<Address> getContactAddresses(Long contactId) {
        String selectAllAddressesQuery = "SELECT * FROM address WHERE contact_id = ?;";
        List<Address> addressList = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectAllAddressesQuery)) {
            statement.setLong(1, contactId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Address address = getAddressFromResultSet(resultSet);
                addressList.add(address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return addressList;
    }

    @Override
    public Optional<Address> get(Long id) {
        String selectAddressQuery = "SELECT * FROM address WHERE id = ?;";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectAddressQuery)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Address address = getAddressFromResultSet(resultSet);
                statement.close();
                return Optional.of(address);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Address> getAll() {
        String selectAllAddressesQuery = "SELECT * FROM address;";
        List<Address> addressList = new ArrayList<>();
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectAllAddressesQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Address address = getAddressFromResultSet(resultSet);
                addressList.add(address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return addressList;
    }

    @Override
    public Address update(Address address) {
        String updateAddressQuery = "UPDATE address SET contact_id = ?, country = ?, city = ?, street = ?, building = ? WHERE id = ?;";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateAddressQuery)) {
            statement.setLong(1, address.getContactId());
            statement.setString(2, address.getCountry());
            statement.setString(3, address.getCity());
            statement.setString(4, address.getStreet());
            statement.setString(5, address.getBuilding());
            statement.setLong(6, address.getId());
            statement.executeUpdate();
            statement.close();

            return address;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteAddressQuery = "DELETE FROM address WHERE id = ? ;";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteAddressQuery)) {
            statement.setLong(1, id);
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Address getAddressFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        Long contactId = resultSet.getLong("contact_id");
        String country = resultSet.getString("country");
        String city = resultSet.getString("city");
        String street = resultSet.getString("street");
        String building = resultSet.getString("building");
        Address address = new Address(contactId, country, city, street, building);
        address.setId(id);

        return address;
    }
}
