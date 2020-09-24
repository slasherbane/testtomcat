/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benjamin
 */
@Entity
@Table(name = "regions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regions.findAll", query = "SELECT r FROM Regions r"),
    @NamedQuery(name = "Regions.findById", query = "SELECT r FROM Regions r WHERE r.id = :id"),
    @NamedQuery(name = "Regions.findByCode", query = "SELECT r FROM Regions r WHERE r.code = :code"),
    @NamedQuery(name = "Regions.findByLibelle", query = "SELECT r FROM Regions r WHERE r.libelle = :libelle"),
    @NamedQuery(name = "Regions.findBySupprime", query = "SELECT r FROM Regions r WHERE r.supprime = :supprime"),
    @NamedQuery(name = "Regions.findByIdSoc", query = "SELECT r FROM Regions r WHERE r.idSoc = :idSoc")})
public class Regions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "code")
    private String code;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSoc")
    private long idSoc;
    @OneToMany(mappedBy = "idRegion", fetch = FetchType.LAZY)
    private Collection<SectGeo> sectGeoCollection;

    public Regions() {
    }

    public Regions(Long id) {
        this.id = id;
    }

    public Regions(Long id, boolean supprime, long idSoc) {
        this.id = id;
        this.supprime = supprime;
        this.idSoc = idSoc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
    }

    public long getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(long idSoc) {
        this.idSoc = idSoc;
    }

    @XmlTransient
    public Collection<SectGeo> getSectGeoCollection() {
        return sectGeoCollection;
    }

    public void setSectGeoCollection(Collection<SectGeo> sectGeoCollection) {
        this.sectGeoCollection = sectGeoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regions)) {
            return false;
        }
        Regions other = (Regions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Regions[ id=" + id + " ]";
    }
    
}
