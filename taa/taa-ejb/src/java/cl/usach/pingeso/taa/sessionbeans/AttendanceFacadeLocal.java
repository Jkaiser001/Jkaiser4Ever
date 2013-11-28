/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.usach.pingeso.taa.sessionbeans;

import cl.usach.pingeso.taa.entityclasses.Attendance;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author José Orellana
 */
@Local
public interface AttendanceFacadeLocal {

    void create(Attendance attendance);

    void edit(Attendance attendance);

    void remove(Attendance attendance);

    Attendance find(Object id);

    List<Attendance> findAll();

    List<Attendance> findRange(int[] range);

    int count();
    
}
