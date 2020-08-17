package rma.org.bt.mms.master.user;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rma.org.bt.mms.global.base.BaseDao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * =====================================================================================
 * Created by Dechen Wangdi on 20/12/2019.
 * User setup Dao to save or retrieve values from db
 * =====================================================================================
 */
@Repository
public class UserSetupDao extends BaseDao {

    private String sqlQuery;

    @Transactional
    public void save(UserSetup userSetup) {
        saveOrUpdate(userSetup);
    }

    @Transactional(readOnly = true)
    public List<UserSetupDTO> getUserList(Integer status) {
        sqlQuery = properties.getProperty("UserSetupDao.getUserList");
        Query hQuery = hibernateQuery(sqlQuery, UserSetupDTO.class)
                .setParameter("status", status);
        return hQuery.list();
    }

    @Transactional(readOnly = true)
    public BigDecimal getNextUserId() {
        sqlQuery = properties.getProperty("UserSetupDao.getNextUserId");
        Query hQuery = hibernateQuery(sqlQuery);
        return hQuery.list().isEmpty() ? BigDecimal.ONE : (BigDecimal) hQuery.list().get(0);
    }

    @Transactional(readOnly = true)
    public UserSetup getUser(String userName) {
        return em.find(UserSetup.class, userName);
    }

    @Transactional(readOnly = true)
    public UserSetupDTO getUserByUsername(String username) {
        sqlQuery = properties.getProperty("UserSetupDao.getUserByUsername");
        Query hQuery = hibernateQuery(sqlQuery, UserSetupDTO.class)
                .setParameter("username", username);
        return hQuery.list().isEmpty() ? null : (UserSetupDTO) hQuery.list().get(0);
    }

    @Transactional
    public void updateIsBadCredentialStatus(Date date, String userName) {
        sqlQuery = properties.getProperty("UserSetupDao.updateIsBadCredentialStatus");
        Query hQuery = hibernateQuery(sqlQuery)
                .setParameter("userName", userName)
                .setParameter("date", date)
                .setParameter("isBadCredential", Boolean.FALSE);
        hQuery.executeUpdate();
    }
}
