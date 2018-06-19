package ejb.controllers;


import ejb.beans.Consumer;
import ejb.beans.HelloEjb;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("hello")
@SessionScoped
public class Hello implements Serializable {

    @EJB
    private HelloEjb helloEjb;
    @EJB
    private Consumer consumer;

    private String message;

    private String messageQueu;

    public void setName(String name) {
        message = helloEjb.sayHello(name);
        consumer.receive();
    }

    public String getMessage() {
        return message;
    }



}
