package com.gaminghub.app.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gaminghub.app.data.entity.CustomerEntity;

/**
 * Maps a row from the {@code customers} database table to a {@link CustomerEntity} object.
 * <p>
 * This implementation of {@link RowMapper} extracts the relevant columns from the
 * {@link ResultSet} and constructs a {@code CustomerEntity} representing that row.
 * </p>
 * 
 * @see CustomerEntity
 * @see RowMapper
 */
public class CustomerRowMapper implements RowMapper<CustomerEntity> {

    /**
     * Maps a single row of data from the {@link ResultSet} to a {@link CustomerEntity}.
     *
     * @param rs the {@link ResultSet} to map (pre-initialized to the current row)
     * @param rowNum the number of the current row
     * @return a {@code CustomerEntity} initialized with data from the current row
     * @throws SQLException if a database access error occurs or the column names are invalid
     */
    @Override
    public CustomerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerEntity(
                rs.getInt("customer_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getTimestamp("created_at")
        );
    }
}
