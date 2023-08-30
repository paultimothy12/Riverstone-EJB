/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timothy.session;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ASUS ROG Laptop
 */
public class TestingShoppingCart {
    public static void main(String args[]) throws NamingException{
        InitialContext context = new InitialContext();
        ShoppingCartLocal scl = (ShoppingCartLocal) context.lookup("shoppingcartbean");
        
        scl.addItem("Random Item1");
         System.out.println(scl.getItems());
         
        scl.addItem("Random Item2");        
        System.out.println(scl.getItems());
    }
}
