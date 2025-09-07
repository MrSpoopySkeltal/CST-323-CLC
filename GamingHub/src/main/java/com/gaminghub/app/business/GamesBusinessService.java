package com.gaminghub.app.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaminghub.app.data.GamesDataService;
import com.gaminghub.app.data.entity.GameEntity;
import com.gaminghub.app.presentation.model.GameModel;

/**
 * Service implementation for handling business logic related to games.
 */
@Service
public class GamesBusinessService implements GamesBusinessServiceInterface {

    @Autowired
    GamesDataService service;
    
    /**
     * Retrieves all games.
     * 
     * @return List of GameModel objects representing all games
     */
    @Override
    public List<GameModel> getGames() {
        return service.findAll()
                      .stream()
                      .map(GameEntity::toModel)
                      .collect(Collectors.toList());
    }
    
    /**
     * Retrieves games filtered by genre, platform, max price, and minimum rating.
     * Any of the filters can be null or empty to ignore that filter.
     * 
     * @param genre The genre to filter by (case-insensitive), or null/empty to ignore
     * @param platform The platform to filter by (case-insensitive), or null/empty to ignore
     * @param maxPrice The maximum price to filter by, or null to ignore
     * @param minRating The minimum rating to filter by, or null to ignore
     * @return List of GameModel objects matching the filter criteria
     */
    public List<GameModel> getFilteredGames(String genre, String platform, Double maxPrice, Double minRating) {
        return service.findAll()
                      .stream()
                      .filter(g -> genre == null || genre.isEmpty() || g.getGenre().equalsIgnoreCase(genre))
                      .filter(g -> platform == null || platform.isEmpty() || g.getPlatform().equalsIgnoreCase(platform))
                      .filter(g -> maxPrice == null || g.getPrice() <= maxPrice)
                      .filter(g -> minRating == null || g.getRating() >= minRating)
                      .map(GameEntity::toModel)
                      .collect(Collectors.toList());
    }

    /**
     * Retrieves a subset of games within a specified range for pagination.
     * 
     * @param limit Number of games to retrieve
     * @param offset Number of games to skip before retrieval
     * @return List of GameModel objects within the specified range
     */
    @Override
    public List<GameModel> getGamesInRange(int limit, int offset) {
        return service.findRange(limit, offset)
                      .stream()
                      .map(GameEntity::toModel)
                      .collect(Collectors.toList());
    }

    /**
     * Retrieves a game by its ID.
     * 
     * @param game_id The ID of the game to retrieve
     * @return GameModel representing the game with the given ID, or null if not found
     */
    @Override
    public GameModel getGameById(int game_id) {
        return service.findById(game_id).toModel();
    }

    /**
     * Adds a new game.
     * 
     * @param game The GameModel to add
     * @return true if the game was added successfully, false otherwise
     */
    @Override
    public boolean addGame(GameModel game) {
        return service.create(game.toEntity());
    }

    /**
     * Updates an existing game.
     * 
     * @param game The GameModel with updated data
     * @return true if the update was successful, false otherwise
     */
    @Override
    public boolean updateGame(GameModel game) {
        return service.update(game.toEntity());
    }

    /**
     * Deletes a game by its ID.
     * 
     * @param game_id The ID of the game to delete
     * @return true if deletion was successful, false otherwise
     */
    @Override
    public boolean deleteGame(int game_id) {
        return service.delete(game_id);
    }

    /**
     * Deletes a game by the given GameModel.
     * 
     * @param game The GameModel to delete
     * @return true if deletion was successful, false otherwise
     */
    @Override
    public boolean deleteGame(GameModel game) {
        return service.delete(game.toEntity());
    }

    /**
     * Retrieves the total count of games.
     * 
     * @return The number of games
     */
    @Override
    public int getGameCount() {
        return service.getCount();
    }

	@Override
	public List<GameModel> getFilteredGames(String genre, String platform, Float maxPrice, Float minRating) {
		return service.findAll()
					  .stream()
					  .filter(g -> genre == null || genre.isEmpty() || g.getGenre().equalsIgnoreCase(genre))
					  .filter(g -> platform == null || platform.isEmpty() || g.getPlatform().equalsIgnoreCase(platform))
					  .filter(g -> maxPrice == null || g.getPrice() <= maxPrice)
					  .filter(g -> minRating == null || g.getRating() >= minRating)
					  .map(GameEntity::toModel)
					  .collect(Collectors.toList());
	}
}
