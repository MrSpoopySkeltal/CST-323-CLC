package com.gaminghub.app.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gaminghub.app.data.entity.OrderEntity;

/**
 * Maps a row from the {@code orders} table in the database to an {@link OrderEntity}.
 * <p>
 * This class implements {@link RowMapper} to convert each row in the {@link ResultSet} 
 * into an {@code OrderEntity} instance by extracting the order ID, total amount, customer ID,
 * and creation timestamp from the database columns.
 * </p>
 * 
 * @see OrderEntity
 * @see RowMapper
 */
public class OrdersRowMapper implements RowMapper<OrderEntity> {

    /**
     * Extracts data from the current row of the {@link ResultSet} and creates an {@link OrderEntity}.
     *
     * @param rs the {@link ResultSet} positioned at the current row
     * @param rowNum the number of the current row
     * @return an {@code OrderEntity} populated with data from the current row
     * @throws SQLException if a database access error occurs
     */
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
