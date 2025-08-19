package com.gaminghub.app.presentation.model;

import java.sql.Timestamp;

import com.gaminghub.app.data.entity.GameEntity;

public class GameModel {
	
	int game_id;
	String title;
	String genre;
	String platform;
	float price;
	String description;
	float rating;
	String img;
	Timestamp created_at;
	
	
	public GameModel(int game_id, String title, String genre, String platform, float price, String description, float rating, String img,
			Timestamp created_at) {
		super();
		this.game_id = game_id;
		this.title = title;
		this.genre = genre;
		this.platform = platform;
		this.price = price;
		this.description = description;
		this.rating = rating;
		this.img = img;
		this.created_at = created_at;
	}
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public GameEntity toEntity()
	{
		return new GameEntity(
				this.game_id,
				this.title,
				this.genre,
				this.platform,
				this.price,
				this.description,
				this.rating,
				this.img,
				this.created_at
				);				
	}
	@Override
	public String toString() {
		return "GameModel [game_id=" + game_id + ", title=" + title + ", genre=" + genre + ", platform=" + platform
				+ ", price=" + price + ", description=" + description + ", created_at=" + created_at + "]";
	}
	
	
}
