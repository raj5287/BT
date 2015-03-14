package busticket;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class NewBusFrame extends JFrame {
	private JLabel lbltype,lblfare,lblrouteid;
	private JTextField txttype,txtfare,txtrouteid;
	private JButton btnSave;
	private SessionFactory factory;
	
	public NewBusFrame(String title,SessionFactory factory){
		super(title);
		
		//this.factory=factory;

		
		
	setLayout(new BorderLayout());
	setLayout(new BorderLayout());
	JPanel centerPanel=new JPanel();
	centerPanel.setLayout(new GridLayout(4,3));

	
	lblrouteid=new JLabel("Route id");
	centerPanel.add(lblrouteid);
	txtrouteid=new JTextField(10);
	centerPanel.add(txtrouteid);
	
	lbltype=new JLabel("Bustype");
	centerPanel.add(lbltype);
	txttype=new JTextField(10);
	centerPanel.add(txttype);
	
	lblfare=new JLabel("Bus fare");
	centerPanel.add(lblfare);
	txtfare=new JTextField(10);
	centerPanel.add(txtfare);
	


	

	
	JPanel buttonPanel=new JPanel();
	buttonPanel.setLayout(new FlowLayout());
	btnSave=new JButton("save");
	buttonPanel.add(btnSave);
	btnSave.addActionListener((e)->{
		Session s=factory.openSession();
		Route r = (Route)s.get(Route.class,1);
		Bus pm=new Bus(r,Integer.parseInt(txtfare.getText()),txttype.getText());
		
		Calendar cal=Calendar.getInstance();
		for(int i=1;i<=30;i++)
		{
			cal.add(Calendar.DAY_OF_MONTH, 1);
			Date d=cal.getTime();
			System.out.println("d "+d);
			BusSchedule b=new BusSchedule(d,0,pm);
			pm.addSchedule(b);
		}

		Transaction tx=s.beginTransaction();
		
		s.save(pm);
		
		tx.commit();
		
		JOptionPane.showMessageDialog(NewBusFrame.this, "busid generated ....bus id : "+pm.getBusid());
		
		
		});
	
	add(BorderLayout.CENTER,centerPanel);
	add(BorderLayout.SOUTH,buttonPanel);
	
	setSize(300,300);
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