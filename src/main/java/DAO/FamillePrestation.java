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
@Table(name = "famille_prestation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamillePrestation.findAll", query = "SELECT f FROM FamillePrestation f"),
    @NamedQuery(name = "FamillePrestation.findById", query = "SELECT f FROM FamillePrestation f WHERE f.id = :id"),
    @NamedQuery(name = "FamillePrestation.findByDateCreation", query = "SELECT f FROM FamillePrestation f WHERE f.dateCreation = :dateCreation"),
    @NamedQuery(name = "FamillePrestation.findByDateMaj", query = "SELECT f FROM FamillePrestation f WHERE f.dateMaj = :dateMaj"),
    @NamedQuery(name = "FamillePrestation.findByDateSuppression", query = "SELECT f FROM FamillePrestation f WHERE f.dateSuppression = :dateSuppression"),
    @NamedQuery(name = "FamillePrestation.findBySupprime", query = "SELECT f FROM FamillePrestation f WHERE f.supprime = :supprime"),
    @NamedQuery(name = "FamillePrestation.findByCode", query = "SELECT f FROM FamillePrestation f WHERE f.code = :code"),
    @NamedQuery(name = "FamillePrestation.findByLibelle", query = "SELECT f FROM FamillePrestation f WHERE f.libelle = :libelle")})
public class FamillePrestation implements Serializable {

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
    @Column(name = "code")
    private String code;
    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;
    @JoinColumn(name = "idSoc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Soc idSoc;
    @OneToMany(mappedBy = "idFamille", fetch = FetchType.LAZY)
    private Collection<Prestations> prestationsCollection;

    public FamillePrestation() {
    }

    public FamillePrestation(Long id) {
        this.id = id;
    }

    public FamillePrestation(Long id, boolean supprime) {
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

    public Soc getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(Soc idSoc) {
        this.idSoc = idSoc;
    }

    @XmlTransient
    public Collection<Prestations> getPrestationsCollection() {
        return prestationsCollection;
    }

    public void setPrestationsCollection(Collection<Prestations> prestationsCollection) {
        this.prestationsCollection = prestationsCollection;
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
        if (!(object instanceof FamillePrestation)) {
            return false;
        }
        FamillePrestation other = (FamillePrestation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.FamillePrestation[ id=" + id + " ]";
    }
    
}
