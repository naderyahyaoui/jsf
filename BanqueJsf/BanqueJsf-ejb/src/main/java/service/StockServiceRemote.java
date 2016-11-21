package service;

import java.util.List;

import javax.ejb.Remote;

import domain.Stock;





@Remote
public interface StockServiceRemote {
	
	void saveOrUpdate(Stock stock);
	void createStock(Stock stock);
	void saveStock(Stock stock);
	Stock findStockById(long id_Stock);
	void removeStock(Stock stock);
	List<Stock> findAllStocks();
	List<Object[]> StatisticDoc();

	

}
