/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phong.pet;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author PhongNTSE1997
 */
public class tbl_PetDTO implements Serializable{
    private String petID;
    private String petName;
    private String description;
    private Timestamp dob;
    private String vaccineDesp;
    private float price;

    public tbl_PetDTO(String petID, String petName, String description, Timestamp dob, String vaccineDesp, float price) {
        this.petID = petID;
        this.petName = petName;
        this.description = description;
        this.dob = dob;
        this.vaccineDesp = vaccineDesp;
        this.price = price;
    }

    public tbl_PetDTO() {
    }

    public String getPetID() {
        return petID;
    }

    public void setPetID(String petID) {
        this.petID = petID;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public String getVaccineDesp() {
        return vaccineDesp;
    }

    public void setVaccineDesp(String vaccineDesp) {
        this.vaccineDesp = vaccineDesp;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
