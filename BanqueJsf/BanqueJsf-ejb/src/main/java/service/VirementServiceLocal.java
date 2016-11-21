package service;

import java.util.List;

import javax.ejb.Local;

import domain.CompteEpargne;
import domain.Virement;


@Local
public interface VirementServiceLocal {

	public Boolean addVirement(Virement v);
	public Virement findById(int idV);
	public List<Virement> findAll();
}
