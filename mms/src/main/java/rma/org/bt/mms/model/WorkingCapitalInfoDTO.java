package rma.org.bt.mms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WorkingCapitalInfoDTO implements Serializable {

    //region private variables.
    private String accountNo;
    private String sectorType;
    private Date sanctionDate;
    private BigDecimal sanctionAmt;
    private BigDecimal outstandingAmt;
    private String finInstitution;
    //endregion


    //region getter and setter.
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getSectorType() {
        return sectorType;
    }

    public void setSectorType(String sectorType) {
        this.sectorType = sectorType;
    }

    public Date getSanctionDate() {
        return sanctionDate;
    }

    public void setSanctionDate(Date sanctionDate) {
        this.sanctionDate = sanctionDate;
    }

    public BigDecimal getSanctionAmt() {
        return sanctionAmt;
    }

    public void setSanctionAmt(BigDecimal sanctionAmt) {
        this.sanctionAmt = sanctionAmt;
    }

    public BigDecimal getOutstandingAmt() {
        return outstandingAmt;
    }

    public void setOutstandingAmt(BigDecimal outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    public String getFinInstitution() {
        return finInstitution;
    }

    public void setFinInstitution(String finInstitution) {
        this.finInstitution = finInstitution;
    }
    //endregion
}
