package rma.org.bt.mms.master.cPassword;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rma.org.bt.mms.global.base.BaseDao;
import rma.org.bt.mms.master.user.UserSetup;

/**
 * ====================================================================
 * Created by Dechen Wangdi
 * Description:
 * SQL Query in common.ora.sql
 * ====================================================================
 * Modified by:
 * Modified date:
 * Purpose:
 * ====================================================================
 */
@Repository
public class ChangePasswordDao extends BaseDao {

    @Transactional(readOnly = false)
    public void changePassword(String userName, String password) {
        sqlQuery = properties.getProperty("ChangePasswordDao.changePassword");
        Query hQuery = hibernateQuery(sqlQuery)
                .setParameter("userName", userName)
                .setParameter("password", password);
        hQuery.executeUpdate();
    }

    @Transactional(readOnly = false)
    public String getPassword(String userName) {
        UserSetup userSetup = em.find(UserSetup.class, userName);
        return ((userSetup == null) ? null : userSetup.getPassword());
    }
}
