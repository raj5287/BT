package busticket;
import java.awt.*;

import customer.CheckBusFrame;

import javax.swing.*;

import org.hibernate.SessionFactory;


public class MainPage extends JFrame {
	
	private JMenu mnuser;
	private JMenuItem itmadmin,itmcust;
	private JMenuBar bar;
	private SessionFactory factory;
	
	public MainPage(String title)
	{
		super(title);
		
		setLayout(new BorderLayout());
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bar=new JMenuBar();
		
		mnuser=new JMenu("USER");
		itmadmin=new JMenuItem("Admin Login");
		
		itmadmin.addActionListener((e)->{
			new adminlog("ADMIN LOGIN");
			//dispose();
		});
		itmcust=new JMenuItem("Ticket Booking");
		
		itmcust.addActionListener((e)->{
			new CheckBusFrame("ADMIN LOGIN",factory);
			//dispose();
		});
		
		mnuser.add(itmadmin);
		mnuser.add(itmcust);

		bar.add(mnuser);
		setJMenuBar(bar);
		setSize(300, 300);
		setVisible(true);
		
		
	}
	
	public static void main(String args[]) {
		
		MainPage ob1= new MainPage("BUS TICKET SYSTEM");
		
	}
	
	
}
