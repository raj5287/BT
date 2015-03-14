package busticket;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="bus")
public class Bus {
	
	private Route route;
	
	private int routeid,fare,busid,totalbooked;
	private String type;
	
	
	private Collection<BusSchedule> schedules=new ArrayList<>();
	
	@OneToMany(mappedBy = "bus",cascade=javax.persistence.CascadeType.ALL)
	public Collection<BusSchedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(Collection<BusSchedule> schedules) {
		this.schedules = schedules;
	}
	public void addSchedule(BusSchedule v){
		schedules.add(v);
	}
	
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	@Column
	public int getTotalbooked() {
		return totalbooked;
	}
	public void setTotalbooked(int totalbooked) {
		this.totalbooked = totalbooked;
	}
	@Id
	@GenericGenerator(name="pk_gen",strategy="increment")
	@GeneratedValue(generator="pk_gen")
	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	@Column
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Bus() {
		super();
	}
	
	@ManyToOne
	@JoinColumn(name="routeid")
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Bus(Route route, int fare, String type) {
		super();
		this.route = route;
		this.fare = fare;
		this.type = type;
		this.totalbooked = totalbooked;
	}
	
	
	

}
