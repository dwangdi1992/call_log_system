package rma.org.bt.mms.master.permission;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rma.org.bt.mms.global.base.BaseDao;

import java.math.BigDecimal;
import java.util.List;

/**
 * ====================================================================
 * Created by Dechen Wangdi on 20/12/2019.
 * Description:
 * ====================================================================
 * Modified by:
 * Modified date:
 * Purpose:
 * ====================================================================
 */
@Repository
public class PermissionSetupDao extends BaseDao {

    @Transactional(readOnly = true)
    public BigDecimal getNextPermissionId() {
        sqlQuery = properties.getProperty("PermissionSetupDao.getNextPermissionId");
        Query hQuery = hibernateQuery(sqlQuery);
        return hQuery.list().isEmpty() ? BigDecimal.ONE : (BigDecimal) hQuery.list().get(0);
    }

    @Transactional
    public void save(PermissionSetup permissionSetup) {
        saveOrUpdate(permissionSetup);
    }

    @Transactional
    public void delete(PermissionSetup permissionSetup) {
        permissionSetup = em.find(PermissionSetup.class, permissionSetup.getPermissionId());
        em.remove(permissionSetup);
    }

    @Transactional(readOnly = true)
    public List getPermissionList(Integer groupId, Integer status) {
        sqlQuery = properties.getProperty("PermissionSetupDao.getPermissionList");
        Query hQuery = hibernateQuery(sqlQuery, PermissionListDTO.class);
        hQuery.setParameter("groupId", groupId).setParameter("status", status);
        return hQuery.list();
    }

    @Transactional(readOnly = true)
    public BigDecimal getPermissionId(Integer groupId, String screenId) {
        sqlQuery = properties.getProperty("PermissionSetupDao.getPermissionId");
        Query hQuery = hibernateQuery(sqlQuery);
        hQuery.setParameter("groupId", groupId);
        hQuery.setParameter("screenId", screenId);
        return hQuery.list().isEmpty() ? null : (BigDecimal) hQuery.list().get(0);
    }
}
