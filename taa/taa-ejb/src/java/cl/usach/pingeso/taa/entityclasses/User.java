/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.usach.pingeso.taa.entityclasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author José Orellana
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByRut", query = "SELECT u FROM User u WHERE u.rut = :rut"),
    @NamedQuery(name = "User.findByName1", query = "SELECT u FROM User u WHERE u.name1 = :name1"),
    @NamedQuery(name = "User.findByName2", query = "SELECT u FROM User u WHERE u.name2 = :name2"),
    @NamedQuery(name = "User.findByLastnamep", query = "SELECT u FROM User u WHERE u.lastnamep = :lastnamep"),
    @NamedQuery(name = "User.findByLastnamem", query = "SELECT u FROM User u WHERE u.lastnamem = :lastnamem"),
    @NamedQuery(name = "User.findByMail", query = "SELECT u FROM User u WHERE u.mail = :mail")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT")
    private Integer rut;
    @Size(max = 50)
    @Column(name = "NAME1")
    private String name1;
    @Size(max = 50)
    @Column(name = "NAME2")
    private String name2;
    @Size(max = 50)
    @Column(name = "LASTNAMEP")
    private String lastnamep;
    @Size(max = 50)
    @Column(name = "LASTNAMEM")
    private String lastnamem;
    @Size(max = 200)
    @Column(name = "MAIL")
    private String mail;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Student student;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Teacher teacher;

    public User() {
    }

    public User(Integer rut) {
        this.rut = rut;
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

    public String getLastnamep() {
        return lastnamep;
    }

    public void setLastnamep(String lastnamep) {
        this.lastnamep = lastnamep;
    }

    public String getLastnamem() {
        return lastnamem;
    }

    public void setLastnamem(String lastnamem) {
        this.lastnamem = lastnamem;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rut != null ? rut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.rut == null && other.rut != null) || (this.rut != null && !this.rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.usach.pingeso.taa.entityclasses.User[ rut=" + rut + " ]";
    }

    public void setLastNameP(String lastNameP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
