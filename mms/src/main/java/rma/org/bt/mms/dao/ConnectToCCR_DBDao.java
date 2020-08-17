package rma.org.bt.mms.dao;

import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import rma.org.bt.mms.global.base.BaseDaoCCR;
import rma.org.bt.mms.model.WorkingCapitalInfoDTO;

import java.util.List;

/**
 * ====================================================================
 * Created by Nima Yoezer on 6/29/2020.
 * Description:
 * ====================================================================
 * Modified by:
 * Modified on:
 * Changes made :
 * ====================================================================
 */
public class ConnectToCCR_DBDao extends BaseDaoCCR{

    @Transactional(readOnly = true)
    public List<WorkingCapitalInfoDTO> getWorkingCapitalData(String searchKey) {
        sqlQuery = properties.getProperty("KiduDao.getKiduInfo");
        Query hQuery = hibernateQuery(sqlQuery, WorkingCapitalInfoDTO.class).setParameter("searchKey", searchKey);
        return hQuery.list();
    }

}
