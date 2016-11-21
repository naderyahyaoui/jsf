package service;

import java.util.List;

import javax.ejb.Local;

import domain.Stock;




@Local
public interface StockServiceLocal {
	void saveOrUpdate(Stock stock);
	void createStock(Stock stock);
	void saveStock(Stock stock);
	Stock findStockById(long id_Stock);
	void removeStock(Stock stock);
	List<Stock> findAllStocks();


}
