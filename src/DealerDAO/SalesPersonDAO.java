package DealerDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dealerPD.Car;
import dealerPD.Dealer;
import dealerPD.SalesPerson;

public class SalesPersonDAO 
{
	public static void saveSalesPerson(SalesPerson salesPerson) {
		
		EmDAO.getEM().persist(salesPerson);
	}
	
		public static void addSalesPerson(SalesPerson salesPerson) {
			EmDAO.getEM().persist(salesPerson);
		}

		public static List<SalesPerson> listSalesPerson() {
			TypedQuery<SalesPerson> query = EmDAO.getEM().createQuery("SELECT sales_person FROM sales_person sales_person", SalesPerson.class);

			return query.getResultList();
		}

		public static SalesPerson findSalesPersonById(int id) {
			SalesPerson salesPerson = EmDAO.getEM().find(SalesPerson.class, new Integer(id));
			return salesPerson;
		}

		public static void removeSalesPerson(SalesPerson salesPerson) {
			EmDAO.getEM().remove(salesPerson);
		}
}
