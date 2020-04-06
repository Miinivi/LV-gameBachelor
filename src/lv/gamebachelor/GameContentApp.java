package lv.gamebachelor;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameContentApp extends BorderPane {
	// Values
	Map<Integer, VBox> vboxMapList = new HashMap();
	// VBox
	HBox hbox1 = new HBox();
	HBox hbox2 = new HBox();
	HBox hbox3 = new HBox();
	
	public GameContentApp() {
		VBox content = new VBox();
		
		// Game board
		for(int i = 1; i <= 30; i++)
		{
			vboxMapList.put(i, createVBoxTile(i));
			if (i < 11) {
				hbox1.getChildren().add(vboxMapList.get(i));				
			}
			if (i < 21 && i > 10) {
				hbox2.getChildren().add(vboxMapList.get(i));				
			}
			if (i < 31 && i > 20) {
				hbox3.getChildren().add(vboxMapList.get(i));				
			}
			System.out.println(i);
		}
		
		content.getChildren().addAll(hbox1, hbox2, hbox3);
		setCenter(content);
		
	}
	
	public VBox createVBoxTile(Integer i) {
		VBox vb = new VBox(new Label(i.toString()));
		vb.setPrefHeight(50d);
		vb.setPrefWidth(50d);
		return vb;
	}
}
