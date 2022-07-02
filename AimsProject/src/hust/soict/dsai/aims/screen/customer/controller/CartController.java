package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.dsai.aims.Playable;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CartController {
	
	private Store store;
	private Cart cart;
	
	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
	
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
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

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	costLabel.setText(cart.totalCost()+ "");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String ITEM_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ITEM_FXML_FILE_PATH));
			fxmlLoader.setController(new ViewStoreController(store, cart));  
			Parent root = fxmlLoader.load(); 
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setTitle("Store");
			stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public void initialize() {
    	colMediaId.setCellValueFactory(
    			new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	if (cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    	
    	costLabel.setText(cart.totalCost() + "");
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);

    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);			
			}

			private void updateButtonBar(Media media) {
				if (media == null) {
					btnPlay.setVisible(false);
			    	btnRemove.setVisible(false);
				} else {
					btnRemove.setVisible(true);
					if (media instanceof Playable) {
						btnPlay.setVisible(true);
					} else {
						btnPlay.setVisible(false);
					}
				}
			}
    		
    	});
    	
    }

}
