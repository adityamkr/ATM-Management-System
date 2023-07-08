import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.table.DefaultTableModel;


class atm implements ActionListener
{
	static JFrame f1, mainframe,d1,cf;
	JButton bank,atm,cd,home,deposit,pd,withdraw,pw,back,bk,balance,fastcash,oneth,twoth,threeth,fifth,pin,cp,ministmt,ok;
	JTextField euno,t1,t2,currpin;
	 JTextField epin,newpin;

	jdbcconn c1;
	public String cno,fast;
	
	atm()
	{
		 c1 = new jdbcconn();
	 mainframe = new JFrame("ATM");
  JLabel label = new JLabel("Welcome to ATM Service");
  label.setForeground(Color.white);
  JLabel atmservice = new JLabel("Use ATM");
  JLabel bankservice = new JLabel("Use Bank");
  atmservice.setForeground(Color.white);
  atmservice.setBounds(220,110,150,30);
  atmservice.setFont(new Font("SansSerif", Font.BOLD, 20));
  bankservice.setFont(new Font("SansSerif", Font.BOLD, 20));
  bankservice.setForeground(Color.white);
  bankservice.setBounds(720,110,150,30);
  label.setBounds(370,40,250,30);
  label.setFont(new Font("SansSerif", Font.BOLD, 20));
   atm = new JButton(new ImageIcon("C:\\Users\\Aditya Matkar\\Desktop\\istockphoto-697417092-612x612.jpg"));
   bank = new JButton(new ImageIcon("C:\\Users\\Aditya Matkar\\Desktop\\download.jpg"));
  bank.addActionListener(this);
  atm.addActionListener(this);
  atm.setBounds(160,170,220,180);
  bank.setBounds(670,170,220,180);
  mainframe.add(label);
  mainframe.add(atmservice);
  mainframe.add(bankservice);
  mainframe.add(bank);
  mainframe.add(atm);
  mainframe.setSize(1000,500);
  mainframe.setLayout(null);
  mainframe.getContentPane().setBackground(Color.black);
  mainframe.setVisible(true);
  mainframe.setLocationRelativeTo(null);
  
	}
	
	 public void actionPerformed(ActionEvent e)
	 {   
	  System.out.println("hello");
	     if(e.getSource()==bank)
		 {
			dos s1 = new dos();
			mainframe.dispose();
		    s1.caty();  
	      }
       if(e.getSource()==atm)
	   {
		  mainframe.dispose();
		  loginframe();
		  
	   }
	   
	   if(e.getSource()==cd)
	   {
		  checkdetails();
	   }
	   if(e.getSource()==home)
	   {   
   
		   f1.dispose();
		   mainframe.setVisible(true);
	   }
	   
	   if(e.getSource()==deposit)
	   { System.out.println("deposit Action");
		  cf.dispose();
		  depositframe();
	   }
	   
	   if(e.getSource()==pd)
	   {
		  
		  proceedcheck("deposit");
	   }
	   
	   if(e.getSource()== withdraw)
	   {
		  cf.dispose();
		 withdrawframe();
	   }
	   if(e.getSource()==pw)
	   {
		    proceedcheck("withdraw");
	   }
	   if(e.getSource()==back || e.getSource()==ok)
	   { 
          System.out.println("yyyyyyy");
		   d1.dispose();
		   cf.setVisible(true);
	   }
	   if(e.getSource()==bk)
	   {  
		   cf.dispose();
		   f1.setVisible(true);
	   }
	   
	   if(e.getSource()==balance)
	   {
		   //cf.dispose();
		  // balanceframe();
		   proceedcheck("balance");
	   }
	   if(e.getSource()==fastcash)
	   {
		   cf.dispose();
		   fastcashframe();
	   }
	   
	   if(e.getSource()==oneth)
	   {
		   fast="1000";
		   proceedcheck("fastcash");
	   }
	   if(e.getSource()==twoth)
	   {
		  fast="2000";
		  proceedcheck("fastcash");
	   }
	   
	   if(e.getSource()==threeth)
	   {
		   fast="3000";
		   proceedcheck("fastcash");
	   }
	   if(e.getSource()==fifth)
	   {
		   fast="5000";
		   proceedcheck("fastcash");
	   }
	   
	   if(e.getSource()==pin)
	   {  
            cf.dispose();
		   changepinframe();
		  // d1.dispose();
	   }
	   
	   if(e.getSource()==cp)
	   {   
         System.out.println("welcome");
		   proceedcheck("changepin");
	   }
	   
	   if(e.getSource()==ministmt)
	   {
		   cf.dispose();
		   ministmtframe();
	   }
	  
	   
	   }
	 
	 
	public void loginframe()
	{
		 f1 = new JFrame("Login");
		   JLabel username = new JLabel("Enter Card No");
		   username.setBounds(120,100,120,30);
		    username.setForeground(Color.blue);
		   username.setFont(new Font("SansSerif",Font.BOLD,16));
		    euno = new JTextField("");
		   euno.setBounds(270,100,180,30);
		   euno.setFont(new Font("SansSerif",Font.BOLD,16));
		   
		   JLabel pin = new JLabel("Enter Card PIN");
		   pin.setBounds(120,182,120,30);
		   pin.setFont(new Font("SansSerif",Font.BOLD,16));
		   pin.setForeground(Color.blue);
		    epin = new JPasswordField("");
		   epin.setFont(new Font("SansSerif",Font.BOLD,16));
		   epin.setBounds(270,180,180,30);
		    cd = new JButton("Check Details");
		   cd.setBounds(225,290,150,30);
		   cd.setForeground(Color.white);
		   cd.setBackground(Color.red);
		   cd.addActionListener(this);
		    home = new JButton("<--------");
		   home.setBounds(0,0,80,40);
		   home.setForeground(Color.black);
		   home.setBorderPainted(false); 
        home.setContentAreaFilled(false); 
        home.setFocusPainted(false); 
        home.setOpaque(false);
		home.addActionListener(this);
		   f1.add(username);
		   f1.add(euno);
		   f1.add(pin);
		   f1.add(epin);
		   f1.add(cd);
		   f1.add(home);
		   f1.setLayout(null);
		   f1.setSize(620,450);
		   f1.setLocationRelativeTo(null);
		   f1.setVisible(true);
		   f1.getContentPane().setBackground(Color.orange);
	}
	
	public void checkdetails()
	{ 
	    cno = euno.getText();
	  String pin =epin.getText();
	//  Connection con;
	  
	  try
	  {
		
  
	 c1.ps=c1.con.prepareStatement("select count(*) from bkusers where id="+"'"+cno+"'"+"and"+" pin="+"'"+pin+"'");
	 c1.rs = c1.ps.executeQuery();
	 c1.rs.next();
	// contentframe();
	 
	 if(c1.rs.getInt(1)==1)
	 {
		// System.out.println("successs");
		 contentframe();
	 }
	 else
	 {
		 JOptionPane.showMessageDialog(null,"Sorry, we didnt found you as Registered user pls create an account");
	 }
	 
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	}
	
	
	public void contentframe()
	{
	   f1.dispose();
	   cf = new JFrame("Welcome to Java ATM Service");
	  JLabel tag = new JLabel("How  can  we  help  you ?");
	  tag.setBounds(360,30,400,30);
	  tag.setFont(new Font("SansSerif",Font.BOLD,23));
	    JLabel ldeposit = new JLabel("Deposit Amount");
		ldeposit.setForeground(Color.BLUE);
		ldeposit.setBounds(130,75,150,20);
		ldeposit.setFont(new Font("SansSerif",Font.BOLD,18));
	    deposit = new JButton("Export",new ImageIcon((new ImageIcon("C:\\Users\\Aditya Matkar\\Desktop\\png-transparent-bank-cash-deposit-money-business-and-finance-icon.png").getImage().getScaledInstance(255, 140, java.awt.Image.SCALE_SMOOTH))));
	  deposit.setBounds(80,110,230,140);
	  deposit.addActionListener(this);
	    
	  JLabel lw = new JLabel("Withdraw Amount");
	  lw.setBounds(120,280,170,20);
	  lw.setForeground(Color.BLUE);
	  lw.setFont(new Font("SansSerif",Font.BOLD,18));
	   withdraw = new JButton("Export",new ImageIcon((new ImageIcon("C:\\Users\\Aditya Matkar\\Desktop\\6423629.png").getImage().getScaledInstance(230, 160, java.awt.Image.SCALE_SMOOTH))));
	  withdraw.setBounds(80,320,230,140);
	  withdraw.addActionListener(this);
	  
	  JLabel lbalance = new JLabel("Check Balance");
	  lbalance.setBounds(120,510,170,20);
	  lbalance.setFont(new Font("SansSerif",Font.BOLD,18));
	  lbalance.setForeground(Color.BLUE);
	  
	   balance = new JButton("Export",new ImageIcon((new ImageIcon("C:\\Users\\Aditya Matkar\\Desktop\\indian-currency-389006_1920_5f1547587ee6e.jpg").getImage().getScaledInstance(240, 160, java.awt.Image.SCALE_SMOOTH))));
	  balance.setBounds(80,550,230,140);
	  balance.addActionListener(this);
     
	 JLabel lfastcash = new JLabel("Fast Cash");
	 lfastcash.setBounds(780,75,150,20);
	 lfastcash.setFont(new Font("SansSerif",Font.BOLD,18));
	  lfastcash.setForeground(Color.BLUE);
	   fastcash = new JButton("Export",new ImageIcon((new ImageIcon("C:\\Users\\Aditya Matkar\\Desktop\\fast-cash-icon-flat-style-transfer-symbol-fast-cash-icon-flat-style-transfer-symbol-simple-money-symbol-isolated-white-159439342.jpg").getImage().getScaledInstance(240, 160, java.awt.Image.SCALE_SMOOTH))));
	  fastcash.setBounds(720,110,230,140);
	  fastcash.addActionListener(this);
	   
	  JLabel lministmt = new JLabel("Mini Statement");
	  lministmt.setBounds(770,280,150,20);
	  lministmt.setFont(new Font("SansSerif",Font.BOLD,18));
	  lministmt.setForeground(Color.BLUE);
	  
	   ministmt = new JButton("Export",new ImageIcon((new ImageIcon("C:\\Users\\Aditya Matkar\\Desktop\\bank-statement-magnifying-review-icon-financial-vector-44100175.jpg").getImage().getScaledInstance(240, 160, java.awt.Image.SCALE_SMOOTH))));
	   ministmt.setBounds(720,320,230,140);
	   ministmt.addActionListener(this);
	   
	  JLabel lcp = new JLabel("Change PIN");
	  lcp.setBounds(780,510,150,20);
	   lcp.setFont(new Font("SansSerif",Font.BOLD,18));
	  lcp.setForeground(Color.BLUE);
	  
	  pin = new JButton("Export",new ImageIcon((new ImageIcon("C:\\Users\\Aditya Matkar\\Desktop\\6117000.png").getImage().getScaledInstance(180, 120, java.awt.Image.SCALE_SMOOTH))));
	  pin.setBounds(720,550,230,140);
	  pin.addActionListener(this);
	  bk = new JButton("<---------");
	  bk.setBounds(5,10,90,30);
	   bk.setContentAreaFilled(false); 
        bk.setFocusPainted(false); 
		bk.setBorderPainted(false); 
        bk.setOpaque(false);
		bk.addActionListener(this);
	  cf.add(tag);
	  cf.add(ldeposit);
	  cf.add(deposit);
	  cf.add(lw);
	  cf.add(withdraw);
	  cf.add(lbalance);
	  cf.add(balance);
	  cf.add(lfastcash);
	  cf.add(fastcash);
	  cf.add(lministmt);
	  cf.add(ministmt);
	  cf.add(lcp);
	  cf.add(pin);
	  cf.add(bk);
	  cf.setLayout(null);
	  cf.setSize(1000,750);
	  cf.setVisible(true);
	  cf.setLocationRelativeTo(null);
	  cf.getContentPane().setBackground(Color.ORANGE);
	  
	}
	
	public void depositframe()
	{
	System.out.println("controlled reach");
	  d1= new JFrame("Deposit Cash");
	 JLabel l1 = new JLabel("Enter Account no");
	 l1.setBounds(80,120,170,30);
	 l1.setFont(new Font("SansSerif",Font.BOLD,14));
	  t1 = new JTextField("");
	 t1.setBounds(240,122,170,25);
	 t1.setFont(new Font("Sanserif",Font.BOLD,14));
	 
	 JLabel l2 = new JLabel("Enter Amount");
	 l2.setBounds(80,190,170,30);
	  l2.setFont(new Font("SansSerif",Font.BOLD,14));
	   t2 = new JTextField("");
	  t2.setBounds(240,190,170,25);
	  t2.setFont(new Font("SansSerif",Font.BOLD,14));
	   pd = new JButton("Proceed");
	  pd.setBounds(210,280,120,30);
	  pd.setBackground(Color.RED);
	  pd.setForeground(Color.WHITE);
	  pd.addActionListener(this);
	    back = new JButton("<---------");
	  back.setBounds(5,10,90,30);
	   back.setContentAreaFilled(false); 
        back.setFocusPainted(false); 
		back.setBorderPainted(false); 
        back.setOpaque(false);
		back.addActionListener(this);
	 d1.add(l1);
	 d1.add(t1);
	 d1.add(l2);
	 d1.add(t2);
	 d1.add(pd);
	 d1.add(back);
	 d1.setLayout(null);
	 d1.setSize(550,480);
	 d1.setLocationRelativeTo(null);
	 d1.setVisible(true);
	 d1.getContentPane().setBackground(Color.GREEN);
	}
	
	
	public void withdrawframe()
	{
		System.out.println("welcome");
			  d1= new JFrame("Withdraw Cash");
	 JLabel l2 = new JLabel("Enter  Withdraw  Amount");
	 l2.setBounds(180,140,200,30);
	  l2.setFont(new Font("SansSerif",Font.BOLD,14));
	   t2 = new JTextField("");
	  t2.setBounds(180,190,160,25);
	  t2.setFont(new Font("SansSerif",Font.BOLD,14));
	   pw = new JButton("Proceed");
	  pw.setBounds(210,280,120,30);
	  pw.setBackground(Color.RED);
	  pw.setForeground(Color.WHITE);
	  pw.addActionListener(this);
	   back = new JButton("<---------");
	  back.setBounds(5,10,90,30);
	   back.setContentAreaFilled(false); 
        back.setFocusPainted(false); 
		back.setBorderPainted(false); 
        back.setOpaque(false);
		back.addActionListener(this);
	 d1.add(l2);
	 d1.add(t2);
	 d1.add(pw);
	 d1.add(back);
	 d1.setLayout(null);
	 d1.setSize(550,480);
	 d1.setLocationRelativeTo(null);
	 d1.setVisible(true);
	 d1.getContentPane().setBackground(Color.ORANGE);
	}
	
	public void fastcashframe()
	{
	    d1 = new JFrame("FastCash");
		JLabel samount = new JLabel("Pls Select the Amount");
		samount.setBounds(210,50,190,30);
		d1.add(samount);
		 samount.setFont(new Font("SansSerif",Font.BOLD,16));
		  oneth = new JButton("1000");
		 twoth = new JButton("2000");
		  threeth = new JButton("3000");
		 fifth = new JButton("5000");
		  back = new JButton("<---------");
	    back.setBounds(5,10,90,30);
	   back.setContentAreaFilled(false); 
        back.setFocusPainted(false); 
		back.setBorderPainted(false); 
        back.setOpaque(false);
		back.addActionListener(this);
		  oneth.setBounds(220,120,120,30);
		  twoth.setBounds(220,220,120,30);
		   threeth.setBounds(220,320,120,30);
		   fifth.setBounds(220,420,120,30);
		   back.setBounds(20,10,90,30);
		   //oneth.addActionListener(this);
		   twoth.addActionListener(this);
		   threeth.addActionListener(this);
		   fifth.addActionListener(this);
		  d1.add(oneth);
		   d1.add(twoth);
		  d1.add(threeth);
		  d1.add(fifth);
		  d1.add(back);
	     d1.setSize(600,550);
		 d1.setLocationRelativeTo(null);	
		 d1.getContentPane().setBackground(Color.ORANGE);
		 d1.setLayout(null);
		  d1.setVisible(true);
		  
	}
	
	public void ministmtframe()
	{   
	
	System.out.println("miniframeedededede");
		d1 = new JFrame("MiniStatement");
		d1.setSize(800,500);
		d1.setLocationRelativeTo(null);
		//d1.setLayout(null);
		
		DefaultTableModel model= new DefaultTableModel();
		 model.setColumnIdentifiers(new Object[]{"Acc_no","Trans_type","Towards Acc_no","Amount","Trans_Date","Trans_Time"});
		 JTable table = new JTable();
		  table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scroll = new JScrollPane(table);
		 scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				
				table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
					  table.getTableHeader().setForeground(Color.white);
					 table.getTableHeader().setBackground(Color.black);
					 table.setForeground(Color.blue);
					  table.setFont(new Font("", 1, 15));
                     table.setRowHeight(24);					
				 ok = new JButton("<----------");
				 ok.setBounds(310,410,140,30);
				 
				
				
				
				  try{
					  String abc="select * from transaction where acc_no="+cno+" order by trans_date desc limit 5";
					  System.out.println(abc);
					   c1.ps=c1.con.prepareStatement(abc);
				  c1.rs=c1.ps.executeQuery();
				    while(c1.rs.next())
					{
						String[] arr=c1.rs.getString(5).split(" ");
					   model.addRow(new Object[]{c1.rs.getInt(1),c1.rs.getString(2),c1.rs.getString(3)==null?"--":c1.rs.getString(3),c1.rs.getDouble(4),arr[0],arr[1]});
					}
					
					  
				  }
				  catch(Exception e)
				  {
					  System.out.println(e);
				  }
				 
				 
				//d1.getContentPane().setBackground(Color.ORANGE);
				
				ok.setContentAreaFilled(false); 
				ok.setFocusPainted(false); 
				ok.setBorderPainted(false); 
				ok.setOpaque(false);
				ok.addActionListener(this);
				d1.add(ok);
				d1.add(scroll);
				
				//d1.setLayout(null);
				d1.setVisible(true);
	}
	
	
	
	public void changepinframe()
	{
		d1 = new JFrame("Change PIN");
		 JLabel l1 = new JLabel("Enter current PIN");
		 l1.setBounds(110,103,170,30);
		 l1.setFont(new Font("SansSerif",Font.BOLD,16));
		 l1.setForeground(Color.BLUE);
		 currpin= new JTextField("");
		 currpin.setBounds(300,105,160,25);
		 currpin.setFont(new Font("SansSerif",Font.BOLD,14));
		 JLabel l2 = new JLabel("Enter new PIN");
		 l2.setBounds(110,190,210,30);
		 l2.setFont(new Font("SansSerif",Font.BOLD,16));
		 l2.setForeground(Color.BLUE);
		 newpin= new JTextField("");
		 newpin.setBounds(300,190,160,25);
		 newpin.setFont(new Font("SansSerif",Font.BOLD,14));
		  cp = new JButton("Change PIN");
		  cp.setBounds(260,340,130,30);
		  cp.setBackground(Color.RED);
		  cp.setForeground(Color.WHITE);
		  cp.addActionListener(this);
		   back = new JButton("<---------");
	  back.setBounds(5,10,90,30);
	   back.setContentAreaFilled(false); 
        back.setFocusPainted(false); 
		back.setBorderPainted(false); 
        back.setOpaque(false);
		back.addActionListener(this);
		 d1.add(l1);
		 d1.add(currpin);
		 d1.add(l2);
		 d1.add(newpin);
		 d1.add(cp);
		 d1.add(back);
		d1.setSize(650,500);
		d1.setLayout(null);
		d1.setLocationRelativeTo(null);
		d1.getContentPane().setBackground(Color.ORANGE);
		d1.setVisible(true);
	}
	
	
	
		
	public void proceedcheck(String param)
	{
	 
	 String a,b,query;
	 double var;
	 int found=0,sender,receiver,bal;
	 CallableStatement s;
	try
	{
	
	  if(param=="deposit")
	  { 
		   a=t1.getText();
		   b=t2.getText();
		   System.out.println("se");
		   
		   var=Double.parseDouble(b);
		    sender=Integer.parseInt(cno);
			  receiver=Integer.parseInt(a);
		   if(var>=50)
		   {
			  c1.ps=c1.con.prepareStatement("select count(*) from bkusers where "+"id="+a);
		    c1.rs=c1.ps.executeQuery();
			c1.rs.next();
			found=c1.rs.getInt(1);
			if(found==1)
		   {   
	          System.out.println("op00");
	         
			  System.out.println(sender);
			  System.out.println(receiver);
			  System.out.println(var);
	           t1.setText("");
				 t2.setText("");
				 query="{call p1(?,?,?,?)}";
				  
				  s=c1.con.prepareCall(query);
				 s.setInt(1,sender);
				 s.setInt(2,receiver);
				 s.setDouble(3,var);
				 s.registerOutParameter(4,java.sql.Types.INTEGER);
				 s.execute();
				  found=s.getInt(4);
			  // c1.ps=c1.con.prepareStatement("update bkusers set min_balance=min_balance+"+b+" where id="+a);
			  //found=c1.ps.executeUpdate();
			  if(found==1)
			  {   
					System.out.println("world is happy");
				    c1.ps=c1.con.prepareStatement("insert into transaction values(?,?,?,?,default)");
					c1.ps.setInt(1,sender);
					c1.ps.setString(2,"deposit");
					c1.ps.setInt(3,receiver);
					c1.ps.setDouble(4,var);
					c1.ps.executeUpdate();
					
				 //c1.rs=s.execute();				 
				  if(found==1)
				   JOptionPane.showMessageDialog(null,"Amount Deposited Successfully");
				  else
					 JOptionPane.showMessageDialog(null,"Error");
			  }
			  else
			  {
				  System.out.println("failure");
				  JOptionPane.showMessageDialog(null,"Minimum Accounr Balance should remain Atleast 2000 Rs");
			  } 
			  
		   }
		   else
			   JOptionPane.showMessageDialog(null,"Account no invalid");
		
		   }
		  else{
			  JOptionPane.showMessageDialog(null,"Minimum Depositing Amount should be Rs 50");
		  }
	     // c1.rs=c1.ps.executeQuery();
	  }

      //wirhdraw amount
      if(param=="withdraw" || param=="fastcash")
	  {
		 if(param == "withdraw")
		 {
		  b=t2.getText();
		 }
		 else{
			 b=fast;
			 System.out.println(b);
		 }
		   var=Double.parseDouble(b);
		    sender=Integer.parseInt(cno);
			//  receiver=Integer.parseInt(a);
			  query="{call p2(?,?,?,?)}";
			  if(var>=50)
			  { 
		      c1.ps=c1.con.prepareStatement("select count(*) from bkusers where "+"id="+sender);
		      c1.rs=c1.ps.executeQuery();
			  c1.rs.next();
			  found=c1.rs.getInt(1);
			   if(found==1)
			   {
				   s=c1.con.prepareCall(query);
				 s.setInt(1,sender);
				 s.setDouble(2,var);
				 s.registerOutParameter(3,java.sql.Types.DOUBLE);
				 s.registerOutParameter(4,java.sql.Types.INTEGER);
				 s.execute();
				 found=s.getInt(4);
				 if(found==1)
				 {      
						 c1.ps=c1.con.prepareStatement("insert into transaction values(?,?,?,?,default)");
					c1.ps.setInt(1,sender);
					c1.ps.setString(2,"withdraw");
					c1.ps.setString(3,null);
					c1.ps.setDouble(4,var);
					c1.ps.executeUpdate();
					  t2.setText("");
			 
			 
			 
					 JOptionPane.showMessageDialog(null,"Withdraw Successfull");
					 JOptionPane.showMessageDialog(null,"Your current account balance is Rs"+s.getDouble(3));
				 }
				 else{
					 JOptionPane.showMessageDialog(null,"Insufficient Balance");
				 }
			   }
				 
				 
			  }
			  else{
				  JOptionPane.showMessageDialog(null,"Minimum withdrawal Amount should be Rs 50");
			  }
		  
		 
	  }

         if(param=="balance")
		 {
			
			 c1.ps=c1.con.prepareStatement("select min_balance from bkusers where id="+cno);
			 c1.rs=c1.ps.executeQuery();
			 c1.rs.next();
			   bal=c1.rs.getInt(1);

			 
			JOptionPane.showMessageDialog(null,"Your Current Account  Balance is Rs "+bal); 
			
		 }
	
		 
		 
		
		 
		 
		
		 
		 
		 if(param=="changepin")		 
		 {
			
			  String x="select count(*) from bkusers where id="+cno+" and"+" pin= "+"'"+currpin.getText()+"'"+";";
			 System.out.println(x);
		    c1.ps=c1.con.prepareStatement(x);
			c1.rs=c1.ps.executeQuery();
			c1.rs.next();
			found=c1.rs.getInt(1);
			
			if(found==1)
			{
				//System.out.println("indide");
				//System.out.println(newpin.getText());
				if(newpin.getText().length()>8)
				{ 
			        found=0;
					c1.ps=c1.con.prepareStatement("update bkusers set pin="+"'"+newpin.getText()+"' "+"where id="+cno);
					found=c1.ps.executeUpdate();
					if(found==1)
					{
						JOptionPane.showMessageDialog(null,"PIN changed Successfully");
						currpin.setText("");
						newpin.setText("");
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"PIN should be atleast 8 characters");
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"Incorrect current PIN");
			}
			
			
		 }
		 
	
	}
	catch(Exception e)
	{
		System.out.println(e);
		JOptionPane.showMessageDialog(null,"Pls Enter Proper Details");
	}
	}
	   

	   
	   
	   
	
 public static void main(String[] args)
 {
	 
	atm  a= new atm();
	
  
 }
}


