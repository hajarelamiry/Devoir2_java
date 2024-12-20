package hajar.project.Service;
import hajar.project.Order;
import hajar.project.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderService {
    Connexion conn;
    Connection con;

    public void orderservice() throws SQLException, ClassNotFoundException {
        conn = new Connexion();
        this.con = conn.getConnection();
    }

    public boolean getorder(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from orders where id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public void orderinsert(Order order) throws SQLException, ClassNotFoundException {

        String sql = "insert into orders values(?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, order.getId());
        pstmt.setString(2, order.getDate());
        pstmt.setFloat(3, order.getAmount());
        pstmt.setInt(4, order.getCustomerId());
        pstmt.executeUpdate();
    }

}
