import java.sql.*;
//ALL JDBC PACKAGE WE GET FROM SQL.*
public class KS
{
public static void main(String args[]) throws ClassNotFoundException,SQLException
{
Class.forName("oracle.jdbc.OracleDriver");//Driver class [this line is optional after jdbc 4
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kushal2001");//thin driver: type 4 driver(Library class in Java)
//URL OF DBMS SERVER,USERNAME,PASSWORD
System.out.println("connection established");
c.close();
}
}