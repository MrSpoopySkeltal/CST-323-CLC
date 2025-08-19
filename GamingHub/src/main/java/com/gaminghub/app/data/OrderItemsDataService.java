package com.gaminghub.app.data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaminghub.app.data.entity.OrderItemEntity;
import com.gaminghub.app.data.mapper.OrderItemRowMapper;
import com.gaminghub.app.data.repository.OrderItemsRepository;

@Service
public class OrderItemsDataService implements OrderItemsDataAccessInterface {

	@Autowired
	OrderItemsRepository orderItemsRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<OrderItemEntity> findAll() {
		return orderItemsRepository.findAll();
	}

	@Override
	public List<OrderItemEntity> findRange(int limit, int offset) {
		String sql = "SELECT * FROM order_items LIMIT ? OFFSET ?";
		List<OrderItemEntity> results = new ArrayList<OrderItemEntity>();
		try {
			Iterable<OrderItemEntity> iterable = jdbcTemplate.query(sql, new OrderItemRowMapper(), limit, offset);
			iterable.forEach(results::add);
		} catch (DataAccessException e) { e.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }
		return results;
	}

	@Override
	public OrderItemEntity findById(int id) {
		try {
			OrderItemEntity e = orderItemsRepository.findById(id).get();
			return e;
		} catch (NoSuchElementException e) { e.printStackTrace(); }
		return null;
	}

	@Transactional
	@Override
	public boolean create(OrderItemEntity t) {
		String sql = "INSERT INTO order_items (order_id, quantity, units_price, game_id) VALUES (?, ?, ?, ?)";
		try {
			int num = jdbcTemplate.update(sql, t.getOrder_id(), t.getQuantity(), t.getUnits_price(), t.getGame_id());
			return num == 1;
		} catch (DataAccessException e) { e.printStackTrace(); throw e; }
		catch (Exception e) { e.printStackTrace(); }
		return false;
	}

	@Transactional
	@Override
	public boolean update(OrderItemEntity t) {
		String sql = "UPDATE order_items SET order_id = ?, quantity = ?, units_price = ?, game_id = ? WHERE order_item_id = ?";
		try {
			int num = jdbcTemplate.update(sql, t.getOrder_id(), t.getQuantity(), t.getUnits_price(), t.getGame_id(), t.getOrder_item_id());
			return num == 1;
		} catch (DataAccessException e) { e.printStackTrace(); throw e; }
		catch (Exception e) { e.printStackTrace(); }
		return false;
	}

	@Transactional
	@Override
	public boolean delete(OrderItemEntity t) {
		return delete(t.getOrder_item_id());
	}

	@Transactional
	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM order_items WHERE order_item_id = ?";
		try {
			int num = jdbcTemplate.update(sql, id);
			return num == 1;
		} catch (DataAccessException e) { e.printStackTrace(); throw e; }
		catch (Exception e) { e.printStackTrace(); }
		return false;
	}

	@Override
	public int getCount() {
		return (int)orderItemsRepository.count();
	}

	@Override
	public List<OrderItemEntity> findByOrderId(int order_id) {
		String sql = "SELECT * FROM order_items WHERE order_id = ?";
		List<OrderItemEntity> results = new ArrayList<OrderItemEntity>();
		try {
			Iterable<OrderItemEntity> iterable = jdbcTemplate.query(sql, new OrderItemRowMapper(), order_id);
			iterable.forEach(results::add);
		} catch (DataAccessException e) { e.printStackTrace(); }
		catch (Exception e) { e.printStackTrace(); }
		return results;
	}

}
