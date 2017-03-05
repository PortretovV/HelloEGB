package ru.portvitaly.EJB;

import ru.portvitaly.DAO.ProductDao;
import ru.portvitaly.DAO.ProductDaoImpl;
import ru.portvitaly.entity.Product;

import javax.ejb.Stateless;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "ProductEJB")
public class QuerytBean {

    public List<Product> allProducts(){
        List<Product> products = new ArrayList<>();
        ProductDao productDao = new ProductDaoImpl();
        try {
            products = productDao.allProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return products;
    }



}
