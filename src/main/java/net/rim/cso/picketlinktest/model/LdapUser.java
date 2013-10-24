/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest.model;

import org.picketlink.idm.model.annotation.AttributeProperty;
import org.picketlink.idm.model.basic.User;

/**
 * 
 * @author jpicklyk
 */
public class LdapUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3421992022166624061L;
	private String fullName;

	public LdapUser() {
		this(null);
	}

	public LdapUser(final String loginName) {
		super(loginName);
	}

	@AttributeProperty
	public String getFullName() {
		if (this.fullName == null) {
			this.fullName = getFirstName() + " " + getLastName();
		}
		return fullName;
	}

	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

}
