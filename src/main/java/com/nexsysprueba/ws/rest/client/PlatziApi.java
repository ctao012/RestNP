package com.nexsysprueba.ws.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nexsysprueba.ws.rest.vo.CategoryPlatziVO;
import com.nexsysprueba.ws.rest.vo.Product;
import com.nexsysprueba.ws.rest.vo.ProductPlatziVO;
import com.nexsysprueba.ws.rest.vo.ResponseVO;

public class PlatziApi {
    private static final String BASE_URI = "https://api.escuelajs.co/api/v1/";
   	
    public List<ProductPlatziVO> getProducts() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URI).path("products");
        List<ProductPlatziVO> products = target.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ProductPlatziVO>>(){});
        return products;
    }
    
    public List<CategoryPlatziVO> getCategories() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URI).path("categories");
        List<CategoryPlatziVO> categories = target.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<CategoryPlatziVO>>(){});
        return categories;
    }
    
    public Response createProduct(Product request) {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(BASE_URI).path("products");
            Response response = null;
            try {
	            String jsonRequest = "{"
	                    + "\"title\":\"" + request.getName() + "\","
	                    + "\"price\":" + request.getPriceFinal() + ","
	                    + "\"description\":\"" + request.getDescription() + "\","
	                    + "\"categoryId\":" + request.getCategoryId() + ","
	                    + "\"images\":[\"" + request.getImageUrl() + "\"]"
	                    + "}";
	            System.out.println(jsonRequest);
	            response = target.request(MediaType.APPLICATION_JSON)
	                    .post(Entity.json(jsonRequest));
            }catch (Exception e) {
				e.printStackTrace();
			}
            
            return response;
    }
}
