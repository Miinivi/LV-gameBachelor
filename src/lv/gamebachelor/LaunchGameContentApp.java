package lv.gamebachelor;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LaunchGameContentApp extends BorderPane {
	// First player HBox
	public static TextField tfPlayerOneName = new TextField();
	private HBox firstHBox = new HBox(new Label("Pseudo du joueur 1 ? "), tfPlayerOneName);
	// Second player HBox
	public static TextField tfPlayerTwoName = new TextField();
	private HBox secondHBox = new HBox(new Label("Pseudo du joueur 2 ? "), tfPlayerTwoName);
	// Error HBox
	public static HBox errorHBox = new HBox(new Label("Au moins un des champs de texte est vide"));
	// Button
	public static Button changeContentBtn = new Button("Lancer le jeu");
	// Content
	private VBox content;
	
	public LaunchGameContentApp() {
		errorHBox.visibleProperty().set(false);
		errorHBox.managedProperty().bind(errorHBox.visibleProperty());
		errorHBox.getChildren().get(0).setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
		content = new VBox(10, firstHBox, secondHBox, errorHBox, changeContentBtn);
		setCenter(content);
	}
}
