/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import phong.mobile.Tbl_MobileDTO;

/**
 *
 * @author PhongNTSE1997
 */
public class CartObj implements Serializable {

    private String CustomerID;
    private Map<String, Tbl_MobileDTO> items;
    private float total = 0;

    public float getTotal() {
        return total;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Map<String, Tbl_MobileDTO> getItems() {
        return items;
    }

    public void addItemToCart(String title, Tbl_MobileDTO dto) {

        if (this.items == null) {
            this.items = new HashMap<>();
        }
        dto.setQuantity("1");
        if (this.items.containsKey(title)) {
            int quantity = Integer.parseInt(this.items.get(title).getQuantity()) + 1;
            dto.setQuantity(Integer.toString(quantity));
        }
        this.items.put(title, dto);
        computeTotal();
    }

    public void removeItemFromCart(String title) {
        if (this.items == null) {
            return;
        }
        if (this.items.containsKey(title)) {
            this.items.remove(title);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
        computeTotal();
    }

    public void updateCart(String item, Tbl_MobileDTO dto) {
        this.items.put(item, dto);
    }

    private void computeTotal() {
        total = 0;
        if (items != null) {
            Set<String> ids = items.keySet();
            for (String id : ids) {
                Tbl_MobileDTO dto = items.get(id);
                total += (Float.parseFloat(dto.getPrice())) * (Integer.parseInt(dto.getQuantity()));
            }
        }
    }

}
