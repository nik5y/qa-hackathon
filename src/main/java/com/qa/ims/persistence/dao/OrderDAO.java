package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class OrderDAO implements Dao<Order> {


        public final Logger LOGGER = LogManager.getLogger();
        private int orderId;
        private int amount;


    @Override
    public List<Order> readAll() {
        return null;
    }

    @Override
    public Order read(Long id) {
        return null;
    }

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public int delete(long id) {
        return 0;
    }

    @Override
    public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }
}


