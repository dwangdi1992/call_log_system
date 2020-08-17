package rma.org.bt.mms.login.login;

import rma.org.bt.mms.global.base.BaseDao;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("loginDao")
public class LoginDao extends BaseDao {

    //region private variables
    private Query hQuery;
    //endregion

    //region public method

    /**
     * to get the user information while logging in.
     *
     * @param username username
     * @return UserSetupDTO
     */
    @Transactional(readOnly = true)
    public LoginDTO login(String username) {
        sqlQuery = properties.getProperty("LoginDao.login");
        hQuery = hibernateQuery(sqlQuery, LoginDTO.class);
        hQuery.setParameter("username", username);
        List list = hQuery.list();
        return (LoginDTO) (list.isEmpty() ? null : list.get(0));
    }
    //endregion

}
