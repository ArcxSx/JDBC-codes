/*to run javac MAIN.JAVA
  java miniproject.MAIN
*/

package miniproject;
import java.sql.*;
import java.util.Scanner;

public class MAIN {
    public static void main (String args[]) throws ClassNotFoundException,SQLException {
        Scanner s = new Scanner(System.in);
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
        
        while(true){
            System.out.println("\n1. Insert Data \n2. Delete Data \n3. Update Data \n4. Retrieve Data \n5. Exit");
            int ch = s.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the A/C holder name");
                    String nm=s.next();//SRES
                    
                    System.out.println("Enter the account number");
                    int acno=s.nextInt();//1136
                    
                    System.out.println("Enter the balance Rs");
                    float bal=s.nextFloat();//1000
                    Statement st=con.createStatement();//designatory jdbc object which is used to submit SQL statements from the JDBC application to the dbms.
                    int n=st.executeUpdate("INSERT INTO ACCOUNT VALUES(" +acno + ",'" +nm + "'," +bal +")"); //("1001,'sumit',56789")
                    System.out.println(n+" "+"account stored successfully");
                    st.close();
                    break;
                case 2:
                    System.out.print("Enter your Account number to CLOSE ACCOUNT: ");
                    int ano1 = s.nextInt();// 200
                    Statement st1 = con.createStatement();
                    ResultSet rs = st1.executeQuery("select * from account where ACCID=" + ano1);
                    System.out.println("\nACCOUNT CLOSING\n");
                    if (rs.next()) {
                        String nm1 = rs.getString(2);
                        System.out.println("Closed Account for A/C ID:"+ ano1 +" A/C holder Name: " + nm1);
                    }
                    int n1=st1.executeUpdate("DELETE FROM ACCOUNT WHERE ACCID="+ano1);
                    rs.close();
                    st1.close();
                    break;
                case 3:
                    System.out.println("Enter your Account number to deposit amount: ");
                    int ano2=s.nextInt();//2000
                    System.out.println("Enter amount to deposit: ");
                    int amount=s.nextInt();//2000
                    Statement st2=con.createStatement();
                    int n2=st2.executeUpdate("UPDATE ACCOUNT SET BALANCE=BALANCE+"+amount+"where ACCID="+ano2);
                    ResultSet rs2=st2.executeQuery("select * from account where ACCID="+ano2);
                    System.out.println("\nBalance Updated Successfully\n");
                    if (rs2.next()) {
                    String nm2=rs2.getString(2);//GETXX
                    float bal2=rs2.getFloat(3);//
                    System.out.println("Updated balance for A/C holder "+nm2+" is "+bal2);
                    }
                    st2.close();
                    rs2.close();
                    break;
                case 4:
                    System.out.println("Enter the Account number");
                    int ano = s.nextInt();// 2000
                    Statement st3 = con.createStatement();
                    ResultSet rs3 = st3.executeQuery("select * from account where ACCID=" + ano);
                    if (rs3.next()) {
                        String nm3 = rs3.getString(2);// GETXX
                        float bal3 = rs3.getFloat(3);//
                        System.out.println("A/C holder name " + nm3);
                        System.out.println("balance is " + bal3);
                    } else {
                        System.out.println("Does not exist.");
                    }
                    st3.close();
                    rs3.close();
                    break;
                case 5:
                    con.close();
                    System.exit(0);
                default:
                System.out.println("WRONG CHOICE!");
                    break;
            }
        }
    }
}