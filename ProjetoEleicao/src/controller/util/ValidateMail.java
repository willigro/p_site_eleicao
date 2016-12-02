package controller.util;

import java.io.Serializable;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public final class ValidateMail implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
		public static boolean isValidEmailAddress(String email) throws Exception{
			boolean result = true;
			try {
				InternetAddress emailAddr = new InternetAddress(email);
				emailAddr.validate();
			} catch (AddressException ex) {
				result = false;
			}
			return result;
		}

}
