package com.gaminghub.app.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gaminghub.app.data.entity.OrderItemEntity;

/**
 * Maps a row from the {@code order_items} database table to an {@link OrderItemEntity} object.
 * <p>
 * This implementation of {@link RowMapper} extracts data from the {@link ResultSet} and
 * creates an {@code OrderItemEntity} representing a single order item.
 * </p>
 * 
 * @see OrderItemEntity
 * @see RowMapper
 */
public class OrderItemRowMapper implements RowMapper<OrderItemEntity> {

    /**
     * Maps a single row of the {@link ResultSet} to an {@link OrderItemEntity}.
     *
     * @param rs the {@link ResultSet} positioned at the current row
     * @param rowNum the number of the current row
     * @return an {@code OrderItemEntity} populated with data from the current row
     * @throws SQLException if there is a database access error
     */
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
