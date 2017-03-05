package ru.portvitaly.JSF;


import ru.portvitaly.EGB.BasketBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloWorldBean {

    @EJB
    private BasketBean basketBean;

    public String index(){

        return "index";

    }

}
