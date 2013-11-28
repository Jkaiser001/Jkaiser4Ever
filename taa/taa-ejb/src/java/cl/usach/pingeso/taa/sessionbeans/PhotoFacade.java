/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.usach.pingeso.taa.sessionbeans;

import cl.usach.pingeso.taa.entityclasses.Photo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author José Orellana
 */
@Stateless
public class PhotoFacade extends AbstractFacade<Photo> implements PhotoFacadeLocal {
    @PersistenceContext(unitName = "taa-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PhotoFacade() {
        super(Photo.class);
    }
    
}
