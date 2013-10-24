/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.picketlink.idm.jpa.annotations.AttributeClass;
import org.picketlink.idm.jpa.annotations.AttributeName;
import org.picketlink.idm.jpa.annotations.AttributeValue;
import org.picketlink.idm.jpa.annotations.OwnerReference;

/**
 * 
 * @author jpicklyk
 */
@Entity
public class AttributeReferenceTypeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2357231685496693389L;

	@Id
	@GeneratedValue
	private Long id;

	@OwnerReference
	private String owner;

	@AttributeClass
	private String typeName;

	@AttributeName
	private String name;

	@AttributeValue
	@Column(length = 1024)
	private String attributeValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
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
