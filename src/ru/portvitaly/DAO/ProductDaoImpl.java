package ru.portvitaly.DAO;


import ru.portvitaly.entity.Order;
import ru.portvitaly.entity.Product;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends Dao implements ProductDao{
    private final String ALL_PRODUCT = "SELECT `id_product`, `article`, `count`, `cost` FROM products";
    private final String SELECT_PRODUCT = "SELECT `id_product`, `article`, `count`, `cost` FROM orders WHERE `id_product` = ?";

    @Override
    public List<Product> allProducts() throws SQLException, NamingException {
        List<Product> products = new ArrayList<>();

        try(PreparedStatement prepStatement = connection.prepareStatement(ALL_PRODUCT)){
            ResultSet resultProduct = prepStatement.executeQuery();
            while(resultProduct.next()){
                Product product = new Product(
                        resultProduct.getInt("id_product"),
                        resultProduct.getString("article"),
                        resultProduct.getInt("count"),
                        resultProduct.getInt("cost")
                );
                products.add(product);
            }
        }finally {
            closeConnection();
        }
        return products;
    }





    @Override
    public Product getProductById(int idProduct) throws SQLException, NamingException {
        openConnection();
        Product product = null;
        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_PRODUCT)){
            prepStatement.setInt(1,idProduct);

            ResultSet resultProduct = prepStatement.executeQuery();
            resultProduct.next();
            product = new Product(
                    resultProduct.getInt("id_product"),
                    resultProduct.getString("article"),
                    resultProduct.getInt("count"),
                    resultProduct.getInt("cost")
                );
        }finally {
        closeConnection();
        }
        return product;
    }



//    @Override
//    public Product addProduct(Product product) throws SQLException, NamingException {
//        return null;
//    }
//
//    @Override
//    public void deleteProduct(int idProduct) throws SQLException, NamingException {
//
//    }
//
//    @Override
//    public Product updateProduct(Product product) throws SQLException, NamingException {
//        return null;
//    }


}
