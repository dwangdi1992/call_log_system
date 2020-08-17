package rma.org.bt.mms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LandInfoDTO implements Serializable {

    //region private variables.
    private String searchKey;
    private String name;
    private String category; //Urban or rural area.
    private String thramNo;
    private String ownership;
    private Float size;
    private String location;
    //endregion


    //region getter and setter.
    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThramNo() {
        return thramNo;
    }

    public void setThramNo(String thramNo) {
        this.thramNo = thramNo;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    //endregion
}
