package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Customer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MyCustomReader extends JdbcCursorItemReader<Customer> implements ItemReader<Customer> {

    public MyCustomReader(@Autowired DataSource dataSource) {
        setDataSource(dataSource);
        setSql("select * from customer_info");
        setFetchSize(100);
        setRowMapper(new CustomerRowMapper());
    }

    public class CustomerRowMapper implements RowMapper {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getLong("customer_id"));
            customer.setFirstName((rs.getString("first_name")));
            customer.setLastName((rs.getString("last_name")));
            customer.setEmail(rs.getString("email"));
            customer.setGender(rs.getString("gender"));
            customer.setContactNo(rs.getString("contact"));
            customer.setCountry(rs.getString("country"));
            customer.setDob(rs.getString("dob"));
            return customer;
        }
    }
}
