import java.sql.*;
import java.util.Scanner;
class abc
{
   
 public static void main(String[] args)
{
Connection con=null;
try{
   Scanner sc=new Scanner(System.in);	
  Class.forName("com.mysql.cj.jdbc.Driver"); 
   con=DriverManager.getConnection("jdbc:mysql://localhost/aditya","root","root");
   PreparedStatement ps;
   System.out.println(con);
  Statement stmt=con.createStatement();
  ResultSet rs=stmt.executeQuery("select * from emp");
  
   while(rs.next())
{
   System.out.println("id: "+rs.getInt(1)+" "+"name: "+rs.getString(2)+" ");
}
  System.out.println("Enter eid which has to deleted");
  String eid=sc.nextLine();
  ps=con.prepareStatement("delete from emp where id=?");
  ps.setString(1,eid);
  int x=ps.executeUpdate();
  System.out.println("deleteed"+x);
  System.out.println("enter id,name to insert");
  String id=sc.nextLine();
  String name=sc.nextLine();
  ps=con.prepareStatement("insert into emp values(?,?)");
  ps.setString(1,id);
  ps.setString(2,name);
  x=ps.executeUpdate();
  ps=con.prepareStatement("Update emp set name=? where id=?");
  System.out.println("Enter id whose name has to be updated");
  id=sc.nextLine();
   System.out.println("Enter name");
  name=sc.nextLine();
  ps.setString(1,name);
  ps.setString(2,id);
  x= ps.executeUpdate();
  System.out.println("updated"+x);
  System.out.println("inserted"+x);  
}
catch(Exception e)
{
System.out.println(e);
}
finally
{
   try
{
   System.out.println("connection"+con);
  if(con!=null)
  con.close();
}
catch(Exception f)
{
  System.out.println("error while closing"+f);
}
}
}
}