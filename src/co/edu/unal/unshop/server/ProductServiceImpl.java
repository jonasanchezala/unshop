package co.edu.unal.unshop.server;



import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;


import co.edu.unal.unshop.client.service.ProductService;
import co.edu.unal.unshop.shared.Product;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;

public class ProductServiceImpl extends RemoteServiceServlet implements ProductService{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig sc) {
		try {
			super.init(sc);

			ObjectifyService.register(Product.class);

			ofy = ObjectifyService.factory().begin();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void save(Product product) {
		ofy.save().entity( product ).now();	
	}

	@Override
	public Product fetchById(String id) {		
		Key<Product> key = Key.create( Product.class, id );
		//LoadResult<Product> p = ofy.load().type(Product.class).id(id);
		return ofy.load().key( key ).now();
	}

	@Override
	public List<Product> fetchAllAgents() {
		Query<Product> q = ofy.load().type( Product.class );
		return new LinkedList<Product>( q.list() );
	}

	@Override
	public boolean isEmpty() {
		Query<Product> q = ofy.load().type( Product.class );
		return q.limit( 1 ).list().isEmpty();
	}
	
	private Objectify ofy;

}
