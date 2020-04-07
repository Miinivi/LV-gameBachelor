package lv.gamebachelor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	// Trap
	private Label trapMessage = new Label("Oh zut ! Quelle malchance, tu es tombé dans un piège. Tu recules d'une case.");
	private HBox trapHBox = new HBox(trapMessage);
	// Values
	private Label oneWinning = new Label("Le joueur Un gagne !");
	private Label twoWinning = new Label("Le joueur Deux gagne !");
	private Integer previousVBox = 1;
	private Map<Integer, VBox> vboxMapList = new HashMap();
	public static List<Player> playerList = game.getPlayerList();
	private Label headerLabel = new Label("Bienvenue au jeu 'Sois le plus rapide !' Un jeu de chance qui saura émoustiller même pépé et mémé ! Mais prends garde. Des pièges sont cachés. \n");

	public GameContentApp() {
		setTop(headerLabel);
		
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

		// Launch dice button
		launchPlOneBtn.setOnAction(actionButton(0, launchPlOneBtn, launchPlTwoBtn));
		launchPlTwoBtn.setOnAction(actionButton(1, launchPlTwoBtn, launchPlOneBtn));

		trapHBox.visibleProperty().set(false);
		trapHBox.managedProperty().bind(trapHBox.visibleProperty());
		trapHBox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
		
		VBox content = new VBox(hbox1, hbox2, hbox3, diceBox, trapHBox, winBox, btnHBox);
		setCenter(content);
	}

	private EventHandler<ActionEvent> actionButton(Integer idPlayer, Button btnToDisappear, Button btnToAppear) {
		return e -> {
			previousVBox = playerList.get(idPlayer).getPosition();

			// Game playing
			game.playerTurn(playerList.get(idPlayer));

			// Set position on HMI
			if (playerList.get(idPlayer).getPosition() < 30) {
				changingPlPositionInVBox(previousVBox);
			} else {
				winBox.getChildren().add(oneWinning);
				playerList.get(idPlayer).setPosition(30);
				changingPlPositionInVBox(previousVBox);
				launchPlOneBtn.setDisable(true);
				launchPlTwoBtn.setDisable(true);
			}
			
			// If the player is on a trap tile
			if (playerList.get(idPlayer).getPosition() == game.getTrap1Pos() //
				|| playerList.get(idPlayer).getPosition() == game.getTrap2Pos() //
				|| playerList.get(idPlayer).getPosition() == game.getTrap3Pos()) {
				previousVBox = playerList.get(idPlayer).getPosition();
				playerList.get(idPlayer).setPosition(playerList.get(idPlayer).getPosition()-1);
				changingPlPositionInVBox(previousVBox);
				trapHBox.visibleProperty().set(true);
				trapHBox.managedProperty().bind(trapHBox.visibleProperty());
			} else {
				trapHBox.visibleProperty().set(false);
				trapHBox.managedProperty().bind(trapHBox.visibleProperty());
			}

			// Graphic part
			btnToDisappear.visibleProperty().set(false);
			btnToDisappear.managedProperty().bind(btnToDisappear.visibleProperty());
			// Display button 2
			btnToAppear.visibleProperty().set(true);
			btnToAppear.managedProperty().bind(btnToAppear.visibleProperty());
		};
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
