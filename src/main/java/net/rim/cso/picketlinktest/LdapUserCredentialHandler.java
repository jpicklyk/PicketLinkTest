/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest;

import java.util.List;

import net.rim.cso.picketlinktest.model.LdapUser;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.ldap.internal.LDAPPlainTextPasswordCredentialHandler;
import org.picketlink.idm.model.Account;
import org.picketlink.idm.query.IdentityQuery;
import org.picketlink.idm.spi.IdentityContext;

/**
 * 
 * @author jpicklyk
 */
@SuppressWarnings("rawtypes")
public class LdapUserCredentialHandler extends
		LDAPPlainTextPasswordCredentialHandler {

	@Override
	protected Account getAccount(IdentityContext context, String loginName) {
		IdentityManager identityManager = getIdentityManager(context);
		IdentityQuery<LdapUser> query = identityManager
				.createIdentityQuery(LdapUser.class);

		query.setParameter(LdapUser.LOGIN_NAME, loginName);

		List<LdapUser> result = query.getResultList();

		if (result.isEmpty()) {
			return null;
		}

		return result.get(0);
	}
}
