package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OrderDAO implements Dao<Order> {

    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long orderId = resultSet.getLong("order-id");
        Long customerId = resultSet.getLong("customer_id");
        Long productId = resultSet.getLong("product_id");
        String productName = resultSet.getString("product_name");
        Double productValue = resultSet.getDouble("product_value");
        return new Order(orderId, customerId, productId, productName, productValue);

    }

    /**
     * Reads all orders from the database
     *
     * @return A list of orders
     */
    @Override
    public List<Order> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                orders.add(modelFromResultSet(resultSet));
            }
            return orders;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public Order readLatest() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * Creates an order in the database
     *
     * @param order - takes in a customer object. id will be ignored
     */
    @Override
    public Order create(Order order) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO orders(product_name, product_value) VALUES (?, ?)");) {
            statement.setString(1, order.getProductName());
            statement.setDouble(2, order.getProductValue());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Order read(Long orderId) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
            statement.setLong(1, orderId);
            try (ResultSet resultSet = statement.executeQuery();) {
                resultSet.next();
                return modelFromResultSet(resultSet);
            }
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * Updates an order in the database
     *
     * @param order - takes in an order object, the id field will be used to
     *              update that order in the database
     * @return
     */
    @Override
    public Order update(Order order) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("UPDATE order SET product_name = ?, product_value = ? WHERE order_id = ?");) {
            statement.setString(1, order.getProductName());
            statement.setDouble(2, order.getProductValue());
            statement.setLong(3, order.getProductId());
            statement.executeUpdate();
            return read(order.getProductId());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * Deletes an order in the database
     *
     * @param orderId - id of the order
     */
    @Override
    public int delete(long orderId) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE id = ?");) {
            statement.setLong(1, orderId);
            return statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

}


