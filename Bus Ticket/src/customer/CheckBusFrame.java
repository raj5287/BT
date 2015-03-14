package customer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.List;

import javax.swing.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import busticket.Bus;
import busticket.Route;

public class CheckBusFrame extends JFrame {
	
	private JLabel lblsource,lbldest;
	private JTextField txtsource,txtdest;
	private JButton btncheck;
	private JTable tableBus;
	private int r;
	
	private SessionFactory factory;
	
	public CheckBusFrame(String title,SessionFactory f)
	{
		super (title);
		factory=f;
		
		setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		JPanel centerPanel=new JPanel();
		centerPanel.setLayout(new GridLayout(4,3));

		
		lblsource=new JLabel("Source");
		centerPanel.add(lblsource);
		txtsource=new JTextField(10);
		centerPanel.add(txtsource);
		
		lbldest=new JLabel("Destination");
		centerPanel.add(lbldest);
		txtdest=new JTextField(10);
		centerPanel.add(txtdest);
		

		
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		btncheck=new JButton("Check");
		buttonPanel.add(btncheck);
		btncheck.addActionListener((e)->{
		
			Session s=factory.openSession();
			
			String hql="from Route";
			Query q=s.createQuery(hql);
			
			List<Route> list=q.list();
			String m=txtsource.getText();
			String n=txtdest.getText();
			
			for(Route g: list){
				if(m.equals(g.getSource()) && n.equals(g.getDestination()))
				{
		
					Collection<Bus> t = g.getBuses();
					String hql1="from t";
					Query q1=s.createQuery(hql1);
					
					List<Bus> list1=q1.list();
					
					String records[][]=new String[list.size()][4];
					int r=0;
					for(Bus bb : list1){
						records[r][0]=String.valueOf(bb.getBusid());
						records[r][1]=bb.getType();
						records[r][2]=String.valueOf(bb.getFare());
						r++;
						
					}
					String colnames[]={"Bus Id","Type","Fare"};
					tableBus =new JTable(records,colnames);
					add(new JScrollPane(tableBus));
				}
			}
				
			
			
		});
		
		
		add(BorderLayout.CENTER,centerPanel);
		add(BorderLayout.SOUTH,buttonPanel);
		
		
		setSize(300,300);
		setVisible(true);

}
}