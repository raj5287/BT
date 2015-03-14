package busticket;
import customer.CheckBusFrame;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class Launcher {

	public static void main(String[] args) {
		
		CheckBusFrame ob=new CheckBusFrame("searching",createSessionFactory());
		//Menu ob=new Menu("bus List",createSessionFactory());
		
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
