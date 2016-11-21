package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EnvoiSmsService {

	public String sendSms(String s,String num) {
		try {
			// Construct data
			String user = "username=" + "freedo1@live.fr";
			String hash = "&hash=" + "e6963e2aaa210fc1efe20f6fdda20a65425ac7e7";
			String message = "&message=" +s;
			String sender = "&sender=" + "Semer Naski";
			String numbers = "&numbers=" +num;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("http://api.txtlocal.com/send/?").openConnection();
			String data = user + hash + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
