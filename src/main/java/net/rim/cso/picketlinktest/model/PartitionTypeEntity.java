/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest.model;

import javax.persistence.Entity;

import org.picketlink.idm.jpa.annotations.AttributeValue;
import org.picketlink.idm.jpa.annotations.PartitionClass;
import org.picketlink.idm.jpa.annotations.entity.ConfigurationName;
import org.picketlink.idm.jpa.annotations.entity.IdentityManaged;
import org.picketlink.idm.model.Partition;

/**
 * 
 * @author jpicklyk
 */
@IdentityManaged(value = { Partition.class })
@Entity
public class PartitionTypeEntity extends AttributedTypeEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6030903675260401166L;
	@AttributeValue
	private String name;
	@PartitionClass
	private String typeName;
	@ConfigurationName
	private String configurationName;

	public PartitionTypeEntity() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getConfigurationName() {
		return configurationName;
	}

	public void setConfigurationName(String configurationName) {
		this.configurationName = configurationName;
	}

}
