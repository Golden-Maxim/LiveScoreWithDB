package db;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;

public class DBConnection {
    // JDBC URL, username, and password of PostgreSQL server
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        // Establish a connection
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the PostgreSQL server successfully!!");
            System.out.println(connection);
            // Perform database operations here
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public static Connection connectToPostgresDataBase(String dbName) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL + dbName, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully!");
        } catch (SQLException e) {
            System.err.println("Connection failure: " + e.getMessage());
        }
        return connection;
    }

    public static void createTable(Connection conn, String taleName) {
        Statement statement;
        try {
            String query = "create table " + taleName + "(empid SERIAL, name varchar(200), address varchar(200), primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("table created!!!");
        } catch (Exception e) {

        }
    }

    public static void insertRow(Connection conn, String tableName, String name, String address) {
        Statement statement;
        try {
            String query = String.format("insert into %s(name, address) values('%s', '%s')", tableName, name, address);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted!!!");
        } catch (Exception e) {

        }

    }

    public static void showData(Connection conn, String tableName) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("SELECT * FROM %s", tableName);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("empid") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.println(rs.getString("address") + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void updateData(Connection conn, String tableName, String oldName, String newName) {
        Statement statement;
        try {
            String query = String.format("update %s set name='%s' where name='%s'", tableName, newName, oldName);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void searchByName(Connection conn, String tableName, String name) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s where name='%s'", tableName, name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("empid") + StringUtils.SPACE);
                System.out.print(rs.getString("name") + StringUtils.SPACE);
                System.out.println(rs.getString("address") + StringUtils.SPACE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void searchByID(Connection conn, String tableName, int id) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s where empid=%s", tableName, id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("empid") + StringUtils.SPACE);
                System.out.print(rs.getString("name") + StringUtils.SPACE);
                System.out.println(rs.getString("address") + StringUtils.SPACE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void deleteRowByName(Connection conn, String tableName, String name) {
        Statement statement;
        try {
            String query = String.format("delete from %s where name='%s'", tableName, name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Deleted successfully!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteRowById(Connection conn, String tableName, int id) {
        Statement statement;
        try {
            String query = String.format("delete from %s where empid=%s", tableName, id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Deleted successfully!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteTable(Connection connection, String tableName){
        Statement statement;
        try {
            String query = String.format("drop table %s", tableName);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
