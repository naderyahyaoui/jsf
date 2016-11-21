package domain;

import java.io.Serializable;
import java.net.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Materiels
 *
 */
@Entity
@XmlRootElement
@NamedQuery(name="findAllMaterials",query="select a from Materiels a")
public class Materiels implements Serializable {
	@ManyToOne
	private Administrateur admin;
	
	private static final long serialVersionUID = 1L;

	public Materiels() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int idM;
	@NotNull
	private float price;
	@NotNull
	private int qte;
	private String description;
	private String path;
	private String type;
	private int id_F;

	public Materiels(int idM, float price, int qte, String description,
			String path, String type, int id_F) {
		super();
		this.idM = idM;
		this.price = price;
		this.qte = qte;
		this.description = description;
		this.path = path;
		this.type = type;
		this.id_F = id_F;
	}
	public int getIdM() {
		return idM;
	}
	public void setIdM(int idM) {
		this.idM = idM;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId_F() {
		return id_F;
	}
	public void setId_F(int id_F) {
		this.id_F = id_F;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
