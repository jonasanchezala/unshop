package co.edu.unal.unshop.client;


import co.edu.unal.unshop.client.view.MainPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Unshop implements EntryPoint {
	private MainPanel mainPanel = new MainPanel();
	private VerticalPanel  mainPanel2 = new VerticalPanel();
	

	
	

	public void onModuleLoad() {
		//initWidget

		mainPanel2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		mainPanel2.add(mainPanel);
        RootPanel rootPanel = RootPanel.get();
        mainPanel2.setSize("100%", "100%");
        rootPanel.setSize("100%", "100%");
        rootPanel.add(mainPanel2,0,0);
        

	}
	
}
