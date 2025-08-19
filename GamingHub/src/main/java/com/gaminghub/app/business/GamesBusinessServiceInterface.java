package com.gaminghub.app.business;

import java.util.List;

import com.gaminghub.app.presentation.model.GameModel;

public interface GamesBusinessServiceInterface {
	List<GameModel> getGames();
	List<GameModel> getGamesInRange(int limit, int offset);
	List<GameModel> getFilteredGames(String genre, String platform, Float maxPrice, Float minRating);
	GameModel getGameById(int game_id);
	boolean addGame(GameModel game);
	boolean updateGame(GameModel game);
	boolean deleteGame(int game_id);
	boolean deleteGame(GameModel game);
	int getGameCount();
}
