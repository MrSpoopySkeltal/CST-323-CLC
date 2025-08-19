package com.gaminghub.app.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gaminghub.app.data.entity.GameEntity;

public class GamesRowMapper implements RowMapper<GameEntity> {

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
