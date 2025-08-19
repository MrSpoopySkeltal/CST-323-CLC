package com.gaminghub.app.data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaminghub.app.data.entity.OrderEntity;
import com.gaminghub.app.data.mapper.OrdersRowMapper;
import com.gaminghub.app.data.repository.OrdersRepository;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity> {

	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<OrderEntity> findAll() {
		return ordersRepository.findAll();
	}

	@Override
	public List<OrderEntity> findRange(int limit, int offset) {
		String sql = "SELECT * FROM orders LIMIT ? OFFSET ?";
		List<OrderEntity> results = new ArrayList<OrderEntity>();
		try {
			Iterable<OrderEntity> iterable = jdbcTemplate.query(sql, new OrdersRowMapper(), limit, offset);
			iterable.forEach(results::add);
		} catch (Exception e) { e.printStackTrace(); }
		return results;
	}

	@Override
	public OrderEntity findById(int id) {
		try {
			OrderEntity e = ordersRepository.findById(id).get();
			return e;
		} catch (NoSuchElementException e) { e.printStackTrace(); }
		return null;
	}

	@Transactional
	@Override
	public boolean create(OrderEntity t) {
		String sql = "INSERT INTO orders (total_amount, customer_id) VALUES (?, ?)";
		try {
			int num = jdbcTemplate.update(sql, t.getTotal_amount(), t.getCustomer_id());
			return num == 1;
		} catch (DataAccessException e) { e.printStackTrace(); throw e; }
		catch (Exception e) { e.printStackTrace(); }
		return false;
	}

	@Transactional
	@Override
	public boolean update(OrderEntity t) {
		String sql = "UPDATE orders SET total_amount = ?, customer_id = ?, created_at = ? WHERE order_id = ?";
		try {
			int num = jdbcTemplate.update(sql, t.getTotal_amount(), t.getCustomer_id(), t.getCreated_at(), t.getOrder_id());
			return num == 1;
		} catch (DataAccessException e) { e.printStackTrace(); throw e; }
		catch (Exception e) { e.printStackTrace(); }
		return false;
	}

	@Transactional
	@Override
	public boolean delete(OrderEntity t) {
		return delete(t.getOrder_id());
	}

	@Transactional
	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM orders WHERE order_id = ?";
		try {
			int num = jdbcTemplate.update(sql, id);
			return num == 1;
		} catch (DataAccessException e) { e.printStackTrace(); throw e; }
		catch (Exception e) { e.printStackTrace(); }
		return false;
	}

	@Override
	public int getCount() {
		return (int)ordersRepository.count();
	}

}
