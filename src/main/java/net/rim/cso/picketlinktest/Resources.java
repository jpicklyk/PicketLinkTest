/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.rim.cso.picketlinktest;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.picketlink.annotations.PicketLink;

/**
 * 
 * @author jpicklyk
 */
@Stateless
public class Resources {

	@PersistenceContext(unitName = "idmPU", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Produces
	@PicketLink
	public EntityManager producePLEntityManager() {
		return em;
	}

}
