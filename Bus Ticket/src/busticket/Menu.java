package busticket;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Menu extends JFrame {
	private JMenu mnuroute,mnubus;
	private JMenuItem itmnewroute,itmrlist,itembus,itmblist;
	private JMenuBar bar;
	private SessionFactory factory;//creates an environment for sharing data securely
	
	public Menu(String title,SessionFactory f){
		super(title);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		factory=f;
		setLayout(new BorderLayout());
		
		bar=new JMenuBar();
		
		mnuroute=new JMenu("Route");
		itmnewroute=new JMenuItem("New Route");
		itmnewroute.addActionListener((e)->{
			NewRouteFrame ob=new NewRouteFrame("Route List",factory);
			//dispose();
		});
		
		itmrlist=new JMenuItem("Route list");
		itmrlist.addActionListener((e)->{
			
			ViewRouteFrame vrf=new ViewRouteFrame("Route List",factory);
			
		});
		mnuroute.add(itmnewroute);
		mnuroute.add(itmrlist);
		
		mnubus=new JMenu("Bus");
		itembus=new JMenuItem("New Bus");
		itembus.addActionListener((e)->{
			NewBusFrame ob=new NewBusFrame("Bus List",factory);
			//dispose();
		});
		itmblist=new JMenuItem("Bus List");
		itmblist.addActionListener((e)->{
			
			ViewBusFrame vrf=new ViewBusFrame("Bus List",factory);
			
		});
		
		mnubus.add(itembus);
		mnubus.add(itmblist);

		bar.add(mnubus);
		bar.add(mnuroute);
		setJMenuBar(bar);
		setSize(300,300);
		setVisible(true);
		
		


}
	/*public static void main(String[] args) {
		Menu ob=new Menu("Route List",createSessionFactory());
	}
	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

	}*/

}
