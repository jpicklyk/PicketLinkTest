/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.picketlink.Identity;
import org.picketlink.idm.IdentityManager;

/**
 *
 * @author jpicklyk
 */
@Named
@RequestScoped
public class LoginController {
    @Inject
    private Identity identity;
    
    @Inject
    private IdentityManager identityManager;
    
    public void test() {
        System.out.println();
    }
    
    public String login() {
        // let's authenticate the user. the credentials were provided by populating the <code>loginCredentials</code>
        // named bean directly.
        this.identity.login();

        String result = null;
        //User user = BasicModel.getUser(identityManager, "jpicklyk");
        
        if (this.identity.isLoggedIn()) {
            result = "/home.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    "Authentication was unsuccessful.  Please check your username and password " + "before trying again."));
        }

        return result;
    }
    
    public String logout() {
        this.identity.logout();
        return "/login.xhtml";
    }
}
