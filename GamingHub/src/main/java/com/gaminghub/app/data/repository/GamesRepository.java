package com.gaminghub.app.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaminghub.app.data.entity.GameEntity;

/**
 * Repository interface for performing CRUD operations on the {@code games} table.
 * <p>
 * Extends {@link CrudRepository} to provide standard methods for retrieving, counting,
 * saving, and deleting game entities. Custom SQL queries are used for the {@code findAll}
 * and {@code count} methods.
 * </p>
 * 
 * @see CrudRepository
 * @see GameEntity
 */
@Repository
public interface GamesRepository extends CrudRepository<GameEntity, Integer> {

    /**
     * Retrieves all games from the database.
     * 
     * @return a list of all {@link GameEntity} records
     */
    @Query("SELECT * FROM games WHERE 1")
    List<GameEntity> findAll();

    /**
     * Counts the total number of games in the database.
     * 
     * @return the number of game records
     */
    @Query("SELECT COUNT(*) FROM games WHERE 1")
    long count();
}
