package busticket;
import java.awt.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class NewRouteFrame extends JFrame {
	
	private JLabel lblsource,lbldestination,lbldistance;
	private JTextField txtFirst,txtSecond,txtthird;
	private JButton btnSave;
	
	private SessionFactory factory;
	
	public NewRouteFrame(String title,SessionFactory factory){
		super(title);
		
		this.factory=factory;
		
		setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		JPanel centerPanel=new JPanel();
		centerPanel.setLayout(new GridLayout(4,3));
	
		
		
		lblsource=new JLabel("source");
		centerPanel.add(lblsource);
		txtFirst=new JTextField(10);
		centerPanel.add(txtFirst);
		
		lbldestination=new JLabel("destination");
		centerPanel.add(lbldestination);
		txtSecond=new JTextField(10);
		centerPanel.add(txtSecond);
		

		lbldistance=new JLabel("distance");
		centerPanel.add(lbldistance);
		txtthird=new JTextField(10);
		centerPanel.add(txtthird);
		

		
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		btnSave=new JButton("save");
		buttonPanel.add(btnSave);
		
		btnSave.addActionListener((evt)->{
			Route pm=new Route(txtFirst.getText(),txtSecond.getText(),Integer.parseInt(txtthird.getText()));
			
			Session s=factory.openSession();
			Transaction tx=s.beginTransaction();
			
			s.save(pm);
			
			tx.commit();
			
			JOptionPane.showMessageDialog(NewRouteFrame.this, "route generated ....route id : "+pm.getRouteid());
			
			
		});
		
		add(BorderLayout.CENTER,centerPanel);
		add(BorderLayout.SOUTH,buttonPanel);
		
		setSize(300,300);
		setVisible(true);
		
		
		
		}
}
