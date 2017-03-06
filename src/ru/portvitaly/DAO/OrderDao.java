package ru.portvitaly.DAO;

import ru.portvitaly.entity.Order;

import javax.ejb.Remote;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Remote
public interface OrderDao {

    public List<Order> allOrders() throws SQLException, NamingException;

    public Order addOrder(Order order) throws SQLException, NamingException;

    public void deleteOrder(int idOrder) throws SQLException, NamingException;

    public Order updateOrder(Order order) throws SQLException, NamingException;

    public Order getOrderById(int idOrder) throws SQLException, NamingException;
}
