package tests;

import db.DBConnection;
import org.testng.annotations.Test;

public class DbTests {


    @Test
    public void createOperation(){
       DBConnection.connectToPostgresDataBase("TestDataBase");
    }
}
