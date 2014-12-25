/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "procreator", catalog = "tableapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Procreator.findAll", query = "SELECT p FROM Procreator p"),
    @NamedQuery(name = "Procreator.findByNameCreator", query = "SELECT p FROM Procreator p WHERE p.nameCreator = :nameCreator"),
    @NamedQuery(name = "Procreator.findByTNumber", query = "SELECT p FROM Procreator p WHERE p.tNumber = :tNumber"),
    @NamedQuery(name = "Procreator.findByFax", query = "SELECT p FROM Procreator p WHERE p.fax = :fax"),
    @NamedQuery(name = "Procreator.findByEMail", query = "SELECT p FROM Procreator p WHERE p.eMail = :eMail")})
public class Procreator implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name_creator")
    private String nameCreator;
    @Basic(optional = false)
    @Column(name = "t_number")
    private String tNumber;
    @Basic(optional = false)
    @Column(name = "fax")
    private String fax;
    @Basic(optional = false)
    @Column(name = "e_mail")
    private String eMail;

    public Procreator() {
    }

    public Procreator(String nameCreator) {
        this.nameCreator = nameCreator;
    }

    public Procreator(String nameCreator, String tNumber, String fax, String eMail) {
        this.nameCreator = nameCreator;
        this.tNumber = tNumber;
        this.fax = fax;
        this.eMail = eMail;
    }

    public String getNameCreator() {
        return nameCreator;
    }

    public void setNameCreator(String nameCreator) {
        String oldNameCreator = this.nameCreator;
        this.nameCreator = nameCreator;
        changeSupport.firePropertyChange("nameCreator", oldNameCreator, nameCreator);
    }

    public String getTNumber() {
        return tNumber;
    }

    public void setTNumber(String tNumber) {
        String oldTNumber = this.tNumber;
        this.tNumber = tNumber;
        changeSupport.firePropertyChange("TNumber", oldTNumber, tNumber);
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        String oldFax = this.fax;
        this.fax = fax;
        changeSupport.firePropertyChange("fax", oldFax, fax);
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        String oldEMail = this.eMail;
        this.eMail = eMail;
        changeSupport.firePropertyChange("EMail", oldEMail, eMail);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameCreator != null ? nameCreator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procreator)) {
            return false;
        }
        Procreator other = (Procreator) object;
        if ((this.nameCreator == null && other.nameCreator != null) || (this.nameCreator != null && !this.nameCreator.equals(other.nameCreator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Procreator[ nameCreator=" + nameCreator + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
