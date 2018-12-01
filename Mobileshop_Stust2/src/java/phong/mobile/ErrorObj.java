/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.mobile;

import java.io.Serializable;

/**
 *
 * @author PhongNTSE1997
 */
public class ErrorObj implements Serializable{
    private String mobileIDLengthErr;
    private String mobileNameLengthErr;
    private String descriptionLengthErr;
    private String priceFormatErr;
    private String yearFormatErr;
    private String quantityFormatErr;
    private String mobileIDExisted;
    private String priceZeroValue;
    private String yomZeroValue;
    private String quantityZeroValue;
    

    public ErrorObj() {
    }

    public String getPriceZeroValue() {
        return priceZeroValue;
    }

    public void setPriceZeroValue(String priceZeroValue) {
        this.priceZeroValue = priceZeroValue;
    }

    public String getYomZeroValue() {
        return yomZeroValue;
    }

    public void setYomZeroValue(String yomZeroValue) {
        this.yomZeroValue = yomZeroValue;
    }

    public String getQuantityZeroValue() {
        return quantityZeroValue;
    }

    public void setQuantityZeroValue(String quantityZeroValue) {
        this.quantityZeroValue = quantityZeroValue;
    }

    public String getMobileIDLengthErr() {
        return mobileIDLengthErr;
    }

    public void setMobileIDLengthErr(String mobileIDLengthErr) {
        this.mobileIDLengthErr = mobileIDLengthErr;
    }

    public String getMobileNameLengthErr() {
        return mobileNameLengthErr;
    }

    public void setMobileNameLengthErr(String mobileNameLengthErr) {
        this.mobileNameLengthErr = mobileNameLengthErr;
    }

    public String getDescriptionLengthErr() {
        return descriptionLengthErr;
    }

    public void setDescriptionLengthErr(String descriptionLengthErr) {
        this.descriptionLengthErr = descriptionLengthErr;
    }

    public String getPriceFormatErr() {
        return priceFormatErr;
    }

    public void setPriceFormatErr(String priceFormatErr) {
        this.priceFormatErr = priceFormatErr;
    }

    public String getYearFormatErr() {
        return yearFormatErr;
    }

    public void setYearFormatErr(String yearFormatErr) {
        this.yearFormatErr = yearFormatErr;
    }

    public String getQuantityFormatErr() {
        return quantityFormatErr;
    }

    public void setQuantityFormatErr(String quantityFormatErr) {
        this.quantityFormatErr = quantityFormatErr;
    }

    public String getMobileIDExisted() {
        return mobileIDExisted;
    }

    public void setMobileIDExisted(String mobileIDExisted) {
        this.mobileIDExisted = mobileIDExisted;
    }
    
    
}
