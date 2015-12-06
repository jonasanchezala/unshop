package co.edu.unal.unshop.shared;


import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	private String name;

	
	private int price;
	private int lot;
	private String details;
	private String category;

	
	public Product(){	
    }
	public Product(String name, int price, int lot, String details,
			String category) {
		super();
		this.name = name;
		this.price = price;
		this.lot = lot;
		this.details = details;
		this.category = category;
		
	}


	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
		
	}

	
	public int getPrecio() {
		return price;
	}


	public void setPrecio(int price) {
		this.price = price;
		
	}

	
	public int getLot() {
		return lot;
	}

	
	public void setLot(int lot) {
		this.lot = lot;
	}

	
	public String getDetails() {
		return details;
	}

	
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	public String getCategory() {
		return category;
	}

	
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
