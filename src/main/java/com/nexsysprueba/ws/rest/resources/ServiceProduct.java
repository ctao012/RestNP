package com.nexsysprueba.ws.rest.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.nexsysprueba.ws.rest.DAO.ProductDAO;
import com.nexsysprueba.ws.rest.client.PlatziApi;
import com.nexsysprueba.ws.rest.util.AuthUtils;
import com.nexsysprueba.ws.rest.vo.CategoryPlatziVO;
import com.nexsysprueba.ws.rest.vo.CategoryVO;
import com.nexsysprueba.ws.rest.vo.CredentialVO;
import com.nexsysprueba.ws.rest.vo.Product;
import com.nexsysprueba.ws.rest.vo.ProductPlatziVO;
import com.nexsysprueba.ws.rest.vo.ProductVO;

@Path("/nexsys/v1/products")
public class ServiceProduct {
	
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<ProductVO> getProducts() {
	    	PlatziApi platziApi = new PlatziApi();
	        List<ProductPlatziVO> productsPlatzi = platziApi.getProducts();
	        
	        return productsPlatzi.stream()
	                .map(p -> new ProductVO(p.getId(), p.getTitle(), p.getPrice(), p.getDescription()))
	                .collect(Collectors.toList());
	    }
	    
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response  createProduct(Product request) {
	    	PlatziApi platziApi = new PlatziApi();
	    	Response response = platziApi.createProduct(request);
	    	
          if (response.getStatus() == 201) {
			ProductPlatziVO productPlatziVO = response.readEntity(ProductPlatziVO.class);
			//Se guarda el producto en la DB
			ProductDAO productDAO = new ProductDAO();
			int localProductId = productDAO .saveProduct(
					productPlatziVO.getTitle(),
					productPlatziVO.getPrice(),
					productPlatziVO.getCategory().getId(),
					productPlatziVO.getImages().toString()
					);
			
			return Response.status(Status.CREATED)
			          .entity("{ \"pid\": " + productPlatziVO.getId() + " }")
			          	.build();
	      } else {
	      	return response;
	      }   
	    	
	    }

	    
}
