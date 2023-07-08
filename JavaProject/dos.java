import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

class dos implements ActionListener
{     
	JFrame bk;
	 JTextField t1;
	 JTextField t2;
	 JTextField t3 ;
	  JTextArea area;
	  JTextField acard;
	  JTextField phone;
	  JTextField email;
	  JTextField minamount;
	   JTextField password;
	  JButton back ;
	  
	public  JButton createacc;
    public void caty()
  {
   System.out.println("hello caty");
    
		 bk = new JFrame("Bank");
		 JLabel l1 = new JLabel("Welcome to JAVA Union Bank");
		 l1.setBounds(360,60,300,30);
		 l1.setFont(new Font("SansSerif", Font.BOLD, 20));
		  JLabel name = new JLabel("First Name");
		 name.setBounds(50,180,90,30);
		  name.setFont(new Font("SansSerif", Font.BOLD, 16));
		   t1 = new JTextField("");
		  t1.setBounds(160,185,190,30);
		  JLabel lastname = new JLabel("Last Name");
		  lastname.setBounds(50,290,90,30);
		  lastname.setFont(new Font("SansSerif", Font.BOLD, 16));
		    t2 = new JTextField("");
		  t2.setBounds(160,290,190,30);
		  JLabel age = new JLabel("Enter age");
		  age.setBounds(50,400,90,30);
		  age.setFont(new Font("SansSerif", Font.BOLD, 16));
		   t3 = new JTextField();
		  t3.setBounds(160,400,190,30);
	
		  JLabel address = new JLabel("Address");
		  address.setBounds(50,520,90,30);
		  address.setFont(new Font("SansSerif", Font.BOLD, 16));
		   area = new JTextArea("");
		  area.setBounds(165,510,200,80);
		  area.setFont(new Font("SansSerif", Font.PLAIN, 16));
		  area.setLineWrap(true);
		  
		  JLabel adhar = new JLabel("Adhar Id");
		  adhar.setBounds(570,180,90,30);
		  adhar.setFont(new Font("SansSerif", Font.BOLD, 16));
		  acard = new JTextField("");
		  acard.setBounds(690,185,190,30);
		  JLabel occupation = new JLabel("Phone no");
		  occupation.setBounds(570,290,90,30);
		   occupation.setFont(new Font("SansSerif", Font.BOLD, 16));
		   phone = new JTextField("");
		  phone.setBounds(690,290,190,30);
		  JLabel eid = new JLabel("Email id");
		   eid.setBounds(570,390,90,30);
		    eid.setFont(new Font("SansSerif", Font.BOLD, 16));
		  JLabel minacc = new JLabel("Min. amount to add (Rs)");
		   minacc.setBounds(505,490,200,30);
		   minacc.setFont(new Font("SansSerif", Font.BOLD, 15));
		    email = new JTextField("");
		   email.setBounds(695,390,190,30);
		    minamount = new JTextField("");
		   minamount.setBounds(695,490,190,30);
		   JLabel pin = new JLabel("Set Pin");
		   pin.setBounds(570,580,120,30);
		   pin.setFont(new Font("SansSerif",Font.BOLD,15));
		    password = new JPasswordField("");
		    password.setBounds(695,580,190,30);
		    createacc = new JButton("Create Account");
		    createacc.setBounds(398,670,150,30);
			createacc.setBackground(Color.GREEN);
			createacc.addActionListener(this);
			
			 back = new JButton("Home");
			 back.addActionListener(this);
			back.setBounds(20,720,90,30);
		 bk.add(l1);
		 bk.add(name);
		  bk.add(t1);
		  bk.add(lastname);
		  bk.add(t2);
		  bk.add(age);
		  bk.add(t3);
		  bk.add(address);
		  bk.add(area);
		  bk.add(adhar);
		  bk.add(acard);
		  bk.add(occupation);
		  bk.add(phone);
		  bk.add(eid);
		  bk.add(email);
		  bk.add(minacc);
		  bk.add(minamount);
		  bk.add(pin);
		  bk.add(password);
		  bk.add(createacc);
		  bk.add(back);
		 bk.setSize(1000,800);
		 
		 bk.setLayout(null);
		 bk.setVisible(true);
		 bk.setBackground(Color.ORANGE);
		bk.getContentPane().setBackground(Color.ORANGE);
		bk.setLocationRelativeTo(null);
		 
  }
  
  public void actionPerformed(ActionEvent z)
  {
	 
	 if(z.getSource()==createacc)
	 {
	  String a =t1.getText();
	  String b =t2.getText();
	  String c =t3.getText();
	  String d=area.getText();
	  String e=acard.getText();
	  String f=phone.getText();
	  String g =email.getText();
	  String h = minamount.getText();
	  String i =password.getText();
	   double no=-1;
	   g=g.toLowerCase();
	   f=phone.getText();
	   System.out.println(h.matches("^[0-9]+$"));
	   if(h.matches("^[0-9]+$"))
	   {
		   System.out.println("hello");
		   System.out.println(h.length());
	     no=Double.parseDouble(h);
	   }
		
		System.out.println(d.matches("^[0-9]*$"));
		//System.out.println(e);
	  if(a.equals("") || b.equals("")|| c.equals("") || d.equals("") || e.equals("") || f.equals("") || g.equals("")|| h.equals("") || i.equals(""))
	  {
		  System.out.println("1");
		 JOptionPane.showMessageDialog(null,"Pls Enter all the Fields");
	  }	
		 else if(!(a.matches("^[A-Za-z]+$")) || !(b.matches("^[A-Za-z]+$")) || (a.length()<2) ||(b.length()<2))
		  {  
	           System.out.println("2");
			  JOptionPane.showMessageDialog(null,"Pls enter correct name");
		  }
		  
		 else if((c.matches("^[0-9]*$")==false)||((c.matches("^[0-9]*$") && c.length()>2)))
		 {
			  System.out.println("3");
			 JOptionPane.showMessageDialog(null,"Pls enter correct age");
		 }
		 
		 else if((d.matches("^[0-9]*$")==true) || (d.matches("^[0-9]*$")==true && d.length()<10) || (d.matches("^[0-9]*$")==false && d.length()<10))
		 {  
			System.out.println("5");
			 JOptionPane.showMessageDialog(null,"Enter proper address");
		 }
		 
		   else if(e.matches("^[0-9]*$")==false || (e.matches("^[0-9]*$") && e.length()<13))
		  {
			  System.out.println("4");
	
            JOptionPane.showMessageDialog(null,"Enter correct adhar id");
		  }
		  		   		 
		 else if(!(f.matches("^([+]\\d{2}[ ])?\\d{10}$")))
		  {
			  System.out.println("6");
			
		   JOptionPane.showMessageDialog(null,"Pls enter Correct phone no"); 
		  }
		 else if(!(g.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")))
		  {
			   System.out.println("7");
			    if(!g.matches("^[a-z]@$"))
			JOptionPane.showMessageDialog(null,"pls enter correct email address");
		  }
		  
		 else if(!(h.matches("^[0-9]*$"))|| (h.matches("^[0-9]*$") && no<2000))
		 {   
			
			 JOptionPane.showMessageDialog(null,"Minimum 2000 Rs is required to create account");
		    
		 }
		 
		 else if(i.length()<8)
		 {
			 JOptionPane.showMessageDialog(null,"Password length should be min of 8 length");
		 }
		 else{
			 System.out.println("wakka");
			 t1.setText("");
			 t2.setText("");
			 t3.setText("");
			 area.setText("");
			 acard.setText("");
			 phone.setText("");
			 email.setText("");
			 minamount.setText("");
			 password.setText("");
			 callme(a,b,c,d,e,f,g,h,i);
			 
		 }
  }
   if(z.getSource()==back)
   {
	  System.out.println("fine");
	   bk.dispose();
	   atm.mainframe.setVisible(true);
	   
	   
   }
  }  
		 
public void callme(String a,String b,String c,String d,String e,String f,String g,String h,String i)
{
	int gotid;
	 String message="";
	 Connection con=null;
  try{
	  
	  System.out.println("world .....");
	
  Class.forName("com.mysql.cj.jdbc.Driver"); 
   con=DriverManager.getConnection("jdbc:mysql://localhost/atm","root","root");
   Statement stmt= con.createStatement();
   PreparedStatement ps;
   
	    ps =con.prepareStatement("insert into bkusers(fname,lname,age,address,adhar_id,phone_no,email_id,min_balance,pin) values(?,?,?,?,?,?,?,?,?)");   
		ps.setString(1,a);
		ps.setString(2,b);
		ps.setString(3,c);
		ps.setString(4,d);
		ps.setString(5,e);
		ps.setString(6,f);
		ps.setString(7,g);
		ps.setString(8,h);
		ps.setString(9,i);
		int result=ps.executeUpdate();
		System.out.println(result);
		
		if(result==1)
		{
		 ps=con.prepareStatement("select id from bkusers order by id desc limit 1");	 
		ResultSet rs=ps.executeQuery();
		  rs.next();
		  gotid=rs.getInt(1);	  
		  System.out.println(gotid);
		  message="Dear "+a+" Thankyou for choosing JUB Your credit card no is  "+gotid+"    ";
		  JOptionPane.showMessageDialog(null,message);
		}
		
}

catch(Exception ex)
{
JOptionPane.showMessageDialog(null,"Something went wrong");
 System.out.println(ex);
}
finally
{
   try
   {
	 if(con!=null)
	 con.close();
   }
   catch(SQLException ex)
   {
	  System.out.println(ex);
   }
} 
}
		
	 
 public static void main(String[] args)
 {
  //dos d = new dos();
 }
}