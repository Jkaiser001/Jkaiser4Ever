/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.usach.pingeso.taa.entityclasses;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author José Orellana
 */
@Embeddable
public class AttendancePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT")
    private int rut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ATTENDANCE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date attendanceDate;

    public AttendancePK() {
    }

    public AttendancePK(int rut, Date attendanceDate) {
        this.rut = rut;
        this.attendanceDate = attendanceDate;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rut;
        hash += (attendanceDate != null ? attendanceDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttendancePK)) {
            return false;
        }
        AttendancePK other = (AttendancePK) object;
        if (this.rut != other.rut) {
            return false;
        }
        if ((this.attendanceDate == null && other.attendanceDate != null) || (this.attendanceDate != null && !this.attendanceDate.equals(other.attendanceDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.usach.pingeso.taa.entityclasses.AttendancePK[ rut=" + rut + ", attendanceDate=" + attendanceDate + " ]";
    }
    
}
