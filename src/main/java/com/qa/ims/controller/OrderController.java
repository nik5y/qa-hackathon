package com.qa.ims.controller;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

    public static final Logger LOGGER = LogManager.getLogger();

    private OrderDAO orderDAO;
    private Utils utils;

    public OrderController(OrderDAO orderDAO, Utils utils) {
        super();
        this.orderDAO = orderDAO;
        this.utils = utils;
    }

    /**
     * Reads all orders to the logger
     */
    @Override
    public List<Order> readAll() {
        List<Order> orders = orderDAO.readAll();
        for (Order order : orders) {
            LOGGER.info(order);
        }
        return orders;
    }

    /**
     * Creates a order by taking in user input
     */
    @Override
    public Order create() {
        LOGGER.info("Please enter an customer ID");
        int customerId = Integer.parseInt(utils.getString());
        Order order = orderDAO.create(new Order(customerId));
        LOGGER.info("Order created");
        return order;
    }

    @Override
    public int addItem() {
        LOGGER.info("Choose order ID");
        long orderId = utils.getLong();
        LOGGER.info("Choose item ID");
        long itemId = utils.getLong();
        int result = orderDAO.addItem(orderId, itemId);
        LOGGER.info(result==1?"Item added" : "Item failed to add.");
        return 1;
    }

    @Override
    public int deleteItem(){
        LOGGER.info("Choose order ID");
        long orderId = utils.getLong();
        LOGGER.info("Choose item ID");
        long itemId = utils.getLong();
        int result = orderDAO.deleteItem(orderId, itemId);
        LOGGER.info(result==1?"Item deleted" : "Item failed to delete.");
        return result;
    }
//    private Long productId;
//    private String productName;
//    private Double customerId;

    /**
     * Updates an existing order by taking in user input
     */
    @Override
    public Order update() {
        LOGGER.info("Please enter the id of the order you would like to update");
        Long id = utils.getLong();
        LOGGER.info("Please enter a customerId");
        int customerId = Integer.parseInt(utils.getString());
        Order order = orderDAO.update(new Order(id, customerId));
        LOGGER.info("Order Updated");
        return order;
    }

    /**
     * Deletes an existing order by the id of the order
     *
     * @return
     */
    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the order you would like to delete");
        Long id = utils.getLong();
        return orderDAO.delete(id);
    }

}
