package org.edge.woostore.core.security;

import javax.security.auth.Subject;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/26.
 */
public class SecurityContextAuthorizer implements SecurityContext {
    private Principal principal;//表达一个主体的抽象的作用，这里是登录账号
    private javax.inject.Provider<UriInfo> uriInfo;
    private Set<String> roles;
    public SecurityContextAuthorizer(final javax.inject.Provider<UriInfo> uriInfo, final Principal principal, final String[] roles) {
        this.principal = principal;
        if (principal == null) {
            this.principal = new Principal() {
                @Override
                public String getName() {
                    return "anonymous";
                }

                public boolean implies(Subject subject) {
                    return true;
                }
            };
        }
        this.uriInfo = uriInfo;
        this.roles = new HashSet<>(Arrays.asList((roles != null) ? roles : new String[]{}));
    }
    public Principal getUserPrincipal() {
        return this.principal;
    }

    public boolean isUserInRole(String role) {
        return this.roles.contains(((role == null) ? "" : role));
    }//这里没有角色这一说，如果有就返回true

    public boolean isSecure() {
        return "https".equals(uriInfo.get().getRequestUri().getScheme());
    }

    public String getAuthenticationScheme() {
        return SecurityContext.DIGEST_AUTH;
    }
}

