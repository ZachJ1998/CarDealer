package dealerPD;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "car")
public class Car implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id //signifies the primary key
    @Column(name = "car_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long carId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "dealer_id", referencedColumnName = "dealer_id")
	private Dealer dealer;
	
	@Column(name = "make", nullable = false, length = 20)
	private String make;
	
	@Column(name = "model", nullable = false, length = 20)
	private String model;
	
	@Column(name = "year", nullable = false, length = 4)
	private String year;
	
	@Column(name = "price", nullable = false, precision = 7, scale = 2)
	private BigDecimal price;
	
	@Column(name = "date_purchased")
	private LocalDate datePurchased;
	
	@Column(name = "dateSold")
	private LocalDate dateSold;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "salesperson_id", referencedColumnName = "salesperson_id")
	private SalesPerson salesPerson;
	
	@Column(name = "serialNumber", nullable = false, length = 20)
	private String serialNumber;
	
	
	public Car()
	{
	}

	public String getMake()
	{
		return make;
	}

	public void setMake(String make)
	{
		this.make = make;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public LocalDate getDatePurchased()
	{
		return datePurchased;
	}

	public void setDatePurchased(LocalDate datePurchased)
	{
		this.datePurchased = datePurchased;
	}

	public String getSerialNumber()
	{
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	public SalesPerson getSalesPerson()
	{
		return salesPerson;
	}

	public void setSalesPerson(SalesPerson salesPerson)
	{
		this.salesPerson = salesPerson;
	}

	public LocalDate getDateSold()
	{
		return dateSold;
	}

	public void setDateSold(LocalDate dateSold)
	{
		this.dateSold = dateSold;
	}

	public boolean isOkToRemove()
	{
		if (getSalesPerson() == null)
			return true;
		else
			return false;
	}

	public String toString()
	{
		return getMake() + " " + getModel() + " " + getYear() + " "
				+ getSerialNumber();
	}

	public long getCarId()
	{
		return carId;
	}

	public void setCarId(long carId)
	{
		this.carId = carId;
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
