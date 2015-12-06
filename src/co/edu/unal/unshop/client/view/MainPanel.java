package co.edu.unal.unshop.client.view;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class MainPanel extends Composite{
	private final FlowPanel flowPanel = new FlowPanel();
	private  TextBox textSearch = new TextBox();
	private final Button btnSearch = new Button("Search");
	private final Button btnProfile = new Button("Profile");
	public static Button btnNewProduct = new Button("New Product");
	public static Button btnUsers = new Button("Users");
	public static Button btnProducts = new Button("Products");
	private final VerticalPanel verticalPanel = new VerticalPanel();
	private final Label lblFavorites = new Label("Favorites");
	private AddProductPanel addProduct =  new AddProductPanel();
	private ProfilePanel profilePanel = new ProfilePanel();
	private ProductListPanel productListPanel = new ProductListPanel();
	private UserListPanel userListPanel = new UserListPanel();
	private SearchPanel searchPanel;
	private SearchPanel searchPanel1;
	
	public MainPanel() {
		
		flowPanel.setSize("900px", "371px");		
		flowPanel.add(textSearch);
		flowPanel.add(btnSearch);
		flowPanel.add(btnProfile);		
		flowPanel.add(btnNewProduct);
		flowPanel.add(btnUsers);		
		flowPanel.add(btnProducts);
		btnNewProduct.setVisible(false);
		btnUsers.setVisible(false);
		btnProducts.setVisible(false);
		flowPanel.add(verticalPanel);	
		lblFavorites.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblFavorites.setStyleName("sendButton");
		
		initWidget(flowPanel);
		btnNewProduct.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addProductPanel();
			}
		});
		
		btnProfile.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				profilePanel();
			}
		});
		
		btnProducts.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				productListPanel();
			}
		});
		
		btnUsers.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				userListPanel();
			}
		});
		

		btnSearch.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				searchPanel();
			}
		});
		
	}
	
	public void addProductPanel(){
		verticalPanel.add(addProduct);
		verticalPanel.remove(profilePanel); 
		verticalPanel.remove(productListPanel);
		verticalPanel.remove(userListPanel);
		verticalPanel.remove(searchPanel);
		
	}
	
	public void profilePanel(){
		verticalPanel.add(profilePanel);
		verticalPanel.remove(addProduct);
		verticalPanel.remove(productListPanel);
		verticalPanel.remove(userListPanel);
		verticalPanel.remove(searchPanel);
		
	}
	
	public void productListPanel(){
		verticalPanel.add(productListPanel);	
		verticalPanel.remove(addProduct);
		verticalPanel.remove(profilePanel);
		verticalPanel.remove(userListPanel);
		verticalPanel.remove(searchPanel);
			
	}
	
	public void userListPanel(){
		verticalPanel.add(userListPanel);
		verticalPanel.remove(addProduct);
		verticalPanel.remove(profilePanel); 
		verticalPanel.remove(productListPanel);
		verticalPanel.remove(searchPanel);
		
	}	
	
	public void searchPanel(){
		
		searchPanel1 = searchPanel;
		searchPanel = new SearchPanel(textSearch.getValue());
		verticalPanel.add(searchPanel);	
		verticalPanel.remove(addProduct);
		verticalPanel.remove(profilePanel); 
		verticalPanel.remove(productListPanel);
		verticalPanel.remove(userListPanel);
		verticalPanel.remove(searchPanel1);
			
	}
	

}



