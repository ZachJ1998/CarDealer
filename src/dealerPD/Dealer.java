package dealerPD;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import DealerDAO.CarDAO;
import DealerDAO.SalesPersonDAO;

@Entity(name = "dealer")
public class Dealer implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id // signifies the primary key
	@Column(name = "dealer_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long dealerId;

	// private long dealerId;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "address", nullable = false, length = 50)
	private String address;
	@Column(name = "city", nullable = false, length = 50)
	private String city;
	@Column(name = "state", nullable = false, length = 2)
	private String state;
	@Column(name = "zip", nullable = false, length = 7)
	private String zip;
	// private Collection<Car> cars;
	// private Collection<SalesPerson> salesPersons;

	// @LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "dealer", targetEntity = Car.class, fetch = FetchType.EAGER)
	private Collection<Car> cars;

	// @LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "dealer", targetEntity = SalesPerson.class, fetch = FetchType.EAGER)
	private Collection<SalesPerson> salesPersons;

	public Dealer()
	{
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public Collection<Car> getCars()
	{
		return cars;
	}

	public Collection<SalesPerson> getSalesPersons()
	{
		return salesPersons;
	}

	public void addCar(Car car)
	{
		car.setDealer(this);
		CarDAO.addCar(car);
	}

	public void removeCar(Car car)
	{

		CarDAO.removeCar(car);
	}

	public void addSalesPerson(SalesPerson salesPerson)
	{
		salesPerson.setDealer(this);
		SalesPersonDAO.addSalesPerson(salesPerson);
	}

	public void removeSalesPerson(SalesPerson salesPerson)
	{
		SalesPersonDAO.removeSalesPerson(salesPerson);
	}

	public int getCarForSaleCount()
	{
		int count = 0;
		if(getCars() == null)
			return count;
		
		for (Car car : getCars())
		{
			if (car.getDateSold() == null)
				count = count + 1;
		}
		return count;

	}

	public int getCarsSoldThisMonth()
	{
		int count = 0;
		if(getCars() == null)
			return count;
		for (Car car : getCars())
		{
			if ((car.getDateSold().getMonth() == LocalDate.now().getMonth())
					&& (car.getDateSold().getYear() == LocalDate.now()
							.getYear()))
				count = count + 1;
		}
		return count;

	}

	public String toString()
	{
		return getName();
	}

	public long getDealerId()
	{
		return dealerId;
	}

	public void setDealerId(long dealerId)
	{
		this.dealerId = dealerId;
	}

	public void setCars(Collection<Car> cars)
	{
		this.cars = cars;
	}

	public void setSalesPersons(Collection<SalesPerson> salesPersons)
	{
		this.salesPersons = salesPersons;
	}
}
