package co.edu.unal.unshop.client.view;

import co.edu.unal.unshop.client.service.ProductService;
import co.edu.unal.unshop.client.service.ProductServiceAsync;
import co.edu.unal.unshop.shared.Product;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SearchPanel extends Composite {
	
	private final FlexTable flexTable = new FlexTable();
	private final Label nameLabel = new Label("Name: ");
	private final Label detailsLabel = new Label("Details: ");
	private final Label priceLabel = new Label("Price:");
	private final Label categoryLabel = new Label("Category: ");
	
	
	private Button addCartButton = new Button("Add Shopping Cart");
	private VerticalPanel panel = new VerticalPanel();
	
	private final ProductServiceAsync prodService = GWT
			.create(ProductService.class);
	
	public SearchPanel(String search){
		masterReset();
		prodService.fetchById(search, new AsyncCallback<Product>() {
			
			@Override
			public void onSuccess(Product result) {
				// TODO Auto-generated method stub
				flexTable.setWidget(1, 1, nameLabel);
				flexTable.setWidget(1, 2, new Label(result.getName()));
				flexTable.setWidget(1, 3, priceLabel);
				flexTable.setWidget(1, 4,  new Label("$ " + result.getPrecio()));
				flexTable.setWidget(2, 1, categoryLabel);
				flexTable.setWidget(2, 2,  new Label(result.getCategory()));
				flexTable.setWidget(2, 3, detailsLabel);
				flexTable.setWidget(2, 4,  new Label(result.getDetails()));
				flexTable.setWidget(4, 1, addCartButton);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("El producto no existe");
				
			}
		});
		
		panel.add(flexTable);
		panel.setBorderWidth(1);
		panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		initWidget(panel);
		
		
	}
	
	public void masterReset(){
		for(int index = 1; index < flexTable.getRowCount(); index++)
			flexTable.removeRow(index);
	}
	


}
