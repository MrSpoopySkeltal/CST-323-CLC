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

/**
 * Service class for managing GameEntity data access.
 * Implements CRUD operations using Spring Data repository and JdbcTemplate.
 */
@Service
public class GamesDataService implements DataAccessInterface<GameEntity> {

    @Autowired
    GamesRepository gamesRepository;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    /**
     * Retrieves all games from the database.
     * 
     * @return List of all GameEntity objects
     */
    @Override
    public List<GameEntity> findAll() {
        return gamesRepository.findAll();
    }

    /**
     * Retrieves a range of games with pagination.
     * 
     * @param limit  Number of results to display
     * @param offset How many entities to ignore before beginning selection
     * @return List of GameEntity objects within the specified range
     */
    @Override
    public List<GameEntity> findRange(int limit, int offset) {
        String sql = "SELECT * FROM games LIMIT ? OFFSET ?";
        List<GameEntity> results = new ArrayList<GameEntity>();
        try {
            Iterable<GameEntity> gamesIterable = jdbcTemplate.query(sql, new GamesRowMapper(), limit, offset);
            gamesIterable.forEach(results::add);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return results;
    }

    /**
     * Finds a game by its unique ID.
     * 
     * @param id The ID of the game to find
     * @return The GameEntity if found, or null if not found
     */
    @Override
    public GameEntity findById(int id) {
        try {
            GameEntity e = gamesRepository.findById(id).get();
            return e;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates a new game record in the database.
     * 
     * @param t The GameEntity to create
     * @return true if creation succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean create(GameEntity t) {
        String sql = "INSERT INTO games (title, genre, platform, price, description) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            int num = jdbcTemplate.update(sql, t.getTitle(), t.getGenre(), t.getPlatform(), t.getPrice(), t.getDescription());
            return num == 1;
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Updates an existing game record in the database.
     * 
     * @param t The GameEntity with updated data
     * @return true if update succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean update(GameEntity t) {
        String sql = "UPDATE games SET title = ?, genre = ?, platform = ?, price = ?, description = ?, created_at = ? WHERE game_id = ?";
        try {
            int num = jdbcTemplate.update(sql, t.getTitle(), t.getGenre(), t.getPlatform(), t.getPrice(), t.getDescription(), t.getCreated_at(), t.getGame_id());
            return num == 1;
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Deletes a game from the database using the GameEntity object.
     * 
     * @param t The GameEntity to delete
     * @return true if deletion succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean delete(GameEntity t) {
        return delete(t.getGame_id());
    }

    /**
     * Deletes a game from the database by its ID.
     * 
     * @param id The ID of the game to delete
     * @return true if deletion succeeded, false otherwise
     */
    @Transactional
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM games WHERE game_id = ?";
        try {
            int num = jdbcTemplate.update(sql, id);
            return num == 1;
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Returns the total number of games in the database.
     * 
     * @return The count of game records
     */
    @Override
    public int getCount() {
        return (int) gamesRepository.count();
    }

}
