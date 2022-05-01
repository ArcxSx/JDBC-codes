import java.sql.*;
//ALL JDBC PACKAGE WE GET FROM SQL.*
public class INSERT  {
public static void main(String args[]) throws ClassNotFoundException,SQLException
{

Class.forName("oracle.jdbc.OracleDriver");//Load Driver class [this line is optional after jdbc 4]
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");//thin driver: type 4 driver
Statement st=c.createStatement();//designatory jdbc object which is used to submit SQL statements from the JDBC application to the dbms.
int n=st.executeUpdate("insert into account values(111,'S',50000)");
n=st.executeUpdate("insert into account values(112,'k',1500)");
st.close();
c.close();
}
}