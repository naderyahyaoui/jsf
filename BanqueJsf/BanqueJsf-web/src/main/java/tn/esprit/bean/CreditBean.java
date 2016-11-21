package tn.esprit.bean;


import java.util.List;

import javax.ejb.EJB;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;





import javax.faces.model.SelectItem;

import service.ManageCredit;
import domain.Credit;



@ManagedBean
@ViewScoped
public class CreditBean {
	
	@EJB
	private ManageCredit manageCredit;
	
	private List<Credit> Credits;
	private List<Credit>filetredCredits;
	
	private List<SelectItem> creditsFilterOptions;

	private boolean formDisplayed = true;
	
	private Credit credit;
	private CreditCard creditCard = new CreditCard();
	
	public CreditBean(){
		
	}
	@PostConstruct
	public void init() {
		
		credit = new Credit();
		Credits = manageCredit.findAllCredits();
		formDisplayed=false;
	}
	public void doSave() {
      
		manageCredit.updateCredit(credit);
		System.out.println("saving"+credit.getIdCredit());
		Credits = manageCredit.findAllCredits();
		formDisplayed = false;
	}
	public void doNew() {
		credit=new Credit();
		formDisplayed = true;
		
	}
	public void doPay() {
		
		formDisplayed = true;
		
	}
	public String doDelete(Credit credit) {
		String navTo=null;
		manageCredit.deleteCredit(credit);
		Credits = manageCredit.findAllCredits();
		formDisplayed = false;
		return navTo;
		
	}
	
	public void doCancel() {
		
		
		formDisplayed = false;
		
	}
	public void onRowSelect() {
		formDisplayed = true;
	}
	public void onFilter(){
		credit = new Credit();
		formDisplayed = false;
	}
	public ManageCredit getManageCredit() {
		return manageCredit;
	}
	public void setManageCredit(ManageCredit manageCredit) {
		this.manageCredit = manageCredit;
	}
	public List<Credit> getCredits() {
		return Credits;
	}
	public void setCredits(List<Credit> credits) {
		Credits = credits;
	}
	public List<Credit> getFiletredCredits() {
		return filetredCredits;
	}
	public void setFiletredCredits(List<Credit> filetredCredits) {
		this.filetredCredits = filetredCredits;
	}
	public List<SelectItem> getCreditsFilterOptions() {
		return creditsFilterOptions;
	}
	public void setCreditsFilterOptions(List<SelectItem> creditsFilterOptions) {
		this.creditsFilterOptions = creditsFilterOptions;
	}
	public boolean isFormDisplayed() {
		return formDisplayed;
	}
	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
	public Credit getCredit() {
		return credit;
	}
	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	public void makePayement() {
		
		 formDisplayed = false;
				Stripe.makePayement((int)(credit.getMontantSouhaite()),creditCard.getCardHolderName(), creditCard.getCardNumber(),
						creditCard.getCardExpMonth(), creditCard.getCardExpYear());
			}
	
}
