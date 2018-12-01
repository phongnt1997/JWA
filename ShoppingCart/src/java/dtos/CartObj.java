/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author PhongNTSE1997
 */
public class CartObj implements Serializable {

    private String customerName;
    private HashMap<String, ProductDTO> cart;

    public CartObj() {
        this.customerName = "guest";
        this.cart = new HashMap<>();

    }

    public CartObj(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, ProductDTO> getCart() {
        return cart;
    }

    public void addCart(ProductDTO dto) throws Exception{
        if (this.cart.containsKey(dto.getId())) {
            dto.setQuantity(this.cart.get(dto.getId()).getQuantity() + 1);
        }
        this.cart.put(dto.getId(), dto);
    }
    
    public void removeCart(String id) throws Exception{
        if(this.cart.containsKey(id))
            this.cart.remove(id);
    }
    
    public void updateCart(String id, int quantity) throws Exception {
        if(this.cart.containsKey(id)) {
            this.cart.get(id).setQuantity(quantity);
        }
    }
    
    public float gettotal() throws Exception {
        float result = 0;
        for (ProductDTO dto : this.cart.values()) {
            result += (dto.getQuantity() * dto.getPrice());
        }
        return result;
    }

}
