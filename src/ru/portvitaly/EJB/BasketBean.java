package ru.portvitaly.EJB;

import ru.portvitaly.DAO.OrderDao;
import ru.portvitaly.DAO.OrderDaoImpl;
import ru.portvitaly.DAO.PurchaseDao;
import ru.portvitaly.DAO.PurchaseDaoImpl;
import ru.portvitaly.entity.Lot;
import ru.portvitaly.entity.Order;
import ru.portvitaly.entity.Product;

import javax.ejb.Stateful;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Stateful(name = "BasketEJB")
public class BasketBean implements Serializable {

    private List<Lot> products = new ArrayList<>();
    private Order order;

    public List<Lot> getProducts() {
        return products;
    }

    public Order getOrder() {
        return order;
    }

    public void addProduct(Product product, int countProduct){
        this.products.add(new Lot(product,countProduct));
    }

    public void deleteProduct(int idLot){
        this.products.remove(idLot);
    }

    public void editProduct(int idLot, int count){
        Lot lot = this.products.get(idLot);
        lot.setCount(count);
    }

    private void createOrder(){
        if(this.products.isEmpty())
            return;
        Random r = new Random();
        int width = 700 - r.nextInt(10);
        int lenght = 1000 - r.nextInt(10);
        int height = 400 - r.nextInt(10);
        int count = products.size();
        String article = UUID.randomUUID().toString().substring(0,45);
        int cost = 0;
        for (Lot l : products) {
            cost += l.getProduct().getCost();
        }

        this.order = new Order(article, cost, width*count, height*count, lenght*count);
    }

    private int createPurchase(){
        if(products.isEmpty() || order == null)
            return 0;

        OrderDao orderDao = new OrderDaoImpl();
        PurchaseDao purchaseDao = new PurchaseDaoImpl();

        try {
            this.order = orderDao.addOrder(order);
            int result = purchaseDao.addPurchase(products,order);
            if(result == 1)
                return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int buyProducts(){
        createOrder();
        return createPurchase();
    }

}

