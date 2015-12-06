package co.edu.unal.unshop.client.view;

import java.util.List;

import co.edu.unal.unshop.client.service.ProductService;
import co.edu.unal.unshop.client.service.ProductServiceAsync;
import co.edu.unal.unshop.shared.Product;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;

public class ProductListPanel extends Composite{
	private final FlexTable flexTable = new FlexTable();
	private final FlexTable flexTablePrincipal = new FlexTable();

	private final Label nameLabel = new Label("Name");
	private final Label priceLabel = new Label("Price");
	private final Label unitsLabel = new Label("Units");
	private final Label detailLabel = new Label("Category");

	private final ScrollPanel scrollPanel = new ScrollPanel();
	

	private final ProductServiceAsync prodService = GWT
			.create(ProductService.class);

	//private final Button recargarButton = new Button("Refresh");
	
	public ProductListPanel(){
		
		llenarTabla();
		scrollPanel.setSize("600px", "400px");

		flexTable.setWidget(0, 0, nameLabel);
		flexTable.setWidget(0, 1, priceLabel);
		flexTable.setWidget(0, 2, unitsLabel);
		flexTable.setWidget(0, 3, detailLabel);
		
		nameLabel.setSize("90px", "25px");
		priceLabel.setSize("90px", "25px");
		unitsLabel.setSize("90px", "25px");
		detailLabel.setSize("90px", "25px");
		
		

		scrollPanel.add(flexTable);
		flexTablePrincipal.setWidget(0, 0, scrollPanel);
		//flexTablePrincipal.setWidget(1, 1, recargarButton);
		
		/*recargarButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				llenarTabla();
			}
		});*/
		initWidget(flexTablePrincipal);
		
	}
	
	public void masterReset(){
		for(int index = 1; index < flexTable.getRowCount(); index++)
			flexTable.removeRow(index);
	}

	private void llenarTabla() {
		masterReset();
		prodService.fetchAllAgents(new AsyncCallback<List<Product>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(caught.getMessage());
				
			}

			@Override
			public void onSuccess(List<Product> result) {
				// TODO Auto-generated method stub
				for (int index = 0; index < result.size(); index++) {

					flexTable.setWidget(index+1, 0, new Label( result.get(index).getName()));
					flexTable.setWidget(index+1, 1, new Label( "$ " + result.get(index).getPrecio()));
					flexTable.setWidget(index+1, 2, new Label( "" +result.get(index).getLot()));
					flexTable.setWidget(index+1, 3, new Label( result.get(index).getCategory()));
				}	
			}
		});
	}

}
