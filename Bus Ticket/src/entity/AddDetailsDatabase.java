package entity;
import java.awt.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.*;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="Add Detail")

public class AddDetailsDatabase {
	
	@Id
	@GenericGenerator(name="pk_gen",strategy="increment")
	@GeneratedValue(generator="pk_gen")
	
	private String busname,bustype;
	private int nuseats,arrtym,deptym,busno;
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
	}
	public String getBustype() {
		return bustype;
	}
	public void setBustype(String bustype) {
		this.bustype = bustype;
	}
	public int getNuseats() {
		return nuseats;
	}
	public void setNuseats(int nuseats) {
		this.nuseats = nuseats;
	}
	public int getArrtym() {
		return arrtym;
	}
	public void setArrtym(int arrtym) {
		this.arrtym = arrtym;
	}
	public int getDeptym() {
		return deptym;
	}
	public void setDeptym(int deptym) {
		this.deptym = deptym;
	}
	public AddDetailsDatabase(String busname, String bustype, int nuseats,
			int arrtym, int deptym) {
		super();
		this.busname = busname;
		this.bustype = bustype;
		this.nuseats = nuseats;
		this.arrtym = arrtym;
		this.deptym = deptym;
	}
	public AddDetailsDatabase() {
		super();
	}
	

}
