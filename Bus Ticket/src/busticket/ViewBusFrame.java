package busticket;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class ViewBusFrame extends JFrame {
	
	private JButton btnback;
	private JPanel p;
	private JTable tableBus;
	
	private SessionFactory factory;
	public ViewBusFrame(String title,SessionFactory f){
		super(title);
		
		factory=f;
		
		Session s=factory.openSession();
		
		String hql="from Bus";
		Query q=s.createQuery(hql);
		
		List<Bus> list=q.list();
		
		String records[][]=new String[list.size()][4];
		int r=0;
		for(Bus bb : list){
			records[r][0]=String.valueOf(bb.getBusid());
			records[r][1]=bb.getType();
			records[r][2]=String.valueOf(bb.getFare());
			records[r][3]=String.valueOf(bb.getTotalbooked());
			r++;
			
		}
		String colnames[]={"Bus Id","Type","Fare","Total Booked"};
		tableBus =new JTable(records,colnames);
		add(new JScrollPane(tableBus));
		
		btnback = new JButton("Back");
		
		btnback.addActionListener((e)->{
			dispose();
			
		});
		//add(btnback);
		pack();
		setVisible(true);
}
}
