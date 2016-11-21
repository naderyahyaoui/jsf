package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Stock;



/**
 * Session Bean implementation class StockService
 */
@Stateless
@LocalBean
public class StockService implements StockServiceRemote, StockServiceLocal {

	@PersistenceContext
	private EntityManager em ;
    /**
     * Default constructor. 
     */
    public StockService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createStock(Stock stock) {
		em.persist(stock);
	}

	@Override
	public void saveStock(Stock stock) {
		em.merge(stock);
		
	}

	@Override
	public Stock findStockById(long id_Stock) {
		Stock sto=null;
		try {
			sto=em.find(Stock.class, id_Stock);
    	
    	} catch (Exception e) {
    	}return sto ;
	}

	@Override
	public void removeStock(Stock stock) {
		em.remove(em.merge(stock));
		
	}

	@Override
	public List<Stock> findAllStocks() {
		return em.createQuery("select s from Stock s", Stock.class)
				.getResultList();
	}

	@Override
	public void saveOrUpdate(Stock stock) {
		em.merge(stock);
		
		
	}
	@Override
	public List<Object[]> StatisticDoc() {
		
		Query q = em.createQuery("select d.prix , count(*) from Stock d group by prix");
		return q.getResultList();
	 }

	
}
