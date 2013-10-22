/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest;

import javax.ejb.Stateful;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.picketlink.annotations.PicketLink;

/**
 *
 * @author jpicklyk
 */
@Stateful
public class Resources {
    
    @PersistenceContext(unitName = "idmPU")
    private EntityManager picketLinkEntityManager;
    
    @Produces
    @PicketLink
    public EntityManager producePLEntityManager() {
        return picketLinkEntityManager;
    }
}
