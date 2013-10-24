/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.picketlink.idm.jpa.annotations.OwnerReference;
import org.picketlink.idm.jpa.annotations.RelationshipDescriptor;
import org.picketlink.idm.jpa.annotations.RelationshipMember;

/**
 * 
 * @author jpicklyk
 */
@Entity
public class RelationshipIdentityTypeReferenceEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7410728769384910006L;

	@Id
	@GeneratedValue
	private Long id;

	@RelationshipDescriptor
	private String descriptor;

	@RelationshipMember
	private String identityTypeId;

	@OwnerReference
	@ManyToOne
	private RelationshipTypeEntity owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public String getIdentityTypeId() {
		return identityTypeId;
	}

	public void setIdentityTypeId(String identityType) {
		this.identityTypeId = identityType;
	}

	public RelationshipTypeEntity getOwner() {
		return owner;
	}

	public void setOwner(RelationshipTypeEntity owner) {
		this.owner = owner;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!getClass().isInstance(obj)) {
			return false;
		}

		AttributedTypeEntity other = (AttributedTypeEntity) obj;

		return getId() != null && other.getId() != null
				&& getId().equals(other.getId());
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getId() != null ? getId().hashCode() : 0);
		return result;
	}
}
