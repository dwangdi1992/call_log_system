/**
 * ====================================================================
 * Created by nima.yoezer on 23-Sep-18.
 * Description:
 * ====================================================================
 * Modified by:Dechen Wangdi
 * Modified date: 14-02-2020
 * Purpose:
 * ====================================================================
 */
package rma.org.bt.mms.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import rma.org.bt.mms.login.login.LoginDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    //region public method
    public LogoutSuccessHandler(String defaultTargetUrl) {
        this.setDefaultTargetUrl(defaultTargetUrl);
    }


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        super.onLogoutSuccess(request, response, authentication);
        LoginDTO user = (LoginDTO) authentication.getPrincipal();

        HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("user");
        }
    }
    //endregion
}
