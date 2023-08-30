/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timothy.session;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author ASUS ROG Laptop
 */
@Stateful(mappedName = "shoppingcartbean")
public class ShoppingCart implements ShoppingCartLocal {
    List<String> items = new ArrayList<>();
    
    @Override
    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public List<String> getItems() {
        return items;
    }
}
