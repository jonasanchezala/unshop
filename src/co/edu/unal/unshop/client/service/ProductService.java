package co.edu.unal.unshop.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import co.edu.unal.unshop.shared.Product;

@RemoteServiceRelativePath("Product")
public interface ProductService extends RemoteService{
	
	void save( Product product );

	Product fetchById( String id );

	List<Product> fetchAllAgents();

	boolean isEmpty();
	

}
