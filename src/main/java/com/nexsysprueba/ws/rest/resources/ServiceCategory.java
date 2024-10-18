package com.nexsysprueba.ws.rest.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nexsysprueba.ws.rest.client.PlatziApi;
import com.nexsysprueba.ws.rest.vo.CategoryPlatziVO;
import com.nexsysprueba.ws.rest.vo.CategoryVO;

@Path("/nexsys/v1/categories")
public class ServiceCategory {
	    
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<CategoryVO> getCategories() {
	    	PlatziApi platziApi = new PlatziApi();
	        List<CategoryPlatziVO> categoriesPlatzi = platziApi.getCategories();
	        
	        return categoriesPlatzi.stream()
	                .map(c -> new CategoryVO(c.getId(),c.getName()))
	                .collect(Collectors.toList());
	    }

	    
}
