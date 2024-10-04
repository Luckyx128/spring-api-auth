package com.app.lista_jogos.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashConvert {
	
	public String gerarHash(String valor) throws NoSuchAlgorithmException{
		
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        
        byte[] encodedHash = digest.digest(valor.getBytes());

       
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
	}
}
