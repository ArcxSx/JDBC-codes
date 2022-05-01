//3
import java.util.Scanner;
import java.sql.*;

class DISP {
    public static void main(String args[]) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
        PreparedStatement ps = con.prepareStatement("INSERT INTO ACCOUNT VALUES(?,?,?)");
        ps.setInt(1, 3000);// SETXX
        ps.setString(2, "RA");
        ps.setFloat(3, 6800);
        int n = ps.executeUpdate();
        ps.setInt(1, 4000);
        ps.setString(2, "RAHIMA");
        ps.setFloat(3, 9800);
        n = ps.executeUpdate();
        System.out.println("more account created");
        ps.close();
        con.close();
    }
}
