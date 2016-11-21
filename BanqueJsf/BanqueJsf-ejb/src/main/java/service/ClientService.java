package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Client;


/**
 * Session Bean implementation class ClientService
 */
@Stateless
public class ClientService implements ClientServiceRemote, ClientServiceLocal
{
	
@PersistenceContext
	EntityManager em;

    public ClientService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addClient(Client client) {
		try {
			em.persist(client);
			return true ;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateClient(Client client) {
		try {
			em.merge(client);
			return true ;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteClient(Client client) {
		try {
			em.remove(em.merge(client) );
			return true ;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Client findClientlById(Integer id) {
		return em.find(Client.class, id);
	}

	@Override
	public List<Client> findAllClient() {
		Query query=em.createQuery("select d from Client d");
		return query.getResultList();
	}

}
