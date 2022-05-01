import java.sql.*;
import java.util.Scanner;

public class DEPOSIT {
    public static void main(String args[])throws Exception{
        Scanner s=new Scanner(System.in);
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
        System.out.println("Enter your Account number to deposit amount: ");
        int ano=s.nextInt();//2000
        System.out.println("Enter amount to deposit: ");
        int amount=s.nextInt();//2000
        Statement st=con.createStatement();
        int n=st.executeUpdate("UPDATE ACCOUNT SET BALANCE=BALANCE+"+amount+"where ACCID="+ano);
        ResultSet rs=st.executeQuery("select * from account where ACCID="+ano);
        System.out.println("\nBalance Updated Successfully\n");
        String nm=rs.getString(2);//GETXX
        float bal=rs.getFloat(3);//
        System.out.println("Updated balance for A/C holder "+nm+" is "+bal);
        rs.close();
        st.close();
        con.close();
    }
    
}
