/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest.model;

import javax.persistence.Entity;
import org.picketlink.idm.jpa.annotations.RelationshipClass;
import org.picketlink.idm.jpa.annotations.entity.IdentityManaged;
import org.picketlink.idm.model.Relationship;

/**
 *
 * @author jpicklyk
 */
@IdentityManaged(value = {Relationship.class})
@Entity
public class RelationshipTypeEntity extends AttributedTypeEntity{
    
    @RelationshipClass
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    
}
