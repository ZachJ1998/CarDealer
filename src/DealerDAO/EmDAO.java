package DealerDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
// entity manger 
public class EmDAO {
		
		static EntityManagerFactory entityManagerFactory;
		static EntityManager em;
		
		public static void initEM()
		{
		entityManagerFactory =  Persistence.createEntityManagerFactory("Dealer");
	    em = entityManagerFactory.createEntityManager();
		}
		
		public static EntityManager getEM()
		{
			if (em==null)
			{ 
				initEM();
			
			}
			return em;
		}
		
		public static void close()
		{
			em.close();
		    entityManagerFactory.close();
		}

	}

