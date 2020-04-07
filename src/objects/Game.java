package objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lv.gamebachelor.GameContentApp;

public class Game {
	// Players
	private Player playerOne = new Player("one");
	private Player playerTwo = new Player("two");
	// The players list
	List<Player> playerList = new ArrayList<Player>();
	// Dice
	private Integer dice;
	private Random random = new Random();
	// Player turn value
	public static Integer switchPlayerTurn = 1;

	public void Game() {
	}
	
	public List<Player> getPlayerList() {
		playerList.add(playerOne);
		playerList.add(playerTwo);
		return playerList;
	}

	/**
	 * Playing the player turn
	 */
	public void playerTurn(Player player) {
		// Game running
		dice = random.nextInt(6) + 1;
		player.setPosition(player.getPosition() + dice);
		
		// Graphic part
		GameContentApp.dice.getChildren().clear();
		GameContentApp.dice.getChildren().add(new Label(dice.toString()));
	}
	
	/**
	 * Set players images
	 * not used for the moment
	 */
	private void setImagesForPlayers() { 
		try {
			// File input stream
			FileInputStream redFIS = new FileInputStream("redPlayer.png");
			FileInputStream blueFIS = new FileInputStream("bluePlayer.png");
			// Player images
			Image redPlayer = new Image(redFIS);
			Image bluePlayer = new Image(blueFIS);
			// Setting
			playerOne.setImage(new ImageView(redPlayer));
			playerTwo.setImage(new ImageView(bluePlayer));
			
		} catch (FileNotFoundException fe) {
		    fe.printStackTrace();
		}
	}
}
