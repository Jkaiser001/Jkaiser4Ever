/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.usach.pingeso.taa.sessionbeans;

import cl.usach.pingeso.taa.entityclasses.Attendance;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author José Orellana
 */
@Stateless
public class AttendanceFacade extends AbstractFacade<Attendance> implements AttendanceFacadeLocal {
    @PersistenceContext(unitName = "taa-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AttendanceFacade() {
        super(Attendance.class);
    }
    
}
