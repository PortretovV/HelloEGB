package ru.portvitaly.DAO;


import ru.portvitaly.entity.Product;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl extends Dao implements ProductDao{
    @Override
    public List<Product> allProducts() throws SQLException, NamingException {
        return null;
    }

    @Override
    public Product addProduct(Product product) throws SQLException, NamingException {
        return null;
    }

    @Override
    public void deleteProduct(int idProduct) throws SQLException, NamingException {

    }

    @Override
    public Product updateProduct(Product product) throws SQLException, NamingException {
        return null;
    }

    @Override
    public Product getProductById(int idProduct) throws SQLException, NamingException {
        return null;
    }
}
