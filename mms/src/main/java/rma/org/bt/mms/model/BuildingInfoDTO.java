package rma.org.bt.mms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BuildingInfoDTO implements Serializable {

    //region private variables.
    private String searchKey;
    private String name;
    private String category; //Urban or Rural
    private String houseNo;
    private String ownership;
    private String type;
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

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    //endregion
}
