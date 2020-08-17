package rma.org.bt.mms.model;

/**
 * ==================================================================================
 * Created by user on 3/7/2020.
 * Description:
 * Modified by:
 * Reason :
 * ==================================================================================
 */
public class PersonalInfoDTO {
    private String cidNo;
    private String fullName;
    private String sex;
    private String dzongkhagId;
    private String gowegId;
    private String villageId;
    private String dzongkhagNmae;
    private String gowegName;
    private String villageName;

    public String getCidNo() {
        return cidNo;
    }

    public void setCidNo(String cidNo) {
        this.cidNo = cidNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDzongkhagId() {
        return dzongkhagId;
    }

    public void setDzongkhagId(String dzongkhagId) {
        this.dzongkhagId = dzongkhagId;
    }

    public String getGowegId() {
        return gowegId;
    }

    public void setGowegId(String gowegId) {
        this.gowegId = gowegId;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getDzongkhagNmae() {
        return dzongkhagNmae;
    }

    public void setDzongkhagNmae(String dzongkhagNmae) {
        this.dzongkhagNmae = dzongkhagNmae;
    }

    public String getGowegName() {
        return gowegName;
    }

    public void setGowegName(String gowegName) {
        this.gowegName = gowegName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}
