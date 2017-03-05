package ru.portvitaly.DAO;

import ru.portvitaly.entity.Lot;
import ru.portvitaly.entity.Order;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PurchaseDaoImpl extends Dao implements PurchaseDao{
    private final String ADD_PURCHASE = " INSERT INTO purchase (id_purchase, id_order, id_product, count) VALUE  (NULL, ?, ?, ?)";

    @Override
    public int addPurchase(List<Lot> products, Order order) throws SQLException, NamingException {
        try {
            openConnection();
            for (Lot l: products ) {
                try(PreparedStatement prepStatement = connection.prepareStatement(ADD_PURCHASE)){
                    prepStatement.setInt(1,order.getId());
                    prepStatement.setInt(2,l.getProduct().getId());
                    prepStatement.setInt(3,l.getCount());

                    int resultOperation = prepStatement.executeUpdate();
                    if(resultOperation == 1)
                        System.out.println("Добавление прошло успешно");

                }
            }
        }finally {
            closeConnection();
        }
        return 0;

    }
}
