/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest.model;

import javax.persistence.Entity;

import org.picketlink.idm.jpa.annotations.AttributeValue;
import org.picketlink.idm.jpa.annotations.entity.IdentityManaged;
import org.picketlink.idm.model.basic.Role;

/**
 * 
 * @author jpicklyk
 */
@IdentityManaged(value = { Role.class })
@Entity
public class RoleTypeEntity extends IdentityTypeEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4006248368163927779L;
	@AttributeValue
	private String name;

	public RoleTypeEntity() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
