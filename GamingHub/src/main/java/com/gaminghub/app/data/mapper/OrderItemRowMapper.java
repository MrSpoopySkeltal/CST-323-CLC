package com.gaminghub.app.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gaminghub.app.data.entity.OrderItemEntity;

public class OrderItemRowMapper implements RowMapper<OrderItemEntity>{

	@Override
	public OrderItemEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new OrderItemEntity(
				rs.getInt("order_item_id"),
				rs.getInt("order_id"),
				rs.getInt("quantity"),
				rs.getFloat("units_price"),
				rs.getInt("game_id")
				);
	}

}
