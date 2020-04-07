package objects;

import javafx.scene.image.ImageView;

public class Player {
	
	private String name;
	private Integer position;
	private ImageView image;
	 
	public Player(String name, ImageView image) {
		position = 1;
		this.name = name;
		this.image = image;
	}
	
	public Player(String name) {
		position = 1;
		this.name = name;
	}
	
	public Player() {
		position = 1;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer startingPosition) {
		this.position = startingPosition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageView getImage() {
		return image;
	}

	public void setImage(ImageView image) {
		this.image = image;
	}
}