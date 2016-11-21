package service;

import java.util.List;

import javax.ejb.Local;



import domain.Credit;

@Local
public interface ManageCreditLocal {

	
	public Boolean addCredit(Credit credit);
	
	
	
	public Boolean updateCredit(Credit credit);
	public Boolean deleteCredit(Credit credit);
	public Credit findCreditById(int idCredit);
	public List<Credit> findAllCredits();

	
	
}
