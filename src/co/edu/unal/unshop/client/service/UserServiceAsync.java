package co.edu.unal.unshop.client.service;

import java.util.List;


import co.edu.unal.unshop.shared.UserShop;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {
	
	void save(UserShop user,AsyncCallback<Void> callback);
	void fetchById(String id, AsyncCallback<UserShop> callback);
	void fetchAllAgents(AsyncCallback<List<UserShop>> callback);
	void isEmpty(AsyncCallback<Boolean> callback);

}
