package rma.org.bt.mms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BusinessInfoDTO implements Serializable {

    //region private variables.
    private String searchKey;
    private String name;
    private String licenseTyp;
    private BigDecimal amount;
    private BigDecimal maturityAmt;
    private String finInstitution;
    //endregion
}
