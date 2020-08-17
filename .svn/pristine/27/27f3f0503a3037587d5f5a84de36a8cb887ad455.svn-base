
/**
 * ====================================================================
 * Created by nima.yoezer on 23-Sep-18.
 * Description:
 * ====================================================================
 * Modified by:
 * Modified date:
 * Purpose:
 * ====================================================================
 */
package rma.org.bt.mms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import rma.org.bt.mms.login.log.UserLogService;
import rma.org.bt.mms.login.login.LoginDTO;
import rma.org.bt.mms.login.login.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserLogService logService;
    //region public method
    public LoginFailureHandler(String defaultFailureUrl) {
        this.setDefaultFailureUrl(defaultFailureUrl);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        super.onAuthenticationFailure(request, response, exception);



        if (exception instanceof BadCredentialsException) {
            String username = request.getParameter("username");
            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setUserName(username);
            //String workStationIp = request.getRemoteAddr();
            logService.save(request,loginDTO,0);
        }
    }
    //endregion
}
