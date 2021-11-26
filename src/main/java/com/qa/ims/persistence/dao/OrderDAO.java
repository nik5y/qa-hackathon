package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public static final Logger LOGGER = LogManager.getLogger();

//    @Overrorder_ide
    public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long order_id = resultSet.getLong("order_id");
        int customer_id = Integer.parseInt(resultSet.getString("customer_id"));
        return new Order(order_id, customer_id);
    }

    /**
     * Reads all order from the database
     *
     * @return A list of order
     */
//    @Overrorder_ide
    public List<Order> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
            List<Order> order = new ArrayList<>();
            while (resultSet.next()) {
                order.add(modelFromResultSet(resultSet));
            }
            return order;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public Order readLatest() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * Creates a o in the database
     *
     * @param o - takes in a o object. order_id will be ignored
     */
//    @Overrorder_ide
    public Order create(Order o) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO orders(customer_id) VALUES (?)");) {
            statement.setInt(1, o.getCustomerId());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

//    @Overrorder_ide
    public Order read(Long order_id) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
            statement.setLong(1, order_id);
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
     * Updates a o in the database
     *
     * @param o - takes in a o object, the order_id field will be used to
     *                 update that o in the database
     * @return
     */
//    @Overrorder_ide
    public Order update(Order o) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("UPDATE orders SET customer_id = ? WHERE order_id = ?");) {
            statement.setInt(1, o.getCustomerId());
            statement.setLong(2, o.getOrderId());
            statement.executeUpdate();
            return read(o.getOrderId());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * Deletes a o in the database
     *
     * @param order_id - order_id of the o
     */
//    @Overrorder_ide
    public int delete(long order_id) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
            statement.setLong(1, order_id);
            return statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

    public int addItem(long orderId, long itemId) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT item_name, item_price FROM items WHERE item_id = ?");) {
            statement.setLong(1, itemId);
            String itemName = null;
            double itemPrice = -1;
            try (ResultSet resultSet = statement.executeQuery();) {
                resultSet.next();
                itemName = resultSet.getString(1);
                itemPrice = resultSet.getDouble(2);
                if(!itemName.isEmpty() && itemPrice > -1) {
                    PreparedStatement statement1 = connection.prepareStatement("INSERT INTO order_items VALUES ('?', '?', '?', '?')");
                    statement1.setLong(1, orderId);
                    statement1.setLong(2, itemId);
                    statement1.setString(3, itemName);
                    statement1.setDouble(4, itemPrice);
                    return statement1.execute() ? 1 : 0;
                }
            }
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

    public int deleteItem(long orderId, long itemId) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE order_id = ? AND item_id = ?");) {
            statement.setLong(1, orderId);
            statement.setLong(2, itemId);
            return statement.execute() ? 1 : 0;
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

}
