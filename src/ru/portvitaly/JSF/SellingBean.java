package ru.portvitaly.JSF;

import ru.portvitaly.EJB.BasketBean;
import ru.portvitaly.EJB.QueryBean;
import ru.portvitaly.entity.Lot;
import ru.portvitaly.entity.Order;
import ru.portvitaly.entity.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "SellBean")
public class SellingBean {

    private List<Lot> lots = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private Product product = new Product();
    private int productCount;
    private Order order;

    @EJB
    BasketBean basketBean;
    @EJB
    QueryBean queryBean;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Product> getProducts() {
        return queryBean.allProducts();
    }


    public List<Lot> getLots() {
        return basketBean.getProducts();
    }

    public String index(){
        return "index";
    }

    public String basket(){
        return "basket";
    }


    public String buyProducts(){
        int result = basketBean.buyProducts();
        if(result == 1 )
            return "success";
        else
            return "failed";
    }

    public String detail(int id){
        product = queryBean.productById(id);
        return "detail";
    }

    public String addToBasket(Product product, int countProduct){
        basketBean.addProduct(product, countProduct);
        return "index";
    }

}
