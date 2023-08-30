/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timothy.session;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ASUS ROG Laptop
 */
@Remote
public interface ShoppingCartLocal {
    void addItem(String item);
    
    List<String> getItems();
}
