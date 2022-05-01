//5
import java.sql.*;
import java.util.Scanner;

public class ACLOSE {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
        System.out.print("Enter your Account number to CLOSE ACCOUNT: ");
        int ano = s.nextInt();// 200
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from account where ACCID=" + ano);
        System.out.println("\nACCOUNT CLOSING\n");
        if (rs.next()) {
            String nm = rs.getString(2);
            System.out.println("Closed Account for A/C ID:"+ ano +" A/C holder Name: " + nm);
        }
        int n=st.executeUpdate("DELETE FROM ACCOUNT WHERE ACCID="+ano);
        rs.close();
        st.close();
        con.close();
    }

}
