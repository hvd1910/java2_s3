package SQL.s2;

import tuhoc.SQL.NhaSach.Dao.Dao;

import java.sql.*;

public class CustomerPstmt {
    public static void main(String[] args) throws SQLException {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tenducql", "root", "");
                Statement stmt = conn.createStatement();
                ) {
            PreparedStatement Pstmt = conn.prepareStatement("insert into customers values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            conn.setAutoCommit(false);

            Pstmt.setString(1, "HVDDS" );
            Pstmt.setString(2, "Around the Hornts");
            Pstmt.setString(3,"Hanna Moos");
            Pstmt.setString(4, "Owner");
            Pstmt.setString(5,"C/ Araquil, 67");
            Pstmt.setString(6, "Madrid");
            Pstmt.setString(7, "NULL");
            Pstmt.setString(8,"28023");
            Pstmt.setString(9, "Spain");
            Pstmt.setString(10,"91) 555 22 82");
            Pstmt.setString(11, "(91) 555 91 99");
            Pstmt.addBatch();

            Pstmt.setString(1, "HVDDL");
            Pstmt.setString(2,"Ho Viet Duc");
            Pstmt.setString(3,"Quynh Long");
            Pstmt.addBatch();

            int[] returnCodes = Pstmt.executeBatch();

            System.out.println("Return codes are: ");
            for (int code : returnCodes) System.out.println(code + ", ");
            conn.commit();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
