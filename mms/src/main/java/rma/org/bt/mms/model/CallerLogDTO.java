package rma.org.bt.mms.model;

import java.util.Date;

public class CallerLogDTO {

    private Integer id;

    private Date date;

    private String dateText;

    private String supper_zone;

    private String zone;

    private String query;

    private String unusual_question;

    private String contact_no;

    private Integer status;

    private String call_attend_by;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateText() {
        return dateText;
    }

    public void setDateText(String dateText) {
        this.dateText = dateText;
    }

    public String getSupper_zone() {
        return supper_zone;
    }

    public void setSupper_zone(String supper_zone) {
        this.supper_zone = supper_zone;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getUnusual_question() {
        return unusual_question;
    }

    public void setUnusual_question(String unusual_question) {
        this.unusual_question = unusual_question;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCall_attend_by() {
        return call_attend_by;
    }

    public void setCall_attend_by(String call_attend_by) {
        this.call_attend_by = call_attend_by;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}