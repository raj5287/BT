package busticket;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="busschedule")
public class BusSchedule {
	private int scheduleid,totalbooked;
	private java.util.Date jdate;

	private Bus bus;
	@Id
	@GenericGenerator(name="pk_gen",strategy="increment")
	@GeneratedValue(generator="pk_gen")
	public int getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(int scheduleid) {
		this.scheduleid = scheduleid;
	}
	@Column
	public Date getJdate() {
		return jdate;
	}

	public void setJdate(Date jdate) {
		this.jdate = jdate;
	}
	@Column
	public int getTotalbooked() {
		return totalbooked;
	}

	public void setTotalbooked(int totalbooked) {
		this.totalbooked = totalbooked;
	}

	public BusSchedule(Date jdate, int totalbooked,Bus bus) {
		super();
		this.bus=bus;
		this.jdate = jdate;
		this.totalbooked = totalbooked;
	}

	public BusSchedule() {
		super();
	}

	@ManyToOne
	@JoinColumn(name="busid")
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	

}
