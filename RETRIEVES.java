
//2. Develop a JDBC Application that retrieves name and balance of all the accounts whose balance is more than rs. 5000.
import java.util.Scanner;
import java.sql.*;

public class RETRIEVES {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from account where BALANCE>5000");
        while (rs.next()) {
                String nm = rs.getString(2);
                float bal = rs.getFloat(3);
                System.out.println("A/C holder name " + nm +"balance is " + bal);
        }
    }
}
