package com.app.lista_jogos.util;

import java.security.MessageDigest;

public class HashConvert {
	
	public String gerarHash(String valor){
		// Criando uma instância de MessageDigest com SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Calculando o hash
        byte[] encodedHash = digest.digest(valor.getBytes());

        // Convertendo o hash para uma string hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
	}
}
