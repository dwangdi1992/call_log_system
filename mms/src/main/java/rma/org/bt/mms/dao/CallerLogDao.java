package rma.org.bt.mms.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rma.org.bt.mms.global.base.BaseDao;
import rma.org.bt.mms.global.dto.DropdownDTO;
import rma.org.bt.mms.global.dto.ResponseMessage;
import rma.org.bt.mms.master.user.UserSetupDTO;
import rma.org.bt.mms.model.CallerLog;
import rma.org.bt.mms.model.CallerLogDTO;

import java.util.List;

@Repository
public class CallerLogDao extends BaseDao {

    @Transactional(readOnly = true)
    public List<DropdownDTO> getSuperZoneList() {
        sqlQuery = properties.getProperty("CallerLogDao.getSuperZoneList");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list();
    }

    @Transactional(readOnly = true)
    public List<DropdownDTO> getZoneList() {
        sqlQuery = properties.getProperty("CallerLogDao.getZoneList");
        Query hQuery = hibernateQuery(sqlQuery, DropdownDTO.class);
        return hQuery.list();
    }

    @Transactional
    public void save(CallerLog callerLog) {
        em.persist(callerLog);
    }

    @Transactional(readOnly = true)
    public List<CallerLogDTO> getCallerLogList(String userName) {
        sqlQuery = properties.getProperty("CallerLogDao.getCallerLogList");
        Query hQuery = hibernateQuery(sqlQuery, CallerLogDTO.class)
                .setParameter("userName", userName);
        return hQuery.list();
    }
}
