/**
 * Component Name: Department of Road
 * Name: UserLoginService
 * Description: See the description at the top of class declaration
 * Project: Ascend Financial Solution
 * @author: Yonten.Choden
 * Creation: 04-May-2016
 * @version: 1.0.0
 * @since 2016
 * Language: Java 1.8.0_20
 * Copyright: (C) 2016, Southtech Limited
 */
package rma.org.bt.mms.login.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService {
    //region private dao
    @Autowired
    LoginDao loginDao;
    //endregion

    //region public method

    /**
     * to get user information while logging in.
     *
     * @param username username
     * @return LoginDTO
     */
    public LoginDTO login(String username) {
        return loginDao.login(username);
    }



}
