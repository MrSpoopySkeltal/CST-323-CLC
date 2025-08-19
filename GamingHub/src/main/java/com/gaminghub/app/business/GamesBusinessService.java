package com.gaminghub.app.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaminghub.app.data.GamesDataService;
import com.gaminghub.app.data.entity.GameEntity;
import com.gaminghub.app.presentation.model.GameModel;

@Service
public class GamesBusinessService implements GamesBusinessServiceInterface {

	@Autowired
	GamesDataService service;
	
	@Override
	public List<GameModel> getGames() {
		return service.findAll()
					  .stream()
					  .map(GameEntity::toModel)
					  .collect(Collectors.toList());
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

	@Override
	public List<GameModel> getGamesInRange(int limit, int offset) {
		return service.findRange(limit, offset)
					  .stream()
					  .map(GameEntity::toModel)
					  .collect(Collectors.toList());
	}

	@Override
	public GameModel getGameById(int game_id) {
		return service.findById(game_id).toModel();
	}

	@Override
	public boolean addGame(GameModel game) {
		return service.create(game.toEntity());
	}

	@Override
	public boolean updateGame(GameModel game) {
		return service.update(game.toEntity());
	}

	@Override
	public boolean deleteGame(int game_id) {
		return service.delete(game_id);
	}

	@Override
	public boolean deleteGame(GameModel game) {
		return service.delete(game.toEntity());
	}

	@Override
	public int getGameCount() {
		return service.getCount();
	}
}
