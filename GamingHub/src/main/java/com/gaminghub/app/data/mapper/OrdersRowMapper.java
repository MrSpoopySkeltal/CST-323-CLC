package com.gaminghub.app.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gaminghub.app.data.entity.OrderEntity;

public class OrdersRowMapper implements RowMapper<OrderEntity> {

	@Override
	public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new OrderEntity(
				rs.getInt("order_id"),
				rs.getFloat("total_amount"),
				rs.getInt("customer_id"),
				rs.getTimestamp("created_at")
				);
	}

}
