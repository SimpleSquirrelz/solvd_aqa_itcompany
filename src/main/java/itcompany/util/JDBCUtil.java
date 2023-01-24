package itcompany.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/it_company";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123123qweqwe";

    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            System.out.println(conn != null? "Connected" : "Connection FAILED");
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
