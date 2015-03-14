package busticket;
import java.awt.*;

import javax.swing.*;

public class ConfirmBooking extends JFrame {
	private JLabel lblbusid,lbldate;
	private JTextField idtxt;
	private JComboBox combodate,combomonth,comboyear;
	private JButton btnconfirm;
	public ConfirmBooking(String title){
		super(title);
		

		Box mainbox=Box.createVerticalBox();
		
		Box firstbox=Box.createHorizontalBox();
		
		lblbusid=new JLabel("busid");
		firstbox.add(lblbusid);
		firstbox.add(Box.createHorizontalStrut(20));
		idtxt=new JTextField("");
		firstbox.add(idtxt);
		
		
		Box secondbox=Box.createHorizontalBox();
		lbldate=new JLabel("Date");
		secondbox.add(lbldate);
		secondbox.add(Box.createHorizontalStrut(25));
		String day[]={" ","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22",

        "23","24","25","26","27","28","29","30","31"};

		combodate=new JComboBox(day);
		secondbox.add(combodate);
		
		
		
		String month[]={" ","jan","feb","mar","apr","may","june","july","aug","sept","oct","nov","dec"};
		combomonth=new JComboBox(month);
		secondbox.add(combomonth);

		
		String year[]={" ","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
		comboyear=new JComboBox(year);
		secondbox.add(comboyear);
		

		Box thirdbox=Box.createHorizontalBox();
		btnconfirm=new JButton("confirm");
		thirdbox.add(btnconfirm);
		
		mainbox.add(firstbox);
		mainbox.createGlue();
		mainbox.add(secondbox);
		mainbox.createVerticalStrut(20);
		mainbox.add(thirdbox);
		
		add(mainbox);
		setSize(300,150);
		//pack();
		setVisible(true);
}


}
		

