//1
import java.util.Scanner;
import java.sql.*;

class DISPLAY {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
        System.out.println("Enter the Account number");
        int ano = s.nextInt();// 2000
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from account where ACCID=" + ano);
        if (rs.next()) {
            String nm = rs.getString(2);// GETXX
            float bal = rs.getFloat(3);//
            System.out.println("A/C holder name " + nm);
            System.out.println("balance is " + bal);
        } else {
            System.out.println("not");
        }
        rs.close();
        st.close();
        con.close();
    }
}