package com.nexsysprueba.ws.rest.filters;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
 @Provider
public class SecurityFilter {

	    private static final String AUTHENTICATION_SCHEME = "Basic";
	    private static final String AUTHENTICATION_HEADER = "Authorization";
	    private static final String USERNAME = "admin";
	    private static final String PASSWORD = "password";
	    
	    public void filter(ContainerRequestContext requestContext) throws IOException {
	        String authorizationHeader = requestContext.getHeaderString(AUTHENTICATION_HEADER);

	        if (authorizationHeader == null || !authorizationHeader.startsWith(AUTHENTICATION_SCHEME + " ")) {
	            abortWithUnauthorized(requestContext);
	            return;
	        }

	        String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();
	        String decodedString = new String(Base64.getDecoder().decode(token));
	        StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
	        String username = tokenizer.nextToken();
	        String password = tokenizer.nextToken();

	        if (!USERNAME.equals(username) || !PASSWORD.equals(password)) {
	            abortWithUnauthorized(requestContext);
	        }
	    }

	    private void abortWithUnauthorized(ContainerRequestContext requestContext) {
	        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
	                .entity("User cannot access the resource.")
	                .build());
	    }
}
