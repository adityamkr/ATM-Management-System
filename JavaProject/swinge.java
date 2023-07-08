import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

class swinge
{
  
  public static void main(String[] args)
  {
   JFrame frame1 =new JFrame("myfrcame");
   System.out.println("bhdcwf");
    DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"name","city"});
		 JTable table = new JTable();
		 JButton b = new JButton("btn");
		 b.setBounds(30,170,40,20);
        table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		String uname="adi";
		String email="adi123";
		model.addRow(new Object[]{uname, email});
		
		frame1.add(b);
		frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(400, 300);
		
		b.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
		 // frame1.dispose();
		  //frame1.setVisible(true);
		  frame1.revalidate();
          frame1.repaint();
		 System.out.println("hello");
		 model.addRow(new Object[]{"kedar","abhi"});
		 // table.repaint()
		}
		}
		);
  } 
  }
  