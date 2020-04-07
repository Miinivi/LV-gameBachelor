/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.gamebachelor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import objects.Game;

/**
 *
 * @author Lam Calem
 */
public class LVGameBachelor extends Application {

	@Override
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();
		BorderPane gameContent = new GameContentApp();
		BorderPane launchContent = new LaunchGameContentApp();
		root.getChildren().add(launchContent);
		LaunchGameContentApp.changeContentBtn.setOnAction(e -> {
			if (!LaunchGameContentApp.tfPlayerOneName.getText().isEmpty() //
					&& !LaunchGameContentApp.tfPlayerTwoName.getText().isEmpty()) {
				GameContentApp.playerList.get(0).setName(LaunchGameContentApp.tfPlayerOneName.getText().toString());
				GameContentApp.playerList.get(1).setName(LaunchGameContentApp.tfPlayerTwoName.getText().toString());
				// Set the players position at first tile
				((GameContentApp) gameContent).changingPlPositionInVBox(1);
				root.getChildren().clear();
				root.getChildren().add(gameContent);
			} else {
				LaunchGameContentApp.errorHBox.visibleProperty().set(true);
				LaunchGameContentApp.errorHBox.managedProperty().bind(LaunchGameContentApp.errorHBox.visibleProperty());
			}
		});

		Scene scene = new Scene(root, 800, 300);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setTitle("Sois le plus rapide !");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
