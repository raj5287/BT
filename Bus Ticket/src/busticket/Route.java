package busticket;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="route")
public class Route {
	
	
	
	private int routeid;
	private String source, destination;
	private int distance;
	
	private Collection<Bus> buses=new ArrayList<>();
	
	@OneToMany(mappedBy ="route")
	public Collection<Bus> getBuses() {
		return buses;
	}

	public void setBuses(Collection<Bus> buses) {
		this.buses = buses;
	}

	
	@Id
	@GenericGenerator(name="pk_gen",strategy="increment")
	@GeneratedValue(generator="pk_gen")
	public int getRouteid() {
		return routeid;
	}
	public void setRouteid(int route_id) {
		this.routeid = route_id;
	}
	@Column
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Column(name="dest")
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	@Column
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Route(String source, String destination, int distance) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}
	public Route() {
		super();
	}
}
