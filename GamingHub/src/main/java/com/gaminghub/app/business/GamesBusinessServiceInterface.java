package com.gaminghub.app.business;

import java.util.List;

import com.gaminghub.app.presentation.model.GameModel;

/**
 * Interface defining business operations related to games.
 */
public interface GamesBusinessServiceInterface {

    /**
     * Retrieves all games.
     * 
     * @return List of all GameModel objects
     */
    List<GameModel> getGames();

    /**
     * Retrieves a range of games for pagination.
     * 
     * @param limit  Number of games to retrieve
     * @param offset Number of games to skip before starting retrieval
     * @return List of GameModel objects within the specified range
     */
    List<GameModel> getGamesInRange(int limit, int offset);

    /**
     * Retrieves a list of games filtered by specified criteria.
     * 
     * @param genre     Genre to filter by (nullable)
     * @param platform  Platform to filter by (nullable)
     * @param maxPrice  Maximum price to filter by (nullable)
     * @param minRating Minimum rating to filter by (nullable)
     * @return List of filtered GameModel objects matching the criteria
     */
    List<GameModel> getFilteredGames(String genre, String platform, Float maxPrice, Float minRating);

    /**
     * Retrieves a game by its unique ID.
     * 
     * @param game_id The ID of the game to retrieve
     * @return The GameModel matching the ID, or null if not found
     */
    GameModel getGameById(int game_id);

    /**
     * Adds a new game.
     * 
     * @param game The GameModel to add
     * @return true if the game was added successfully, false otherwise
     */
    boolean addGame(GameModel game);

    /**
     * Updates an existing game.
     * 
     * @param game The GameModel with updated information
     * @return true if the update was successful, false otherwise
     */
    boolean updateGame(GameModel game);

    /**
     * Deletes a game by its unique ID.
     * 
     * @param game_id The ID of the game to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteGame(int game_id);

    /**
     * Deletes a game.
     * 
     * @param game The GameModel to delete
     * @return true if deletion was successful, false otherwise
     */
    boolean deleteGame(GameModel game);

    /**
     * Retrieves the total count of games.
     * 
     * @return The number of games
     */
    int getGameCount();
}
