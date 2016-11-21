package tn.esprit.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import service.ManageCredit;
import domain.Credit;

@ManagedBean
@SessionScoped
public class ChartBean {

	@EJB
	private ManageCredit manageCredit;
	private HashMap<String, Double> percentageMontantCredit;
	private List<Credit> listCredit;

	private Integer nbMontant;

	@PostConstruct
	public void init() {
		nbMontant = manageCredit.findAllCredits().size();
		calculateMontantCredit();
	}

	public void calculateMontantCredit() {
		List<Credit> lisCredits = manageCredit.findAllCredits();
		int sizeCredits = lisCredits.size();
		List<Double> listMontant = new ArrayList<>();

		percentageMontantCredit = new HashMap<>();
		percentageMontantCredit.put("credit entre 1000 et 3000", 0d);
		percentageMontantCredit.put("credit entre 4000 et 6000", 0d);
		if (lisCredits != null)
			for (Credit credit : lisCredits) {
				listMontant.add(credit.getMontantSouhaite());
			}

		int size1 = 0;
		int size2 = 0;
		for (Double montant : listMontant) {
			if (montant >= 1000 && montant <= 3000)
				size1++;
			else if (montant > 3000 && montant <= 6000)
				size2++;
		}
		percentageMontantCredit
				.put("a1", Math.floor(((double)size1*100/nbMontant) * 100) / 100);
		percentageMontantCredit
				.put("a2", Math.floor(((double)size2*100/nbMontant) * 100) / 100);

	
	}

	public ManageCredit getManageCredit() {
		return manageCredit;
	}

	public void setManageCredit(ManageCredit manageCredit) {
		this.manageCredit = manageCredit;
	}

	public HashMap<String, Double> getPercentageMontantCredit() {
		return percentageMontantCredit;
	}

	public void setPercentageMontantCredit(
			HashMap<String, Double> percentageMontantCredit) {
		this.percentageMontantCredit = percentageMontantCredit;
	}

	public List<Credit> getListCredit() {
		return listCredit;
	}

	public void setListCredit(List<Credit> listCredit) {
		this.listCredit = listCredit;
	}

	public Integer getNbMontant() {
		return nbMontant;
	}

	public void setNbMontant(Integer nbMontant) {
		this.nbMontant = nbMontant;
	}

}
