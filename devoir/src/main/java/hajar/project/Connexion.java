package hajar.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    Connection conn ;

    public void connexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir","root","");

    }
    public Connection getConnection(){
        return conn;
    }
}
