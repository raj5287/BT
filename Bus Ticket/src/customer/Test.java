package customer;

import org.hibernate.SessionFactory;

public class Test {

	private static SessionFactory factory;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckBusFrame cb= new CheckBusFrame("Tst",factory);

	}

}
