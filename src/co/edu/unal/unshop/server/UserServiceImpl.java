package co.edu.unal.unshop.server;


import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import co.edu.unal.unshop.client.service.UserService;
import co.edu.unal.unshop.shared.UserShop;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;


public class UserServiceImpl extends RemoteServiceServlet implements UserService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig sc) {
		try {
			super.init(sc);

			ObjectifyService.register(UserShop.class);

			ofy = ObjectifyService.factory().begin();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(UserShop user) {
		ofy.save().entity( user).now();		
	}

	@Override
	public UserShop fetchById(String id) {
		Key<UserShop> key = Key.create( UserShop.class, id );
		return ofy.load().key( key ).now();
		
	}

	@Override
	public List<UserShop> fetchAllAgents() {
		Query<UserShop> q = ofy.load().type( UserShop.class );
		return new LinkedList<UserShop>( q.list() );
	}

	@Override
	public boolean isEmpty() {
		Query<UserShop> q = ofy.load().type( UserShop.class );
		return q.limit( 1 ).list().isEmpty();
	}
	
	private Objectify ofy;

}
