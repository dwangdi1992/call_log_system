package rma.org.bt.mms.master.passwordPolicy;

import rma.org.bt.mms.global.base.BaseDao;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sangay Tenzin on 12/20/2019.
 */

@Repository
public class PasswordPolicyDao extends BaseDao {

    @Transactional(rollbackFor = Exception.class)
    public void save(PasswordPolicy passwordPolicy) {
        saveOrUpdate(passwordPolicy);
    }

    @Transactional(readOnly = true)
    public PasswordPolicyDTO getPasswordPolicyInfo() {
        String sqlQuery = properties.getProperty("PasswordPolicyDao.getPasswordPolicyInfo");
        Query hQuery = hibernateQuery(sqlQuery, PasswordPolicyDTO.class);
        return hQuery.list().isEmpty() ? null : (PasswordPolicyDTO) hQuery.uniqueResult();
    }
}

