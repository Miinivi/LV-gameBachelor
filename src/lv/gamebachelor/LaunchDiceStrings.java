package lv.gamebachelor;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Label;

public class LaunchDiceStrings {
	protected Label DICE_EXPRESSION_1 = new Label("Puisse le sort vous être favorables !");
	protected Label DICE_EXPRESSION_2 = new Label("Advienne que pourra !");
	protected Label DICE_EXPRESSION_3 = new Label("Nul n'est plus chanceux que celui qui croit en sa chance");
	protected Label DICE_EXPRESSION_4 = new Label("Au petit bonheur la chance !");
	protected Label DICE_EXPRESSION_5 = new Label("Croise les doigts !");
	protected Label DICE_EXPRESSION_6 = new Label("Touche du bois !");
	protected Label DICE_EXPRESSION_7 = new Label("En avant moussaillon");
	protected Label DICE_EXPRESSION_8 = new Label("Alea jacta est");
	protected Label DICE_EXPRESSION_9 = new Label("Les carottes sont cuites !");
	protected Label DICE_EXPRESSION_10 = new Label("Le sort est jeté !");
	protected Label DICE_EXPRESSION_11 = new Label("Le dé est lancé ! ");
	protected Label DICE_EXPRESSION_12 = new Label("C'est parti !");
	protected Label DICE_EXPRESSION_13 = new Label("Est-ce que la chance va te sourire aujourd'hui ?!");
	protected Label DICE_EXPRESSION_14 = new Label("La victoire est à porter de main!");
	protected Label DICE_EXPRESSION_15 = new Label("Wait and see..");
	protected Label DICE_EXPRESSION_16 = new Label("En-avant, marche !");
	
	protected static Map<Integer, Label> diceExpMap = new HashMap<>();
	
	public LaunchDiceStrings() {
		// Fill in the map
		diceExpMap.put(1, DICE_EXPRESSION_1);
		diceExpMap.put(2, DICE_EXPRESSION_2);
		diceExpMap.put(3, DICE_EXPRESSION_3);
		diceExpMap.put(4, DICE_EXPRESSION_4);
		diceExpMap.put(5, DICE_EXPRESSION_5);
		diceExpMap.put(6, DICE_EXPRESSION_6);
		diceExpMap.put(7, DICE_EXPRESSION_7);
		diceExpMap.put(8, DICE_EXPRESSION_8);
		diceExpMap.put(9, DICE_EXPRESSION_9);
		diceExpMap.put(10, DICE_EXPRESSION_10);
		diceExpMap.put(11, DICE_EXPRESSION_11);
		diceExpMap.put(12, DICE_EXPRESSION_12);
		diceExpMap.put(13, DICE_EXPRESSION_13);
		diceExpMap.put(14, DICE_EXPRESSION_14);
		diceExpMap.put(15, DICE_EXPRESSION_15);
		diceExpMap.put(16, DICE_EXPRESSION_16);		
	}
	
}
