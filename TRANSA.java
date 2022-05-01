//8.1
import java.sql.*;

class TRANSA {
    public static void main(String args[]) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
        Statement st = c.createStatement();
        try {
            c.setAutoCommit(false);
            st.executeUpdate("UPDATE ACCOUNT SET BALANCE=BALANCE-500 WHERE ACCID=1111");
            c.commit();
            System.out.println("Funds tranfer successfully");
        } catch (Exception e) {
            c.rollback();
            System.out.println("Funds transfer failed");
        }
        st.close();
        c.close();
    }
}