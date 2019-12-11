package dealerHI;

import java.util.List;

import DealerDAO.dealerDAO;
import dealerPD.Dealer;

public class DealerStart
{
	public static void main(String[] args)
	{
		Dealer dealer;
		List<Dealer> listDealer = dealerDAO.listDealer();
		if (listDealer.isEmpty())
			dealer = new Dealer();
		else
			dealer = listDealer.get(0);
		DealerFrame.open(dealer);
	}

}
