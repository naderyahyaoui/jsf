package tn.esprit.bean;
import java.util.HashMap;
import java.util.Map;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;
import com.stripe.net.RequestOptions.RequestOptionsBuilder;
public class Stripe {
	private static RequestOptions requestOptions;
	private static Map<String, Object> chargeMap = new HashMap<String, Object>();
	private static Map<String, Object> cardMap = new HashMap<String, Object>();

	static {
		requestOptions = (new RequestOptionsBuilder()).setApiKey(
				"sk_test_Nc5JriRire7Fp5Zl2P2PfaB8 ").build();
	}

	public static void makePayement(int amount, String user, String cardNumber,
			int expMonth, int expYear) {
		chargeMap.put("amount", amount * 100);
		chargeMap.put("currency", "usd");

		cardMap.put("name", user);
		cardMap.put("number", cardNumber);
		cardMap.put("exp_month", expMonth);
		cardMap.put("exp_year", expYear);
		chargeMap.put("card", cardMap);

		try {
			Charge charge = Charge.create(chargeMap, requestOptions);
			System.out.println(charge);
		} catch (StripeException e) {
			e.printStackTrace();
		}

	}
}