package itcompany;

import itcompany.dao.jdbc.AddressDAOJDBC;
import itcompany.model.Address;
import itcompany.util.JDBCUtil;

public class Main {
    public static void main(String[] args) {
        JDBCUtil.getConnection();

        AddressDAOJDBC addressDAOJDBC = new AddressDAOJDBC();
        addressDAOJDBC.create(new Address(1L, "Country", "City", "Streeeeet", "Building"));
    }
}
