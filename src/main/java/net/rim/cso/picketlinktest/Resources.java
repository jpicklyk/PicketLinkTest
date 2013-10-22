/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest;

import javax.ejb.Stateless;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.picketlink.annotations.PicketLink;

/**
 *
 * @author jpicklyk
 */
@Stateless
public class Resources {
    
    @PersistenceContext(unitName = "idmPU")
    private EntityManager em;
    
    @Produces
    @PicketLink    
    public EntityManager producePLEntityManager() {
        return em;
    }
    
    public void closeEntityManager(@Disposes EntityManager em) {
        if(em.isOpen()) {
            em.close();
        }
    }
}
