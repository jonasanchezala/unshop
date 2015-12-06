package co.edu.unal.unshop.client.view;



import co.edu.unal.unshop.client.service.ProductService;
import co.edu.unal.unshop.client.service.ProductServiceAsync;
import co.edu.unal.unshop.shared.Product;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddProductPanel extends Composite{
	private final FlexTable flexTable = new FlexTable();
	private final FlexTable flexTablePrincipal = new FlexTable();

	private final Label headerInfoLabel = new Label("Add the product: ");
	private final Label nameLabel = new Label("Name: ");
	private final Label detailsLabel = new Label("Details: ");
	private final Label unitsLabel = new Label("Units: ");
	private final Label priceLabel = new Label("Price:");
	private final Label categoryLabel = new Label("Category: ");
	private final Label sucessLabel = new Label("Sucess!");
	
	private final TextBox nameTextBox = new TextBox();
	private final TextBox detailsTextBox = new TextBox();
	private final IntegerBox unitsTextBox = new IntegerBox();
	private final IntegerBox priceTextBox = new IntegerBox();
	private ListBox listbox = new ListBox();
	private VerticalPanel panel = new VerticalPanel();
	
	
	private Button addButton = new Button("Add");
	
	private final ProductServiceAsync prodService = GWT
			.create(ProductService.class);
	
	
	public AddProductPanel() {
		listbox.addItem("Cell Phone");
		listbox.addItem("Computers");
		listbox.addItem("Home Appliances");
		listbox.addItem("Digital Games");
		
		flexTable.setWidget(0, 0, headerInfoLabel);
		flexTable.setWidget(1, 0, nameLabel);
		flexTable.setWidget(1, 1, nameTextBox);
		flexTable.setWidget(2, 0, detailsLabel);
		flexTable.setWidget(2, 1, detailsTextBox);
		flexTable.setWidget(3, 0, priceLabel);
		flexTable.setWidget(3, 1, priceTextBox);
		flexTable.setWidget(4, 0, unitsLabel);
		flexTable.setWidget(4, 1, unitsTextBox);
		flexTable.setWidget(5, 0, categoryLabel);
		flexTable.setWidget(5, 1, listbox);
		flexTable.setWidget(8, 2, addButton);
		
		flexTablePrincipal.setWidget(0, 0, flexTable);
		flexTablePrincipal.setSize("80%", "80%");
		panel.add(flexTablePrincipal);
		panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		initWidget(panel);
		
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addProduct();
			}
		});
	
	}
	
	public void addProduct(){
		

		Product product = new Product(nameTextBox.getText(),
				priceTextBox.getValue(), unitsTextBox.getValue(),
				detailsTextBox.getText(), listbox.getItemText(listbox.getSelectedIndex()));

		
		prodService.save(product, new AsyncCallback<Void>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				sucessLabel.setText("Failure!");
				flexTable.setWidget(10, 0, sucessLabel);
				
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				flexTable.setWidget(10, 0, sucessLabel);
			}});
		
				
		
	}
	


}
