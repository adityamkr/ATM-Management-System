import java.sql.*;

class jdbcconn
{
      Connection con;
	  PreparedStatement ps;
	  Statement stmt;
	  ResultSet rs;
     jdbcconn()
	 {
	   try
	   {
	    
      Class.forName("com.mysql.cj.jdbc.Driver"); 
      con=DriverManager.getConnection("jdbc:mysql://localhost/atm","root","root");
       //stmt= con.createStatement();
      
	   }
	   catch(Exception e)
	   {
		  System.out.println(e);
	   }
	 }
  public static void main(String[] args)
  {
       new jdbcconn();
  }
}