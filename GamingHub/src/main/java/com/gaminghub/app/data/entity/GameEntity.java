package com.gaminghub.app.data.entity;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.gaminghub.app.presentation.model.GameModel;

@Table("games")
public class GameEntity {
	
	@Id
	@Column("game_id")
	int game_id;
	
	@Column("title")
	String title;
	
	@Column("genre")
	String genre;
	
	@Column("platform")
	String platform;
	
	@Column("price")
	float price;
	
	@Column("description")
	String description;
	
	// FIXME: SET THIS 
	float rating;
	
	String img;
	
	@Column("created_at")
	Timestamp created_at;

	public GameEntity(int game_id, String title, String genre, String platform, float price, String description, float rating, String img,
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
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	public GameModel toModel()
	{
		return new GameModel(
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
}
