package com.gaminghub.app.data;

import java.util.List;

/**
 * Generic interface defining basic CRUD operations for data access.
 *
 * @param <T> the type of entity this interface manages
 */
public interface DataAccessInterface<T> {
	
	/**
	 * Retrieves all entities of type T.
	 * 
	 * @return a list of all entities
	 */
	List<T> findAll();
	
	/**
	 * Retrieves a subset of entities with pagination support.
	 * 
	 * @param limit the maximum number of entities to return
	 * @param offset the starting position of the first entity to return
	 * @return a list of entities within the specified range
	 */
	List<T> findRange(int limit, int offset);
	
	/**
	 * Finds an entity by its unique identifier.
	 * 
	 * @param id the unique identifier of the entity
	 * @return the entity if found, or null if not found
	 */
	T findById(int id);
	
	/**
	 * Creates a new entity.
	 * 
	 * @param t the entity to create
	 * @return true if creation was successful, false otherwise
	 */
	boolean create(T t);
	
	/**
	 * Updates an existing entity.
	 * 
	 * @param t the entity with updated information
	 * @return true if update was successful, false otherwise
	 */
	boolean update(T t);
	
	/**
	 * Deletes the specified entity.
	 * 
	 * @param t the entity to delete
	 * @return true if deletion was successful, false otherwise
	 */
	boolean delete(T t);
	
	/**
	 * Deletes an entity by its unique identifier.
	 * 
	 * @param id the unique identifier of the entity to delete
	 * @return true if deletion was successful, false otherwise
	 */
	boolean delete(int id);
	
	/**
	 * Returns the total number of entities.
	 * 
	 * @return the count of entities
	 */
	int getCount();
}
