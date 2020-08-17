package rma.org.bt.mms.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import rma.org.bt.mms.global.enumeration.LoginErrorCode;
import rma.org.bt.mms.login.login.LoginDTO;
import rma.org.bt.mms.login.login.LoginService;
import rma.org.bt.mms.master.permission.PermissionListDTO;
import rma.org.bt.mms.master.permission.PermissionSetupService;

import java.util.*;


public class WebAuthenticationProvider implements AuthenticationProvider {

    final static Integer INACTIVE_USER = 0;
    //region private variable
    @Autowired
    private PasswordEncoder passwordEncoder;
    //endregion

    //region private service
    @Autowired
    private LoginService loginService;

    @Autowired
    private PermissionSetupService permissionSetupService;
    //endregion

    //region setter
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    //endregion


    //region public method

    /**
     * It processes authentication information
     *
     * @param authentication authentication
     * @return Authentication
     * @throws org.springframework.security.core.AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;

        String username = String.valueOf(auth.getPrincipal());
        String password = String.valueOf(auth.getCredentials());

        LoginDTO userLogin = loginService.login(username);
        if (userLogin == null) {
            throw new UsernameNotFoundException(LoginErrorCode.FAILED.getCode());
        } else if (userLogin.getUserStatus().equals(INACTIVE_USER.toString())) {
            throw new LockedException(LoginErrorCode.LOCKED.getCode());
        } else if (Objects.equals(userLogin.getGroupStatus(), INACTIVE_USER)) {
            throw new LockedException(LoginErrorCode.LOCKED.getCode());
        } else if (userLogin.getValidityDate().before(new Date())) {
            throw new LockedException(LoginErrorCode.EXPIRED.getCode());
        } else if (passwordEncoder.matches(password, userLogin.getPassword())) {
//        } else if (true) {
            Set<GrantedAuthority> authorities = getAccessRight(userLogin.getGroupId());
            return new UsernamePasswordAuthenticationToken(userLogin, password, authorities);
        } else {
            throw new BadCredentialsException(LoginErrorCode.FAILED.getCode());
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UsernamePasswordAuthenticationToken.class);
    }

    /**
     * It supplies authorization information according to user group
     *
     * @param userGroupId --    Integer
     * @return Set
     */
    private Set<GrantedAuthority> getAccessRight(Integer userGroupId) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        List<PermissionListDTO> permissionListDTOs = permissionSetupService.getPermissionList(userGroupId);

        permissionListDTOs.forEach(permission -> {
            String access = permission.getScreenId() + "-";

            if (permission.getIsView() == 'Y') {
                authorities.add(new SimpleGrantedAuthority(access + "VIEW"));
            }

            if (permission.getIsSave() == 'Y') {
                authorities.add(new SimpleGrantedAuthority(access + "ADD"));
            }

            if (permission.getIsEdit() == 'Y') {
                authorities.add(new SimpleGrantedAuthority(access + "EDIT"));
            }

            if (permission.getIsDelete() == 'Y') {
                authorities.add(new SimpleGrantedAuthority(access + "DELETE"));
            }
        });
        return authorities;
    }
    //endregion
}
