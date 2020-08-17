/**
 * ====================================================================
 * Created by nima.yoezer on 23-Sep-18.
 * Description:
 * ====================================================================
 * Modified by: Dechen Wangdi
 * Modified date:08/02/2020
 * Purpose:
 * ====================================================================
 */
package rma.org.bt.mms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import rma.org.bt.mms.login.log.UserLogService;
import rma.org.bt.mms.login.login.LoginDTO;
import rma.org.bt.mms.login.login.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private UserLogService logService;

    //region public method
    public LoginSuccessHandler(String defaultTargetUrl) {
        this.setDefaultTargetUrl(defaultTargetUrl);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LoginDTO loginDTO = (LoginDTO) auth.getPrincipal();

        //To keep login record.
        logService.save(request, loginDTO,1);
        super.onAuthenticationSuccess(request, response, authentication);
    }
    //endregion
}
