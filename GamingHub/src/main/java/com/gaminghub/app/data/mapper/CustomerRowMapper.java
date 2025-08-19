package com.gaminghub.app.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gaminghub.app.data.entity.CustomerEntity;

public class CustomerRowMapper implements RowMapper<CustomerEntity> {

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
