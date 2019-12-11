package dealerPD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import DealerDAO.CarDAO;

@Entity(name = "sales_person")
public class SalesPerson implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id // signifies the primary key
	@Column(name = "salesperson_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long salesPersonId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "dealer_id", referencedColumnName = "dealer_id")
	private Dealer dealer;

	@Column(name = "name", nullable = false, length = 40)
	private String name;

	@Column(name = "position", nullable = false, length = 20)
	private String position;

	@OneToMany(mappedBy = "salesPerson", targetEntity = Car.class, fetch = FetchType.EAGER)
	private Collection<Car> cars;
	
	
	public SalesPerson()
	{ }

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public Collection<Car> getCars()
	{
		return cars;
	}

	public void addCar(Car car)
	{
		CarDAO.addCar(car);
	}

	public void removeCar(Car car)
	{
		CarDAO.removeCar(car);
	}

	public boolean isOkToRemove()
	{
		if (getCars().size() == 0)
			return true;
		else
			return false;
	}

	public String toString()
	{
		return getName();
	}

	public long getSalesPersonId()
	{
		return salesPersonId;
	}

	public void setSalesPersonId(long salesPersonId)
	{
		this.salesPersonId = salesPersonId;
	}

	public void setCars(Collection<Car> cars)
	{
		this.cars = cars;
	}

	public Dealer getDealer()
	{
		return dealer;
	}

	public void setDealer(Dealer dealer)
	{
		this.dealer = dealer;
	}
}
