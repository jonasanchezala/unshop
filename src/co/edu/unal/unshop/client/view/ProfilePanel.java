package co.edu.unal.unshop.client.view;


import co.edu.unal.unshop.client.service.UserService;
import co.edu.unal.unshop.client.service.UserServiceAsync;
import co.edu.unal.unshop.shared.UserShop;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;

public class ProfilePanel extends Composite{
	
	private final HorizontalPanel panel = new HorizontalPanel();
	private final VerticalPanel verticalPanel = new VerticalPanel();
	private final VerticalPanel verticalPanel2 = new VerticalPanel();
	private final VerticalPanel verticalPanel3 = new VerticalPanel();
	private final FlexTable flexTable = new FlexTable();
	private final FlexTable flexTable2 = new FlexTable();
	private final FlexTable flexTable3 = new FlexTable();
	
	//Register
	private final Label headerInfoLabel = new Label("Register: ");
	private final Label userLabel = new Label("User: ");
	private final Label passLabel = new Label("Pass: ");
	private final Label nameLabel = new Label("Name: ");
	private final Label emailLabel = new Label("Email:");
	
	private final TextBox userTextBox = new TextBox();
	private final TextBox emailTextBox = new TextBox();
	private final TextBox nameTextBox = new TextBox();
	private final PasswordTextBox passTextBox = new PasswordTextBox();
	
	//Login
	private final Label headerInfoLabelLog = new Label("Login: ");
	private final Label userLabelLog = new Label("User: ");
	private final Label passLabelLog = new Label("Pass: ");
	
	//Info
	private final Label headerInfoUserLabel = new Label("Information: ");
	
	
	private final TextBox userTextBoxLog = new TextBox();
	private final PasswordTextBox  passTextBoxLog = new PasswordTextBox();
	private final Label sucessLabel = new Label("Sucess!");
	private Button buttonLogin = new Button("Login");
	private Button buttonRegister = new Button("Register");
	private final Label orLabel = new Label("OR");
	
	private Button buttonLogout = new Button("Logout");
	
	private final UserServiceAsync userService = GWT
			.create(UserService.class);
	
	
	public ProfilePanel() {
		
		flexTable.setWidget(0, 0, headerInfoLabel);
		flexTable.setWidget(1, 0, userLabel);
		flexTable.setWidget(1, 1, userTextBox);
		flexTable.setWidget(2, 0, passLabel);
		flexTable.setWidget(2, 1, passTextBox);
		flexTable.setWidget(3, 0, nameLabel);
		flexTable.setWidget(3, 1, nameTextBox);
		flexTable.setWidget(4, 0, emailLabel);
		flexTable.setWidget(4, 1, emailTextBox);
		flexTable.setWidget(6, 0, buttonRegister);
		
		flexTable2.setWidget(0, 0, headerInfoLabelLog);
		flexTable2.setWidget(1, 0, userLabelLog);
		flexTable2.setWidget(1, 1, userTextBoxLog);
		flexTable2.setWidget(2, 0, passLabelLog);
		flexTable2.setWidget(2, 1, passTextBoxLog);
		flexTable2.setWidget(4, 0, buttonLogin);
		
		verticalPanel.add(flexTable);
		verticalPanel2.add(flexTable2);
		verticalPanel3.add(orLabel);
		
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel3.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		panel.add(verticalPanel);		
		panel.add(verticalPanel3);
		panel.add(verticalPanel2);
		panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		initWidget(panel);
		
		UserShop user = new UserShop("admin", "admin", 
				"admin@admin.com", true, "admin");
		
		userService.save(user, new AsyncCallback<Void>() {			
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
			}			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub			
			}
		});
		buttonRegister.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addUser();				
				infoUser(userTextBox.getText());
			}
		});
		
		buttonLogin.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {				
				infoUser(userTextBoxLog.getText());
			}
		});
		
		buttonLogout.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				panel.remove(flexTable3);
				panel.add(verticalPanel);		
				panel.add(verticalPanel3);
				panel.add(verticalPanel2);
				MainPanel.btnNewProduct.setVisible(false);
				MainPanel.btnProducts.setVisible(false);
				MainPanel.btnUsers.setVisible(false);
			}
		});
	}
	
	public void addUser(){	
		UserShop user = new UserShop(userTextBox.getText(), nameTextBox.getText(), 
				emailTextBox.getText(), false, passTextBox.getText());
		userService.save(user, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				flexTable.setWidget(8, 0, sucessLabel);				
			}			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				sucessLabel.setText("Failure!");
				flexTable.setWidget(8, 0, sucessLabel);
			}
		});
	}
	
	public void infoUser(String userid){
		
		userService.fetchById(userid, new AsyncCallback<UserShop>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("El usuario no existe");
				
			}

			@Override
			public void onSuccess(UserShop result) {
				// TODO Auto-generated method stub
				panel.remove(verticalPanel);		
				panel.remove(verticalPanel3);
				panel.remove(verticalPanel2);
				flexTable3.setWidget(0, 0, headerInfoUserLabel);
				flexTable3.setWidget(1, 0, userLabel);
				flexTable3.setWidget(1, 1, new Label(result.getUserId()));
				flexTable3.setWidget(2, 0, nameLabel);
				flexTable3.setWidget(2, 1, new Label(result.getName()));
				flexTable3.setWidget(3, 0, emailLabel);
				flexTable3.setWidget(3, 1, new Label(result.getEmail()));
				flexTable3.setWidget(5, 1, buttonLogout);
				if (result.getRole()){
					MainPanel.btnNewProduct.setVisible(true);
					MainPanel.btnProducts.setVisible(true);
					MainPanel.btnUsers.setVisible(true);								
				}
				else{}
				panel.add(flexTable3);
				
								
			}
		});
	
	}

}
