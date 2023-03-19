package SQL.s2;

import java.sql.*;
import java.util.Scanner;

public class DeletePstmt {
    public static void main(String[] args) throws SQLException{
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tenducql", "root", "");

        ) {
            PreparedStatement Pstmt = conn.prepareStatement("DELETE FROM customers Where CustomerID = ?");
            conn.setAutoCommit(false);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập CustomerID: ");
            String ID = scanner.nextLine();

            Pstmt.setString(1, ID);
            Pstmt.addBatch();

            int check = Pstmt.executeUpdate();
            if (check >= 1) {
                System.out.println("Delete row: " + check);
            } else {
                System.out.println("No Update");
            }
            conn.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
