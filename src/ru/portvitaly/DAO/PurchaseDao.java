package ru.portvitaly.DAO;

import ru.portvitaly.entity.Lot;
import ru.portvitaly.entity.Order;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface PurchaseDao {
    public int addPurchase(List<Lot> products, Order order) throws SQLException, NamingException;
}
