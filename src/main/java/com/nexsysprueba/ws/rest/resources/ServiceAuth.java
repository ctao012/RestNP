package com.nexsysprueba.ws.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nexsysprueba.ws.rest.util.AuthUtils;
import com.nexsysprueba.ws.rest.vo.CredentialVO;

@Path("/nexsys/v1/auth")
public class ServiceAuth {
		    
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public String encodeCredentials(CredentialVO credentials) {
            String token = AuthUtils.encodeCredentials(credentials.getUsername(), credentials.getPassword());
            return String.format("{\"token\": \"%s\"}", token);
        }

	    
}
