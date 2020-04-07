package lv.gamebachelor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import objects.Game;
import objects.Player;

public class GameContentApp extends BorderPane {
	// HBox
	private HBox hbox1 = new HBox();
	private HBox hbox2 = new HBox();
	private HBox hbox3 = new HBox();
	private HBox winBox = new HBox();
	// Dice
	public static HBox dice = new HBox();
	private HBox diceBox = new HBox(new Label("Le dé est lancé ! "), dice);
	// Button
	public static Button launchPlOneBtn = new Button("Lancer en tant que joueur 1");
	public static Button launchPlTwoBtn = new Button("Lancer en tant que joueur 2");
	private HBox btnHBox = new HBox(launchPlOneBtn, launchPlTwoBtn);
	// Game
	private static Game game = new Game();
	// Values
	private Label oneWinning = new Label("Le joueur Un gagne !");
	private Label twoWinning = new Label("Le joueur Deux gagne !");
	private Integer previousVBox = 1;
	private Map<Integer, VBox> vboxMapList = new HashMap();
	public static List<Player> playerList = game.getPlayerList();

	public GameContentApp() {
		// Creating dice appearance
		dice.getChildren().add(new Label("1"));
		// Because css doesn't work, we had to set style that way
		dice.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1d))));
		dice.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		dice.setMaxSize(10d, 17d);
		dice.setMinSize(10d, 17d);
		dice.getStyleClass().add("dice");
		diceBox.visibleProperty().set(false);
		diceBox.managedProperty().bind(diceBox.visibleProperty());

		launchPlOneBtn.setOnMouseClicked(e -> {
			diceBox.visibleProperty().set(true);
			diceBox.managedProperty().bind(diceBox.visibleProperty());
		});

		// Game board
		for (int i = 1; i <= 30; i++) {
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
		}

		launchPlTwoBtn.visibleProperty().set(false);
		launchPlTwoBtn.managedProperty().bind(launchPlTwoBtn.visibleProperty());

//		// Set the players position at first tile
//		changingPlPositionInVBox(previousVBox);

		// Launch dice button
		launchPlOneBtn.setOnAction(e -> {
			previousVBox = playerList.get(0).getPosition();

			// Game playing
			game.playerTurn(playerList.get(0));

			// Set position on HMI
			if (playerList.get(0).getPosition() < 30) {
				changingPlPositionInVBox(previousVBox);
			} else {
				winBox.getChildren().add(oneWinning);
				playerList.get(0).setPosition(30);
				changingPlPositionInVBox(previousVBox);
				launchPlOneBtn.setDisable(true);
				launchPlTwoBtn.setDisable(true);
			}

			// Graphic part
			launchPlOneBtn.visibleProperty().set(false);
			launchPlOneBtn.managedProperty().bind(launchPlOneBtn.visibleProperty());
			// Display button 2
			launchPlTwoBtn.visibleProperty().set(true);
			launchPlTwoBtn.managedProperty().bind(launchPlTwoBtn.visibleProperty());
		});
		launchPlTwoBtn.setOnAction(e -> {
			previousVBox = playerList.get(1).getPosition();

			// Game playing
			game.playerTurn(playerList.get(1));

			// Set position on HMI
			if (playerList.get(1).getPosition() < 30) {
				changingPlPositionInVBox(previousVBox);
			} else {
				winBox.getChildren().add(twoWinning);
				playerList.get(1).setPosition(30);
				changingPlPositionInVBox(previousVBox);
				launchPlOneBtn.setDisable(true);
				launchPlTwoBtn.setDisable(true);
			}

			// Graphic part
			launchPlTwoBtn.visibleProperty().set(false);
			launchPlTwoBtn.managedProperty().bind(launchPlTwoBtn.visibleProperty());
			// Display button 1
			launchPlOneBtn.visibleProperty().set(true);
			launchPlOneBtn.managedProperty().bind(launchPlOneBtn.visibleProperty());
		});

		VBox content = new VBox(hbox1, hbox2, hbox3, diceBox, winBox, btnHBox);
		setCenter(content);
	}

	public void changingPlPositionInVBox(Integer previousVBox) {
		Integer position = 0;
		// Check if no one on the previous box
		if (playerList.get(0).getPosition() != previousVBox && playerList.get(1).getPosition() != previousVBox) {
			vboxMapList.get(previousVBox).getChildren().clear();
			vboxMapList.get(previousVBox).getChildren().add(new Label(previousVBox.toString()));
		}
		if (playerList.get(0).getPosition() != playerList.get(1).getPosition()) {
			// Setting the player one position
			position = playerList.get(0).getPosition();
			vboxMapList.get(position).getChildren().clear();
			vboxMapList.get(position).getChildren().addAll(new Label(position.toString()),
					new Label(playerList.get(0).getName()));
			// Setting the player two position
			position = playerList.get(1).getPosition();
			vboxMapList.get(position).getChildren().clear();
			vboxMapList.get(position).getChildren().addAll(new Label(position.toString()),
					new Label(playerList.get(1).getName()));
		} else {
			// Both on the same position
			position = playerList.get(0).getPosition();
			vboxMapList.get(position).getChildren().clear();
			vboxMapList.get(position).getChildren().addAll(new Label(position.toString()),
					new Label(playerList.get(0).getName()), new Label(playerList.get(1).getName()));
		}
	}

	private VBox createVBoxTile(Integer i) {
		VBox vb = new VBox(new Label(i.toString()));
		vb.setMinSize(80d, 60d);
		vb.setMaxSize(80d, 60d);
		return vb;
	}
}
