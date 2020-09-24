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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "sect_geo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SectGeo.findAll", query = "SELECT s FROM SectGeo s"),
    @NamedQuery(name = "SectGeo.findById", query = "SELECT s FROM SectGeo s WHERE s.id = :id"),
    @NamedQuery(name = "SectGeo.findByLibelle", query = "SELECT s FROM SectGeo s WHERE s.libelle = :libelle"),
    @NamedQuery(name = "SectGeo.findBySupprime", query = "SELECT s FROM SectGeo s WHERE s.supprime = :supprime"),
    @NamedQuery(name = "SectGeo.findByCode", query = "SELECT s FROM SectGeo s WHERE s.code = :code"),
    @NamedQuery(name = "SectGeo.findByDefaut", query = "SELECT s FROM SectGeo s WHERE s.defaut = :defaut")})
public class SectGeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Size(max = 255)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "defaut")
    private boolean defaut;
    @JoinTable(name = "lnkusersecteurgeo", joinColumns = {
        @JoinColumn(name = "listeSecteursGeo_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<User> userCollection;
    @ManyToMany(mappedBy = "sectGeoCollection", fetch = FetchType.LAZY)
    private Collection<Candidatsalarie> candidatsalarieCollection;
    @OneToMany(mappedBy = "idSecteur", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection;
    @OneToMany(mappedBy = "idSecteur", fetch = FetchType.LAZY)
    private Collection<Client> clientCollection;
    @JoinColumn(name = "idRegion", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Regions idRegion;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;

    public SectGeo() {
    }

    public SectGeo(Long id) {
        this.id = id;
    }

    public SectGeo(Long id, boolean supprime, boolean defaut) {
        this.id = id;
        this.supprime = supprime;
        this.defaut = defaut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getDefaut() {
        return defaut;
    }

    public void setDefaut(boolean defaut) {
        this.defaut = defaut;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<Candidatsalarie> getCandidatsalarieCollection() {
        return candidatsalarieCollection;
    }

    public void setCandidatsalarieCollection(Collection<Candidatsalarie> candidatsalarieCollection) {
        this.candidatsalarieCollection = candidatsalarieCollection;
    }

    @XmlTransient
    public Collection<Sc> getScCollection() {
        return scCollection;
    }

    public void setScCollection(Collection<Sc> scCollection) {
        this.scCollection = scCollection;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    public Regions getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Regions idRegion) {
        this.idRegion = idRegion;
    }

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
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
        if (!(object instanceof SectGeo)) {
            return false;
        }
        SectGeo other = (SectGeo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.SectGeo[ id=" + id + " ]";
    }
    
}
