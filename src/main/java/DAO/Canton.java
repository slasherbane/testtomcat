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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benjamin
 */
@Entity
@Table(name = "canton")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canton.findAll", query = "SELECT c FROM Canton c"),
    @NamedQuery(name = "Canton.findById", query = "SELECT c FROM Canton c WHERE c.id = :id"),
    @NamedQuery(name = "Canton.findByCode", query = "SELECT c FROM Canton c WHERE c.code = :code"),
    @NamedQuery(name = "Canton.findByLibelle", query = "SELECT c FROM Canton c WHERE c.libelle = :libelle")})
public class Canton implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 2)
    @Column(name = "code")
    private String code;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(mappedBy = "idCantonCorr", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection;
    @OneToMany(mappedBy = "idCantonLiv", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection1;
    @OneToMany(mappedBy = "idCanton", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection2;
    @OneToMany(mappedBy = "idCanton", fetch = FetchType.LAZY)
    private Collection<Candidatsalarie> candidatsalarieCollection;
    @OneToMany(mappedBy = "idCanton", fetch = FetchType.LAZY)
    private Collection<Client> clientCollection;

    public Canton() {
    }

    public Canton(Long id) {
        this.id = id;
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

    @XmlTransient
    public Collection<Sc> getScCollection() {
        return scCollection;
    }

    public void setScCollection(Collection<Sc> scCollection) {
        this.scCollection = scCollection;
    }

    @XmlTransient
    public Collection<Sc> getScCollection1() {
        return scCollection1;
    }

    public void setScCollection1(Collection<Sc> scCollection1) {
        this.scCollection1 = scCollection1;
    }

    @XmlTransient
    public Collection<Sc> getScCollection2() {
        return scCollection2;
    }

    public void setScCollection2(Collection<Sc> scCollection2) {
        this.scCollection2 = scCollection2;
    }

    @XmlTransient
    public Collection<Candidatsalarie> getCandidatsalarieCollection() {
        return candidatsalarieCollection;
    }

    public void setCandidatsalarieCollection(Collection<Candidatsalarie> candidatsalarieCollection) {
        this.candidatsalarieCollection = candidatsalarieCollection;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
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
        if (!(object instanceof Canton)) {
            return false;
        }
        Canton other = (Canton) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Canton[ id=" + id + " ]";
    }
    
}
