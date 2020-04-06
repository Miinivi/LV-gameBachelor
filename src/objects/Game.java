package objects;

import java.util.Random;

public class Game {
	// Player
	private Player[] player;
	// Position
	private Integer victoryPosition = 30;
	private Random random = new Random();
	private Integer currentPosition = 0;

	private boolean tour(int nbTour){
		int dice;
		
		// On fait jouer tous les joueurs.
		for(Player p : player){

			if (currentPosition == victoryPosition) {
				p.setWin(1);
			}
			
			if(p.getWin() != 0)
				continue;

			// Tant que le joueur n'a toujours pas gagné.
			do {

				// On lance le dé
				dice = random.nextInt(6) + 1;
				currentPosition = currentPosition + dice;

				System.out.print("Vous avancer de "+ dice);
				

			}while(p.getWin() == 0);
			
		}
		return true;
	}
}
