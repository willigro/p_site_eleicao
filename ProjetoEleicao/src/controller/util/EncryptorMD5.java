package controller.util;

import java.security.MessageDigest;

public class EncryptorMD5 {

	
	public static final String criptografarSenha(String senha) throws Exception {
		StringBuilder senhaCriptografada = new StringBuilder();
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] vetorBytes = md.digest(senha.getBytes("UTF8"));
		for (byte b : vetorBytes) {
			senhaCriptografada.append(String.format("%02X", 0xFF & b));
		}
		return senhaCriptografada.toString();
	}
	
}
