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

/**
 *
 * @author Lam & Rodrigues
 */
public class LVGameBachelor extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        BorderPane gameContent = new GameContentApp();
        root.getChildren().add(gameContent);
        
        Scene scene = new Scene(root, 800, 300);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
        primaryStage.setTitle("Hello World!");
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
