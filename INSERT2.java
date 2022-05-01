import java.sql.*;
import java.util.Scanner;
//ALL JDBC PACKAGE WE GET FROM SQL.*
public class INSERT2  {
public static void main(String args[]) throws ClassNotFoundException,SQLException
{
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the A/C holder name");
	String nm=s.next();//SRES
	
	System.out.println("Enter the account number");
	int acno=s.nextInt();//1136
	
	System.out.println("Enter the balance Rs");
	float bal=s.nextFloat();//1000
	
	Class.forName("oracle.jdbc.driver.OracleDriver");//Load Driver class [this line is optional after jdbc 4]
    Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");//thin driver: type 4 driver
    Statement st=c.createStatement();//designatory jdbc object which is used to submit SQL statements from the JDBC application to the dbms.
    int n=st.executeUpdate("INSERT INTO ACCOUNT VALUES(" +acno + ",'" +nm + "'," +bal +")"); //("1001,'sumit',56789")
	System.out.println(n+" "+"account stored successfully");
    st.close();
    c.close();
}
}
