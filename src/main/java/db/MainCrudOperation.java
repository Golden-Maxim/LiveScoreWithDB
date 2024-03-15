package db;

import java.sql.Connection;

public class MainCrudOperation {
    private final static String TABLE_NAME = "employee";
    public static void main(String[] args) {
        Connection connection = DBConnection.connectToPostgresDataBase("TestDataBase");
        //DBConnection.createTable(connection, "employee");
        //DBConnection.insertRow(connection, TABLE_NAME, "Maksym","England");
        //DBConnection.showData(connection, TABLE_NAME);
        //DBConnection.updateData(connection, TABLE_NAME, "Jeck", "Jackson");
       // DBConnection.showData(connection, TABLE_NAME);
        //DBConnection.searchByID(connection, TABLE_NAME, 6);
//        DBConnection.showData(connection, TABLE_NAME);
//        DBConnection.deleteRowById(connection,TABLE_NAME, 6);
//        DBConnection.showData(connection, TABLE_NAME);
        DBConnection.deleteTable(connection, TABLE_NAME);

    }

}
