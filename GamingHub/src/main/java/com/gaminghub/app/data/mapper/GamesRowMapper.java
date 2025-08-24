package com.gaminghub.app.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gaminghub.app.data.entity.GameEntity;

/**
 * Maps a row from the {@code games} database table to a {@link GameEntity} object.
 * <p>
 * Implements the {@link RowMapper} interface to convert each row of the {@link ResultSet}
 * into a {@code GameEntity} instance with all fields populated from the database columns.
 * </p>
 * 
 * @see GameEntity
 * @see RowMapper
 */
public class GamesRowMapper implements RowMapper<GameEntity> {

    /**
     * Maps a single row of data from the {@link ResultSet} to a {@link GameEntity}.
     *
     * @param rs the {@link ResultSet} positioned at the current row
     * @param rowNum the current row number
     * @return a {@code GameEntity} initialized with data from the current row
     * @throws SQLException if an SQL error occurs while accessing the {@link ResultSet}
     */
    @Override
    public GameEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new GameEntity(
                rs.getInt("game_id"),
                rs.getString("title"),
                rs.getString("genre"),
                rs.getString("platform"),
                rs.getFloat("price"),
                rs.getString("description"),
                rs.getFloat("rating"),
                rs.getString("img"),
                rs.getTimestamp("created_at")
        );
    }
}
