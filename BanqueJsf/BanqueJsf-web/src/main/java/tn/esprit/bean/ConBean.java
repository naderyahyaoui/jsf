package tn.esprit.bean;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConBean {
private String from;
private String to;
private int montant;
private double result;
private ArrayList<String> dTo=new ArrayList<String>();
private ArrayList<String> dFrom=new ArrayList<String>();

public void doConv(){
		result=findExchangeRateAndConvert(from, to, montant);
	}
	private static Double findExchangeRateAndConvert(String from, String to, int amount) {
        try {
            //Yahoo Finance API
            URL url = new URL("http://finance.yahoo.com/d/quotes.csv?f=l1&s="+ from + to + "=X");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            if (line.length() > 0) {
                return Double.parseDouble(line) * amount;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public ArrayList<String> getdTo() {
		dTo.add("TND");
		dTo.add("EUR");
		dTo.add("USD");
		return dTo;
	}
	public void setdTo(ArrayList<String> dTo) {
		this.dTo = dTo;
	}
	public ArrayList<String> getdFrom() {
		dFrom.add("TND");
		dFrom.add("EUR");
		dFrom.add("USD");
		return dFrom;
	}
	public void setdFrom(ArrayList<String> dFrom) {
		this.dFrom = dFrom;
	}

}
