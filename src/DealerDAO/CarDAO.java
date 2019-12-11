package DealerDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import dealerPD.Car;



public class CarDAO 
{
	public static void saveCar(Car car) {
		
		EmDAO.getEM().persist(car);
	}
	
		public static void addCar(Car car) {
			EmDAO.getEM().persist(car);
		}

		public static List<Car> listCar() {
			TypedQuery<Car> query = EmDAO.getEM().createQuery("SELECT car FROM car car", Car.class);

			return query.getResultList();
		}

		public static Car findCarById(int id) {
			Car car = EmDAO.getEM().find(Car.class, new Integer(id));
			return car;
		}

		public static void removeCar(Car car) {
			EmDAO.getEM().remove(car);
		}
		
		
}
