package tn.esprit.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.event.SelectEvent;

import domain.Stock;
import service.StockServiceLocal;


@ManagedBean
@ViewScoped
public class StockBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2100356039100785167L;

	@EJB
	private StockServiceLocal stocklocal;
	private Stock stock;
    private List<Stock> stocks;
	private boolean formDisplayed = false;

	@PostConstruct
	public void init() {
		stock = new Stock();
		stocks = stocklocal.findAllStocks();
	}
	
	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
	public void doNew() {
		stock = new Stock();
		formDisplayed = true;

	
	}
	public void doSave() {

		stocklocal.saveOrUpdate(stock);
		stocks = stocklocal.findAllStocks();

		formDisplayed = false;

	}

	public void doRemove() {

		stocklocal.removeStock(stock);
		stocks = stocklocal.findAllStocks();
		formDisplayed = false;

	
	}
	public void OnFilter(){
		formDisplayed = false;
	}

	

	public void onRowSelect(SelectEvent event) {
		

		formDisplayed = true;

	}

	public void doCancel() {
		
		formDisplayed = false;


	}

	public List<Stock> getallstock() {

		return stocklocal.findAllStocks();

	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public StockServiceLocal getStocklocal() {
		return stocklocal;
	}

	public void setStocklocal(StockServiceLocal stocklocal) {
		this.stocklocal = stocklocal;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	

}
