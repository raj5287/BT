package busticket;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class ViewRouteFrame extends JFrame {
	
	
	private JPanel p;
	private JTable tableRoute;
	
	private SessionFactory factory;
	public ViewRouteFrame(String title,SessionFactory f){
		super(title);
		
		factory=f;
		
		Session s=factory.openSession();
		
		String hql="from Route";
		Query q=s.createQuery(hql);
		
		List<Route> list=q.list();
		
		String records[][]=new String[list.size()][4];
		int r=0;
		for(Route rr : list){
			records[r][0]=String.valueOf(rr.getRouteid());
			records[r][1]=rr.getSource();
			records[r][2]=rr.getDestination();
			records[r][3]=String.valueOf(rr.getDistance());
			r++;
			
		}
		String colnames[]={"Route Id","Source","Destination","Distance"};
		tableRoute =new JTable(records,colnames);
		add(new JScrollPane(tableRoute));
		
		pack();
		setVisible(true);
}
}
