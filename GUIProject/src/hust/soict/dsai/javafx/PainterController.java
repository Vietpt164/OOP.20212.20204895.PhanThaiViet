package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	
	private Color toolColor;

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private RadioButton penButton, eraserButton;


    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, toolColor);
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void pickTools(ActionEvent event) {
    	if (penButton.isSelected()) {
    		toolColor = Color.BLACK;
    	} else if (eraserButton.isSelected()) {
    		toolColor = Color.WHITE;
    	}
    }
}
