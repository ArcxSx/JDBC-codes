import java.sql.*;
//ALL JDBC PACKAGE WE GET FROM SQL.*
public class DELETE  {
public static void main(String args[]) throws ClassNotFoundException,SQLException
{
Class.forName("oracle.jdbc.OracleDriver");//Load Driver class [this line is optional after jdbc 4]
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");//thin driver: type 4 driver
Statement st=c.createStatement();//designatory jdbc object which is used to submit SQL statements from the JDBC application to the dbms.
int n=st.executeUpdate("DELETE FROM ACCOUNT WHERE BALANCE<10000");
System.out.println("updated");
st.close();
c.close();
}
}
