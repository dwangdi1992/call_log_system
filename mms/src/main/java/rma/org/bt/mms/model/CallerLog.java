package rma.org.bt.mms.model;


import org.joda.time.DateTime;
import rma.org.bt.mms.global.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "caller_log")
public class CallerLog extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "supper_zone")
    private String supper_zone;

    @Column(name = "zone")
    private String zone;

    @Column(name = "query")
    private String query;

    @Column(name = "unusual_question")
    private String unusual_question;

    @Column(name = "contact_no")
    private String contact_no;

    @Column(name = "caller_name")
    private String caller_name;

    @Column(name = "status")
    private Integer status;

    @Column(name = "call_attend_by")
    private String call_attend_by;

    @Column(name = "remark")
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

    public String getCaller_name() {
        return caller_name;
    }

    public void setCaller_name(String caller_name) {
        this.caller_name = caller_name;
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
