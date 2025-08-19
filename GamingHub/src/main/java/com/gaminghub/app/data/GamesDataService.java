package com.gaminghub.app.data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaminghub.app.data.entity.GameEntity;
import com.gaminghub.app.data.mapper.GamesRowMapper;
import com.gaminghub.app.data.repository.GamesRepository;

@Service
public class GamesDataService implements DataAccessInterface<GameEntity> {

	@Autowired
	GamesRepository gamesRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<GameEntity> findAll() {
		return gamesRepository.findAll();
	}

	/**
	 * @param limit - Number of results to display
	 * @param offset - how many entities to ignore before beginning selection
	 * 
	 * @return Returns a list of GameEntities from a given range
	 */
	@Override
	public List<GameEntity> findRange(int limit, int offset) {
		String sql = "SELECT * FROM games LIMIT ? OFFSET ?";
		List<GameEntity> results = new ArrayList<GameEntity>();
		try {
			Iterable<GameEntity> gamesIterable = jdbcTemplate.query(sql, new GamesRowMapper(), limit, offset);
			gamesIterable.forEach(results::add);
		} catch (DataAccessException e) { e.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }
		
		return results;
	}

	/**
	 * @param id - the id of the entity to select
	 * @return Returns a GameEntity if found or null if not
	 */
	@Override
	public GameEntity findById(int id) {
		try {
			GameEntity e = gamesRepository.findById(id).get();
			return e;
		} catch (NoSuchElementException e) { e.printStackTrace(); }
		return null;
	}

	@Transactional
	@Override
	public boolean create(GameEntity t) {
		String sql = "INSERT INTO games (title, genre, platform, price, description) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			int num = jdbcTemplate.update(sql,t.getTitle(), t.getGenre(), t.getPlatform(), t.getPrice(), t.getDescription());
			return num == 1;
		} catch (DataAccessException e) { e.printStackTrace(); throw e;}
		catch (Exception e) { e.printStackTrace(); }
		return false;
	}

	@Transactional
	@Override
	public boolean update(GameEntity t) {
		String sql = "UPDATE games SET title = ?, genre = ?, platform = ?, price = ?, description = ?, created_at = ? WHERE game_id = ?";
		try {
			int num = jdbcTemplate.update(sql, t.getTitle(), t.getGenre(), t.getPlatform(), t.getPrice(), t.getDescription(), t.getCreated_at(), t.getGame_id());
			return num == 1;
		} catch (DataAccessException e) { e.printStackTrace(); throw e; }
		catch (Exception e) { e.printStackTrace(); }
		return false;
	}

	@Transactional
	@Override
	public boolean delete(GameEntity t) {
		return delete(t.getGame_id());
	}

	@Transactional
	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM games WHERE game_id = ?";
		try {
			int num = jdbcTemplate.update(sql, id);
			return num == 1;
		} catch (DataAccessException e) { e.printStackTrace(); throw e; }
		catch (Exception e) { e.printStackTrace(); } 
		return false;
	}

	@Override
	public int getCount() {
		return (int)gamesRepository.count();
	}

}
