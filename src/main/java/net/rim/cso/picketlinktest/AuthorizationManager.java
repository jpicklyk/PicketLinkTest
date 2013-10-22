/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import static net.rim.cso.picketlinktest.HybridModel.getRole;
import org.picketlink.Identity;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.model.Account;
import org.picketlink.idm.model.basic.Role;

/**
 *
 * @author jpicklyk
 */
@ApplicationScoped
@Named
public class AuthorizationManager {
    @Inject
    private Instance<Identity> identityInstance;

    @Inject
    private IdentityManager identityManager;

    @Inject
    private RelationshipManager relationshipManager;

    public boolean isRisksManagementAllowed() {
        return isAdministrator() || (isProjectManager());
    }

    public boolean isTimesheetAllowed() {
        return isAdministrator() || (isProjectManager() || isDeveloper());
    }

    public boolean isSystemAdministrationAllowed() {
        return isAdministrator();
    }

    public boolean isProjectManager() {
        return hasRole(ApplicationRole.PROJECT_MANAGER);
    }

    public boolean isAdministrator() {
        return hasRole(ApplicationRole.ADMINISTRATOR);
    }

    public boolean isDeveloper() {
        return hasRole(ApplicationRole.DEVELOPER);
    }

    private Identity getIdentity() {
        return this.identityInstance.get();
    }

    /**
     * <p>Checks if the current user is granted with the given role.</p>
     *
     * @param applicationRole
     * @return
     */
    private boolean hasRole(ApplicationRole applicationRole) {
        Account agent = getIdentity().getAccount();
        Role role = getRole(this.identityManager, applicationRole.name());

        return HybridModel.hasRole(this.relationshipManager, agent, role);
    }
}
