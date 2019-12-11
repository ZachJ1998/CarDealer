package DealerDAO;

import java.util.List;
import javax.persistence.TypedQuery;
import dealerPD.Dealer;

public class dealerDAO
{
	public static void saveDealer(Dealer dealer)
	{

		EmDAO.getEM().persist(dealer);
	}

	public static void addDealer(Dealer dealer)
	{
		EmDAO.getEM().persist(dealer);
	}

	public static List<Dealer> listDealer()
	{
		TypedQuery<Dealer> query = EmDAO.getEM().createQuery("SELECT dealer FROM dealer dealer", Dealer.class);

		return query.getResultList();
	}

	public static Dealer findDealerById(int id)
	{
		Dealer dealer = EmDAO.getEM().find(Dealer.class, new Integer(id));
		return dealer;
	}

	public static void removeDealer(Dealer dealer)
	{
		EmDAO.getEM().remove(dealer);
	}
}
