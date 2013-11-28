/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.usach.pingeso.taa.entityclasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author José Orellana
 */
@Entity
@Table(name = "photo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photo.findAll", query = "SELECT p FROM Photo p"),
    @NamedQuery(name = "Photo.findByIdPhoto", query = "SELECT p FROM Photo p WHERE p.idPhoto = :idPhoto"),
    @NamedQuery(name = "Photo.findByUrl", query = "SELECT p FROM Photo p WHERE p.url = :url")})
public class Photo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PHOTO")
    private Integer idPhoto;
    @Size(max = 200)
    @Column(name = "URL")
    private String url;
    @JoinColumn(name = "RUT", referencedColumnName = "RUT")
    @ManyToOne
    private Student rut;

    public Photo() {
    }

    public Photo(Integer idPhoto) {
        this.idPhoto = idPhoto;
    }

    public Integer getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(Integer idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Student getRut() {
        return rut;
    }

    public void setRut(Student rut) {
        this.rut = rut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPhoto != null ? idPhoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photo)) {
            return false;
        }
        Photo other = (Photo) object;
        if ((this.idPhoto == null && other.idPhoto != null) || (this.idPhoto != null && !this.idPhoto.equals(other.idPhoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.usach.pingeso.taa.entityclasses.Photo[ idPhoto=" + idPhoto + " ]";
    }
    
}
