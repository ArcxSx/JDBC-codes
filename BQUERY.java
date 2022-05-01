//4\
import java.sql.*;
import java.util.Scanner;

public class BQUERY {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your Account number to check balance: ");
        int ano = s.nextInt();// 200
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from account where ACCID=" + ano);
        System.out.println("\nBalance Query\n");
        while (rs.next()) {
            String nm = rs.getString(2);// GETXX
            float bal = rs.getFloat(3);//
            System.out.println("Balance for A/C holder " + nm + " is " + bal);
        }
        rs.close();
        st.close();
        con.close();
    }

}