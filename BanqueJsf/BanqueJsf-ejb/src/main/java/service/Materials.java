package service;

import java.net.URL;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Materiels;




/**
 * Session Bean implementation class Materials
 */
@Stateless
@LocalBean
public class Materials implements MaterialsLocal {

	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public Materials() {
        // TODO Auto-generated constructor stub
    }

    
    @Override
	public Boolean addMaterial(Materiels materiels) {
		try {

			entityManager.persist(materiels);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateMaterial(Materiels materiels) {
		try {

			entityManager.merge(materiels);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteMaterial(Materiels materiels) {
		try {

			entityManager.remove(entityManager.merge(materiels));
			return true;

		} catch (Exception e) {
			return false;
		}		
	}

	@Override
	public Materiels findMaterialById(int idM) {
		Materiels materiels = null;
		
		try {

			materiels=entityManager.find(Materiels.class, idM);
			

		} catch (Exception e) {
			
		}
		return materiels;
	}

	@Override
	public List<Materiels> findAllMaterials() {

		return (List<Materiels>) entityManager.createNamedQuery("findAllMaterials").getResultList();

	}
	   
 public String cleanUrl(URL url){
	        
	        String s = url.toString();
	        System.out.println("Before Clean");
	        System.out.println(s);
	        String delims = "/";
	        String[] tokens = s.split(delims);
	        System.out.println("After Clean");
	        String mailPart="";
	        for (int i=1;i<tokens.length;i++){
	            mailPart+=tokens[i]+"\\\\";
	        }
	        System.out.println(mailPart);
	        return mailPart;
	    }  
 
}
