package com.corefit.control.security;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import com.corefit.model.entity.business.User;

@ManagedBean
@SessionScoped
public class UserControl implements Serializable {

    /**
     * Serialization
     */
    private static final long serialVersionUID = 4846844490675197612L;
    
    private User user;

    public UserControl() {
        user = new User();
        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext) {
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) {
                user.setLogin(((org.springframework.security.core.userdetails.User) authentication.getPrincipal())
                        .getUsername());
            }
        }
       // TODO: Ir ao banco e buscar todos os dados do usuario logado
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
