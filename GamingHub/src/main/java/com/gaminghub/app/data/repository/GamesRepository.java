package com.gaminghub.app.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaminghub.app.data.entity.GameEntity;

@Repository
public interface GamesRepository extends CrudRepository<GameEntity, Integer> {

	@Override
	@Query(value="SELECT * FROM games WHERE 1")
	public List<GameEntity> findAll();
	
	@Override
	@Query(value="SELECT COUNT(*) FROM games WHERE 1")
	public long count();
}
