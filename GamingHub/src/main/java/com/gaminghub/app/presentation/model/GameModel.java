package com.gaminghub.app.presentation.model;

import java.sql.Timestamp;

import com.gaminghub.app.data.entity.GameEntity;

/**
 * Represents a domain model for a video game in the system.
 * <p>
 * This model corresponds to a record in the `games` table and contains
 * metadata such as title, genre, platform, pricing, rating, image URL,
 * and creation timestamp.
 * </p>
 * 
 * <p>
 * This model is used within the presentation layer and can be converted to
 * a {@link GameEntity} object for persistence in the data layer.
 * </p>
 *
 * @see GameEntity
 */
public class GameModel {

    /** Unique identifier for the game */
    int game_id;

    /** Title of the game */
    String title;

    /** Genre/category of the game (e.g., Action, RPG) */
    String genre;

    /** Platform the game is available on (e.g., PC, PS5, Xbox) */
    String platform;

    /** Price of the game */
    float price;

    /** Brief description or summary of the game */
    String description;

    /** Average user rating of the game (e.g., 4.5 out of 5) */
    float rating;

    /** URL or path to the image/cover art for the game */
    String img;

    /** Timestamp indicating when the game record was created */
    Timestamp created_at;

    /**
     * Constructs a new {@code GameModel} with the specified game details.
     *
     * @param game_id      the unique ID of the game
     * @param title        the title of the game
     * @param genre        the genre of the game
     * @param platform     the platform the game is available on
     * @param price        the price of the game
     * @param description  a brief description of the game
     * @param rating       the user rating of the game
     * @param img          the image URL or path for the game
     * @param created_at   the timestamp when the game was added
     */
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

    /** @return the unique ID of the game */
    public int getGame_id() {
        return game_id;
    }

    /** @param game_id the unique ID to set */
    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    /** @return the title of the game */
    public String getTitle() {
        return title;
    }

    /** @param title the title to set */
    public void setTitle(String title) {
        this.title = title;
    }

    /** @return the genre of the game */
    public String getGenre() {
        return genre;
    }

    /** @param genre the genre to set */
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

    /** @return the rating of the game */
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

    /** @return the timestamp when the game was created */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /** @param created_at the creation timestamp to set */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * Converts this model to its corresponding {@link GameEntity}.
     *
     * @return a {@code GameEntity} containing the same data
     */
    public GameEntity toEntity() {
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

    /**
     * Returns a string representation of the game model.
     *
     * @return a string containing the game details
     */
    @Override
    public String toString() {
        return "GameModel [game_id=" + game_id + ", title=" + title + ", genre=" + genre + ", platform=" + platform
                + ", price=" + price + ", description=" + description + ", created_at=" + created_at + "]";
    }
}
