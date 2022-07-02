package hust.soict.dsai.aims.screen.customer.controller;

import hust.soict.dsai.aims.Playable;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ItemController {
	
	private Store store;
	private Cart cart;
	public ItemController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
    	Stage playMedia = new Stage();
    	playMedia.setTitle("Playing " + media.getClass().getSimpleName());
    	Label title = new Label("Title: " + media.getTitle());
    	Label length = new Label("Length: " + ((Disc)media).getLength());
    	VBox pane = new VBox(10);
    	pane.setPrefHeight(100);
    	pane.setPrefWidth(300);
    	pane.getChildren().add(title);
    	pane.getChildren().add(length);
    	Scene scene = new Scene(pane);
    	playMedia.setScene(scene);
    	playMedia.show();
    }
    
    private Media media;
    public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost() + " $");
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	} else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
    	}
    }
    

}

