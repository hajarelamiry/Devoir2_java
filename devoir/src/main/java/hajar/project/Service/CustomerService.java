package hajar.project.Service;
import hajar.project.Customer;
import hajar.project.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerService {
    Connexion conn;
    Connection con;

    public void customerservice() throws SQLException, ClassNotFoundException {
        conn = new Connexion();
        this.con = conn.getConnection();
    }

    public boolean getcustomer(int customerid) throws SQLException {
        String sql = "select * from customers where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, customerid);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Customer c = new Customer();
            c.setId(rs.getInt("id"));
            c.setNom(rs.getString("nom"));
            c.setEmail(rs.getString("email"));
            return true;
        }
        return false;

    }
}