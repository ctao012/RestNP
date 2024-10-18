package com.nexsysprueba.ws.rest.util;

import java.util.Base64;

public class AuthUtils {
	public static String encodeCredentials(String username, String password) {
        String credentials = username + ":" + password;
        return Base64.getEncoder().encodeToString(credentials.getBytes());
    }
}
