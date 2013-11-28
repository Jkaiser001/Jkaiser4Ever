/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usach.pingeso.taa.managedbeans.student;

import cl.usach.pingeso.taa.entityclasses.Student;
import cl.usach.pingeso.taa.entityclasses.User;
import cl.usach.pingeso.taa.sessionbeans.StudentFacadeLocal;
import cl.usach.pingeso.taa.sessionbeans.UserFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import cl.usach.pingeso.taa.utils.General;

/**
 *
 * @author Diego
 */
@Named(value = "studentRegister")
@RequestScoped
public class StudentRegister {
    @EJB
    private UserFacadeLocal userFacade;
    @EJB
    private StudentFacadeLocal studentFacade;
    private Integer rut;
    private String name1;
    private String name2;
    private String lastNameP;
    private String lastNameM;
    private String email;
    
    public StudentRegister() {
    }
    
    public void studentRegisterNow() {
        try {
            User newUser = new User();
            newUser.setRut(rut);
            newUser.setName1(name1);
            newUser.setName2(name2);
            newUser.setLastnamep(lastNameP);
            newUser.setLastnamem(lastNameM);
            newUser.setMail(email);
            userFacade.create(newUser);
            Student newStudent = new Student(rut);
            studentFacade.create(newStudent);
            General.viewMessage(FacesMessage.SEVERITY_INFO,
                    "Alumno registrado satisfactorimante!!!",
                    "Alumno registrado satisfactorimante!!!");
            General.goToPage("/faces/studentRegister.xhtml?faces-redirect=true");
        }
        catch (Exception e) {
            General.viewMessage(FacesMessage.SEVERITY_ERROR, 
                    e.getMessage(), 
                    e.getMessage());
            General.goToPage("/faces/studentRegister.xhtml?faces-redirect=true");
        }
    }
    
    public StudentFacadeLocal getStudentFacade() {
        return studentFacade;
    }

    public void setStudentFacade(StudentFacadeLocal studentFacade) {
        this.studentFacade = studentFacade;
    }

    public UserFacadeLocal getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacadeLocal userFacade) {
        this.userFacade = userFacade;
    }

    public Integer getRut() {
        return rut;
    }
    
    public void setRut(Integer rut) {
        this.rut = rut;
    }
    
    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }
    
    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getLastNameP() {
        return lastNameP;
    }

    public void setLastNameP(String lastNameP) {
        this.lastNameP = lastNameP;
    }

    public String getLastNameM() {
        return lastNameM;
    }

    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }  
}