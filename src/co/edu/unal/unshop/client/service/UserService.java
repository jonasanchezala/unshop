package co.edu.unal.unshop.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import co.edu.unal.unshop.shared.UserShop;

@RemoteServiceRelativePath("User")
public interface UserService extends RemoteService{
	
	void save( UserShop user );

	UserShop fetchById( String id );

	List<UserShop> fetchAllAgents();

	boolean isEmpty();

}
