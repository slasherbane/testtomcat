/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Benjamin
 */
@Entity
@Table(name = "groupe_remise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupeRemise.findAll", query = "SELECT g FROM GroupeRemise g"),
    @NamedQuery(name = "GroupeRemise.findById", query = "SELECT g FROM GroupeRemise g WHERE g.id = :id"),
    @NamedQuery(name = "GroupeRemise.findByDateCreation", query = "SELECT g FROM GroupeRemise g WHERE g.dateCreation = :dateCreation"),
    @NamedQuery(name = "GroupeRemise.findByDateMaj", query = "SELECT g FROM GroupeRemise g WHERE g.dateMaj = :dateMaj"),
    @NamedQuery(name = "GroupeRemise.findByDateSuppression", query = "SELECT g FROM GroupeRemise g WHERE g.dateSuppression = :dateSuppression"),
    @NamedQuery(name = "GroupeRemise.findBySupprime", query = "SELECT g FROM GroupeRemise g WHERE g.supprime = :supprime"),
    @NamedQuery(name = "GroupeRemise.findByLibelle", query = "SELECT g FROM GroupeRemise g WHERE g.libelle = :libelle")})
public class GroupeRemise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateMaj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMaj;
    @Column(name = "dateSuppression")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppression;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supprime")
    private boolean supprime;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(mappedBy = "idGroupe", fetch = FetchType.LAZY)
    private Collection<Sc> scCollection;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;

    public GroupeRemise() {
    }

    public GroupeRemise(Long id) {
        this.id = id;
    }

    public GroupeRemise(Long id, boolean supprime) {
        this.id = id;
        this.supprime = supprime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(Date dateMaj) {
        this.dateMaj = dateMaj;
    }

    public Date getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(Date dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    public boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
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
        if (!(object instanceof GroupeRemise)) {
            return false;
        }
        GroupeRemise other = (GroupeRemise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.GroupeRemise[ id=" + id + " ]";
    }
    
}
