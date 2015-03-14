package busticket;
import java.awt.*;

import javax.swing.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class adminlog extends JFrame {
	
	private JLabel lbluser,lblpass;
	private JButton btnsubmit, btnclear;
	private JTextField txtuser,txtpass;
	
	
	public adminlog(String title)
	{
	
		super(title);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Box mainbox= Box.createVerticalBox();
		
		Box firstbox=Box.createHorizontalBox();
		lbluser = new JLabel("username");
		txtuser=new JTextField(10);
		firstbox.add(lbluser);
		firstbox.add(txtuser);
		
		Box secondbox=Box.createHorizontalBox();
		lblpass = new JLabel("password");
		txtpass=new JTextField(10);
		secondbox.add(lblpass);
		secondbox.add(txtpass);
	
		Box thirdbox=Box.createHorizontalBox();
		btnsubmit =new JButton("Submit");
		
		btnsubmit.addActionListener((e)->{
			new Menu("Route List",createSessionFactory());
			dispose();
		});
		
		btnclear = new JButton("Clear");
		
		btnclear.addActionListener((e)->{
			
		});
		
		thirdbox.add(btnsubmit);
		thirdbox.add(btnclear);
		
		
		mainbox.add(firstbox);
		mainbox.add(secondbox);
		mainbox.add(thirdbox);
		add(mainbox);
		
		setSize(300, 300);
		setVisible(true);
	
	}

	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

	}
}
