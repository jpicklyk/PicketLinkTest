/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import org.picketlink.idm.jpa.annotations.AttributeValue;
import org.picketlink.idm.jpa.annotations.IdentityClass;
import org.picketlink.idm.jpa.annotations.OwnerReference;
import org.picketlink.idm.jpa.annotations.entity.IdentityManaged;
import org.picketlink.idm.model.IdentityType;

/**
 * 
 * @author jpicklyk
 */
@IdentityManaged(value = { IdentityType.class })
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class IdentityTypeEntity extends AttributedTypeEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4496093095391981505L;
	@IdentityClass
	private String typeName;
	@AttributeValue
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date createdDate;
	@AttributeValue
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date expirationDate;
	@AttributeValue
	private boolean enabled;
	@OwnerReference
	@ManyToOne
	private PartitionTypeEntity partition;

	public IdentityTypeEntity() {
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public PartitionTypeEntity getPartition() {
		return partition;
	}

	public void setPartition(PartitionTypeEntity partition) {
		this.partition = partition;
	}

}
