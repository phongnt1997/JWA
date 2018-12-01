/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.product;

import java.io.Serializable;

/**
 *
 * @author PhongNTSE1997
 */
public class ErrorObj implements Serializable {

    private String idLengthErr;
    private String nameLengthErr;
    private String unitLengthErr;
    private String priceFormatErr;
    private String quantityFormatErr;
    private String idExistedErr;

    public String getIdLengthErr() {
        return idLengthErr;
    }

    public void setIdLengthErr(String idLengthErr) {
        this.idLengthErr = idLengthErr;
    }

    public String getNameLengthErr() {
        return nameLengthErr;
    }

    public void setNameLengthErr(String nameLengthErr) {
        this.nameLengthErr = nameLengthErr;
    }

    public String getUnitLengthErr() {
        return unitLengthErr;
    }

    public void setUnitLengthErr(String unitLengthErr) {
        this.unitLengthErr = unitLengthErr;
    }

    public String getPriceFormatErr() {
        return priceFormatErr;
    }

    public void setPriceFormatErr(String priceFormatErr) {
        this.priceFormatErr = priceFormatErr;
    }

    public String getQuantityFormatErr() {
        return quantityFormatErr;
    }

    public void setQuantityFormatErr(String quantityFormatErr) {
        this.quantityFormatErr = quantityFormatErr;
    }

    public String getIdExistedErr() {
        return idExistedErr;
    }

    public void setIdExistedErr(String idExistedErr) {
        this.idExistedErr = idExistedErr;
    }
    
    
    
}
