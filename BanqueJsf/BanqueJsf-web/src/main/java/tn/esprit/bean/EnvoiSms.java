package tn.esprit.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import service.EnvoiSmsService;


@ManagedBean
@ViewScoped
public class EnvoiSms {

	
	private String message;
	private String number;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	EnvoiSmsService local=new EnvoiSmsService();
	
	public String sms()
    {
	
        if(getMessage().length()!= 0)
        {
         
        	local.sendSms(getMessage(),getNumber());
        }
        return "";

    }
}
