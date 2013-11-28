/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usach.pingeso.taa.managedbeans.student;

import cl.usach.pingeso.taa.entityclasses.Attendance;
import cl.usach.pingeso.taa.entityclasses.User;
import cl.usach.pingeso.taa.sessionbeans.AttendanceFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
/**
 *
 * @author Nico
 */
@Named(value = "attendanceStudents")
@RequestScoped
public class AttendanceStudents {
    @EJB
    private AttendanceFacadeLocal attendanceFacade;
    private List<Attendance> attendanceList;
    private User selectedUser;
    private List<User> filteredUsers;
    private final static String[] states;
    
     static {  
        states = new String[3];  
        states[0] = "N";  
        states[1] = "S";
        states[2] = "J";
    }
     
    @PostConstruct
    public void init()
    {
        attendanceList = attendanceFacade.findAll();
    }
    
    public AttendanceStudents(){ 
    }
    
    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }
    
    public String[] getStates() {  
        return states;  
    }
    
    public void setAttendance(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }
    
    public User getSelectedUser() {  
        return selectedUser;  
    }  
  
    public void setSelectedUser(User selectedUser) {  
        this.selectedUser = selectedUser;  
    }
    
    public void onCellEdit(CellEditEvent event) {  
        Object oldValue = event.getOldValue();  
        Object newValue = event.getNewValue();  
        if(newValue != null && !newValue.equals(oldValue)) {  
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "La asistencia ha sido modificada", "Antes: " + oldValue + ", Ahora:" + newValue);  
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        }  
    }

    public List<User> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(List<User> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }
}