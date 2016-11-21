package domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 * Represents message
 * @author Danon
 */
@Entity
@Table(name="t_message")
public class Message implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date dateSent;
    private String user;
    private String message;
 public Message() {
	// TODO Auto-generated constructor stub
}
    public Date getDateSent() {
        return dateSent;
    }
 
    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getUser() {
        return user;
    }
 
    public void setUser(String user) {
        this.user = user;
    }
   @Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}