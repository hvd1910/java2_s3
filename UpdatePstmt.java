package SQL.s2;

import java.sql.*;
import java.util.Scanner;

public class UpdatePstmt {

        public static void main(String[] args) throws SQLException {
            try (
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tenducql", "root", "");
                    Statement stmt = conn.createStatement();
            ) {
                PreparedStatement Pstmt = conn.prepareStatement("Update  customers set ContactName = ?  Where CustomerID = ?");
                conn.setAutoCommit(false);

                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhập ContactName  Mới Bạn Muốn Cập Nhập: ");
                String Name =  scanner.nextLine();
                System.out.print("Nhập CustomerID: ");
                String ID =  scanner.nextLine();

                Pstmt.setString(1, Name);
                Pstmt.setString(2, ID);
                Pstmt.addBatch();


                int check = Pstmt.executeUpdate();
                if (check >= 1) {
                    System.out.println("Update row " + check);
                } else {
                    System.out.println("No Update");
                }
                conn.commit();
        }catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }
}
