/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.picketlink.idm.jpa.annotations.Identifier;

/**
 * 
 * @author jpicklyk
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AttributedTypeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3122791403798423979L;
	@Id
	@Identifier
	private String id;

	public AttributedTypeEntity() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
