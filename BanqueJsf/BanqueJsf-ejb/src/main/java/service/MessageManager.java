package service;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Message;

@Singleton
@Startup

public class MessageManager implements MessageManagerLocal {
	
	
	@PersistenceContext
	private EntityManager em ;
    /**
     * Default constructor. 
     */
	public MessageManager() {
		// TODO Auto-generated constructor stub
	}
 
    private final List<Message> messages = Collections.synchronizedList(new LinkedList());;
 
    
    public void sendMessage(Message msg) {
        messages.add(msg);
        msg.setDateSent(new Date());
    }
 
    
    public Message getFirstAfter(Date after) {
        if(messages.isEmpty())
            return null;
        if(after == null)
            return   messages.get(0);
        for(Message m : messages) {
            if(m.getDateSent().after(after))
                return m;
        }
        return null;
    }
    
public 	Message create(Message Message) {
		
		try {
			em.persist(Message);
			System.out.println("Message insert with success");
		
			
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return  Message;
	}

		
 

}
