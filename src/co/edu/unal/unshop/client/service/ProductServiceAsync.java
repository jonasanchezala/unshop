package co.edu.unal.unshop.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import co.edu.unal.unshop.shared.Product;

public interface ProductServiceAsync {
	
	
	void save(Product product,AsyncCallback<Void> callback);
	void fetchById(String id, AsyncCallback<Product> callback);
	void fetchAllAgents(AsyncCallback<List<Product>> callback);
	void isEmpty(AsyncCallback<Boolean> callback);
	


}
