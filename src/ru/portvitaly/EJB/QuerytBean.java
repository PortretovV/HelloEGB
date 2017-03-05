package ru.portvitaly.EJB;

import ru.portvitaly.entity.Product;

import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "ProductEJB")
public class QuerytBean {

    public List<Product> allProducts(){


    }



}
