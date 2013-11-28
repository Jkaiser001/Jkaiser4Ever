/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.usach.pingeso.taa.sessionbeans;

import cl.usach.pingeso.taa.entityclasses.Photo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author José Orellana
 */
@Local
public interface PhotoFacadeLocal {

    void create(Photo photo);

    void edit(Photo photo);

    void remove(Photo photo);

    Photo find(Object id);

    List<Photo> findAll();

    List<Photo> findRange(int[] range);

    int count();
    
}
