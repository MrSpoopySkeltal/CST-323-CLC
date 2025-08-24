package com.gaminghub.app.data.entity;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.gaminghub.app.presentation.model.GameModel;

/**
 * Represents the persistent entity for a game, mapped to the {@code games} table in the database.
 * <p>
 * This entity is used in the data layer for database operations and maps directly to the structure
 * of the `games` table. It includes fields such as title, genre, platform, price, and creation timestamp.
 * </p>
 * 
 * <p>
 * This class can be converted to a {@link GameModel} for use in the presentation layer.
 * </p>
 *
 * @see GameModel
 */
@Table("games")
public class GameEntity {

    /** Unique identifier for the game (primary key) */
    @Id
    @Column("game_id")
    int game_id;

    /** Title of the game */
    @Column("title")
    String title;

    /** Genre or category of the game (e.g., Action, RPG) */
    @Column("genre")
    String genre;

    /** Platform the game is available on (e.g., PC, PS5, Xbox) */
    @Column("platform")
    String platform;

    /** Price of the game */
    @Column("price")
    float price;

    /** Description or summary of the game */
    @Column("description")
    String description;

    /** Average user rating of the game (e.g., 4.5) */
    @Column("rating")
    float rating;

    /** Image URL or path for the game */
    @Column("img")
    String img;

    /** Timestamp indicating when the game record was created */
    @Column("created_at")
    Timestamp created_at;

    /**
     * Constructs a {@code GameEntity} with the given game details.
     *
     * @param game_id      unique game ID
     * @param title        title of the game
     * @param genre        genre of the game
     * @param platform     platform the game is available on
     * @param price        price of the game
     * @param description  short description of the game
     * @param rating       average user rating of the game
     * @param img          image path or URL for the game
     * @param created_at   timestamp when the game was created
     */
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

    /** @return the game's unique ID */
    public int getGame_id() {
        return game_id;
    }

    /** @param game_id the game ID to set */
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    /** @return the game's title */
    public String getTitle() {
        return title;
    }

    /** @param title the game title to set */
    public void setTitle(String title) {
        this.title = title;
    }

    /** @return the genre of the game */
    public String getGenre() {
        return genre;
    }

    /** @param genre the game genre to set */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /** @return the platform the game is available on */
    public String getPlatform() {
        return platform;
    }

    /** @param platform the platform to set */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /** @return the price of the game */
    public float getPrice() {
        return price;
    }

    /** @param price the price to set */
    public void setPrice(float price) {
        this.price = price;
    }

    /** @return the description of the game */
    public String getDescription() {
        return description;
    }

    /** @param description the description to set */
    public void setDescription(String description) {
        this.description = description;
    }

    /** @return the timestamp when the game was created */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /** @param created_at the creation timestamp to set */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /** @return the average user rating of the game */
    public float getRating() {
        return rating;
    }

    /** @param rating the rating to set */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /** @return the image URL or path */
    public String getImg() {
        return img;
    }

    /** @param img the image URL or path to set */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * Converts this entity to a {@link GameModel} for use in the presentation layer.
     *
     * @return a {@code GameModel} with the same data
     */
    public GameModel toModel() {
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
