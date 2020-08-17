package rma.org.bt.mms.login.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rma.org.bt.mms.login.login.LoginDTO;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ====================================================================
 * Created by Dechen Wangdi on 2/8/2020.
 * Description:
 * ====================================================================
 * Modified by:
 * Modified on:
 * Changes made :
 * ====================================================================
 */
@Service
public class UserLogService {

    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d MMM, yyyy - h:mm a");

    @Autowired
    private UserLogDao userLogDao;


    @Transactional(readOnly = false)
    public void save(HttpServletRequest request, LoginDTO loginDTO, int isLoginSuccess) {
        LocalDateTime now = LocalDateTime.now();
        UserLog userLog = new UserLog();
        userLog.setUserName(loginDTO.getUserName());
        userLog.setIsLoginSuccess(isLoginSuccess);
        userLog.setUserLoginTime(dateFormat.format(now));
        userLog.setWorkStation(request.getRemoteAddr());
        userLogDao.save(userLog);
    }

    /**
     * To update logout time.
     *
     * @param request HttpServletRequest.
     */
    public void update(HttpServletRequest request) {
        LoginDTO loginDTO = (LoginDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LocalDateTime now = LocalDateTime.now();
        String userName = loginDTO.getUserName();
        Integer logID = userLogDao.getLogID(userName);
        userLogDao.update(userName, logID, dateFormat.format(now));
    }
}
